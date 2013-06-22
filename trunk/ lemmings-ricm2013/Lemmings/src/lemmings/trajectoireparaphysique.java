package lemmings;

import java.awt.Point;


public class trajectoireparaphysique implements Constantes {

	private int base_x;
	private int base_y;
	private double Vx;
	private double Vy;
	private double masse;
	private double coefftrainee;
	private double prof;
	private double haut;
	private double large;


	public trajectoireparaphysique(int bx, int by,double vecx,double vecy,int type){
		this.base_x=bx;
		this.base_y=by;
		this.Vx=vecx;
		this.Vy=vecy;
		switch(type){
		case 1:
			this.masse=masselemming;
			this.prof=proflemmings;
			this.haut=hauteurlemmings;
			this.large=larglemmings;
			this.coefftrainee=coefftraineelemming;
			break;
		default:
			this.masse=masselemming;
			this.prof=proflemmings;
			this.haut=hauteurlemmings;
			this.large=larglemmings;
			this.coefftrainee=coefftraineelemming;
			break;
		}

	}



	public trajectoireparaphysique(int bx, int by,int norme,double angle,int type){
		this.base_x=bx;
		this.base_y=by;
		this.Vx=norme*Math.cos(angle);
		this.Vy=norme*Math.sin(angle);		
		switch(type){
		case 1:
			this.masse=masselemming;
			this.prof=proflemmings;
			this.haut=hauteurlemmings;
			this.large=larglemmings;
			this.coefftrainee=coefftraineelemming;
			break;
		default:
			this.masse=masselemming;
			this.prof=proflemmings;
			this.haut=hauteurlemmings;
			this.large=larglemmings;
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
		double x= (1.0/2)*massevolair*this.haut*this.prof*this.coefftrainee*this.Vx*coeffvxkx; 		 
		return x;

	}
	private double calculky (){
		double y=(1.0/2)*massevolair*this.large*this.prof*this.coefftrainee*this.Vy*coeffvyky;
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
			this.Vy=0.00001;
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

	public void calculcolision(double xcoli,double ycoli,double xprec,double yprec,double xbase,double ybase,double coeff1,double coeff2,boolean type){


		if(!type){
			this.Vx=(coeffbondvx*(xcoli-xprec)/(2*deltat));
			this.Vy= (-(ycoli-yprec)/(2*deltat));
		}
		else{
			this.Vx=(coeffbondvy*(xcoli-xprec)/(2*deltat));
			this.Vy= (-(ycoli-yprec)/(2*deltat));
		}

		this.base_x=(int)xbase;
		this.base_y=(int)ybase ;
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