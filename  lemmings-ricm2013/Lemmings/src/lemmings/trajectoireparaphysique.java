package lemmings;

import java.awt.Point;


public class trajectoireparaphysique implements Constantes {

	private int base_x;
	private int base_y;
	private double Vx;
	private double Vy;
	private double masse;
	private double coefftrainee;
	private double surfx;
	private double surfy;
	

//Constructeur prenant en parametre les coordonnées du point de départ,les composantes vx/vy de la vitesse
// et le type de l'objet dont la trajectoire sera calculée
	public trajectoireparaphysique(int bx, int by,double vecx,double vecy,int type){
		this.base_x=bx;
		this.base_y=by;
		this.Vx=vecx;
		this.Vy=vecy;
		switch(type){
		case 1:
			this.masse=masselemming;
			this.surfx=proflemmings*hauteurlemmings;
			this.surfy=proflemmings*larglemmings;
			this.coefftrainee=coefftraineelemming;
			break;
		default:
			this.masse=masselemming;
			this.surfx=proflemmings*hauteurlemmings;
			this.surfy=proflemmings*larglemmings;
			this.coefftrainee=coefftraineelemming;
			break;
		}

	}


//Constructeur prenant en parametre les coordonnées du point de départ,la norme et l'angle par rapport
	//a l horizontale du vecteur vitesse,et le type de l'objet dont la trajectoire sera calculée.
	public trajectoireparaphysique(int bx, int by,int norme,double angle,int type){
		this.base_x=bx;
		this.base_y=by;
		this.Vx=norme*Math.cos(angle);
		this.Vy=norme*Math.sin(angle);		
		switch(type){
		case 1:
			this.masse=masselemming;
			this.surfx=proflemmings*hauteurlemmings;
			this.surfy=proflemmings*larglemmings;
			this.coefftrainee=coefftraineelemming;
			break;
		default:
			this.masse=masselemming;
			this.surfx=proflemmings*hauteurlemmings;
			this.surfy=proflemmings*larglemmings;
			this.coefftrainee=coefftraineelemming;
			break;
		}

	}
	public double getVx (){
		return this.Vx;

	}
	public double getVy (){
		return this.Vy;

	}
	
	private double calculkx (){
		double x= (1.0/2)*massevolair*this.surfx*this.coefftrainee*this.Vx*coeffvxkx; 		 
		return x;

	}
	private double calculky (){
		double y=(1.0/2)*massevolair*this.surfy*this.coefftrainee*this.Vy*coeffvyky;
		return y; 

	}

	public double calculx(double t){
		if (this.Vx==0){ 	
			return this.base_x;
		}
		else{	
			return (this.base_x+ ((this.masse/this.calculkx())*this.Vx*(1-Math.exp(-(this.calculkx()*t)/this.masse))));
		}
	}

	public double  calculy(double t){
		if (this.Vy==0){ 	
			return this.base_y-1;
		}


		return ((double)this.base_y-((this.masse/this.calculky())*(this.Vy+((this.masse/this.calculky())*coeffgravite))*(1-Math.exp(-(this.calculky()/this.masse)*t))-((this.masse/this.calculky())*coeffgravite*t)));

	}
	
	

	public Point trajectoire(double t)
	{
		Point rep=new Point(0,0);
		rep.setLocation(this.calculx(t), this.calculy(t));		
		return rep;
	}

	//type= true->colision avec mur vertical

	public void calculcolision(double xcal,double ycal,double xprec,double yprec,double xcoli,double ycoli,double coeff1,double coeff2,boolean type){


		if(!type){
			this.Vx=(coeffbondvx*(xcal-xprec)/(2*deltat));
			this.Vy= (-(ycal-yprec)/(2*deltat));
		}
		else{
			this.Vx=(coeffbondvy*(xcal-xprec)/(2*deltat));
			this.Vy= (-(ycal-yprec)/(2*deltat));
		}

		this.base_x=(int)xcoli;
		this.base_y=(int)ycoli ;
		double x=this.Vx;
		double y=this.Vy;
		double elastot=coeff1+coeff2;
		double mult=Math.sqrt(elastot);
		if(type==true)
		{
			this.Vx=-mult*x;
			this.Vy=mult*y;

		}
		else{
			this.Vx= mult*x;
			this.Vy=-mult*y;	

		}



	}


}