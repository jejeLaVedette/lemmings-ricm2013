package lemmings;
import java.math.*;

public class trajectoireparaphysique implements Constantes {

	private int base_x;
	private int base_y;
	private double Vx;
	private double Vy;
	private double masse;
	private double surface;
	
	public trajectoireparaphysique(int bx, int by,double vecx,double vecy,int type){
		this.base_x=bx;
		this.base_y=by;
		this.Vx=vecx;
		this.Vy=vecy;
		this.masse=masselemming;
		
	}
	public trajectoireparaphysique(int bx, int by,int norme,double angle,int type){
		this.base_x=bx;
		this.base_y=by;
		this.Vx=norme*Math.cos(angle);
		this.Vy=norme*Math.sin(angle);		
		this.masse=masselemming;
		
	}
	 public double getVx (){
			
		
		 
		 return this.Vx;
		 
	 }
	 public double getVy (){
			
		
		 
		 return this.Vy;
		 
	 }
	 private double calculkx (){
		
		 double x= (1.0/2)*massevolair*hauteurlemmings*proflemmings*coefftraineelemming*this.Vx*0.8; 
		 
		 return x;
		 
	 }
	 private double calculky (){
		 double y=(1.0/2)*massevolair*larglemmings*proflemmings*coefftraineelemming*this.Vy*0.8;
		 return y; 
		 
	 }
	 
	 public double calculx(double t){
		
		
		 return (this.base_x+ ((masselemming/this.calculkx())*this.Vx*(1-Math.exp(-(this.calculkx()*t)/masselemming))));
		 }
	 
	 public double  calculy(double t){
		
		 return (this.base_y-((masselemming/this.calculky())*(this.Vy+((masselemming/this.calculky())*coeffgravite))*(1-Math.exp(-(this.calculky()/masselemming)*t))-((masselemming/this.calculky())*coeffgravite*t)));
		 }
	 
	 //type= true->colision avec mur vertical
	 
	 public void calculcolision(double xcoli,double ycoli,double xprec,double yprec,double coeff1,double coeff2,boolean type){
		 
		
		 
		 this.Vx=(double)(2*((xcoli-xprec)/(2*deltat)));
		 this.Vy= (double)((-(ycoli-yprec)/(2*deltat)));
		 
		 System.out.println("valeur de Vx ");			
	     System.out.println(Vx);
		 System.out.println("valeur de Vy ");			
	     System.out.println(Vy);
		 this.base_x=(int)xcoli;
		 this.base_y=(int)ycoli -2;
		 double x=this.Vx;
		 double y=this.Vy;
		 double elastot=coeff1+coeff2;
		 double mult=Math.sqrt(elastot);
		 if(type==true)
		 {
			 this.Vx=-mult*x;
			 this.Vy=mult*y;
			 System.out.println("valeur de Vx2 ");			
				System.out.println(Vx);
				 System.out.println("valeur de Vy2 ");			
					System.out.println(Vy);
		 }
		 else{
			 this.Vx= mult*x;
			 this.Vy=-mult*y;	
			 System.out.println("valeur de Vx2");			
				System.out.println(Vx);
				 System.out.println("valeur de Vy2 ");			
					System.out.println(Vy);
		 }
		 
		 
		 
	 }
	 
	 public boolean estletale(int yprec,int compt)
	 {
		return true ; 
	 }
}
