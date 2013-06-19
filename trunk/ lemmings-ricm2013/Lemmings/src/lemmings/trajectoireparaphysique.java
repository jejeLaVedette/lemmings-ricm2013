package lemmings;


public class trajectoireparaphysique implements Constantes {

	private int base_x;
	private int base_y;
	private double Vx;
	private double Vy;
	private double masse;
	
	
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
		
		 double x= (1.0/2)*massevolair*hauteurlemmings*proflemmings*coefftraineelemming*this.Vx*0.6; 		 
		 return x;
		 
	 }
	 private double calculky (){
		 double y=(1.0/2)*massevolair*larglemmings*proflemmings*coefftraineelemming*this.Vy*0.6;
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
			 return this.base_y;
		 }
		 else{
		
		 return ((double)this.base_y-((this.masse/this.calculky())*(this.Vy+((this.masse/this.calculky())*coeffgravite))*(1-Math.exp(-(this.calculky()/this.masse)*t))-((this.masse/this.calculky())*coeffgravite*t)));
		 }
	 }
	 
	 //type= true->colision avec mur vertical
	 
	 public void calculcolision(double xcoli,double ycoli,double xprec,double yprec,double xbase,double ybase,double coeff1,double coeff2,boolean type){
		 
		
		if(!type){
		 this.Vx=((xcoli-xprec)/(2*deltat));
		 this.Vy= (-(ycoli-yprec)/(2*deltat));
		}
		else{
			this.Vx=((xcoli-xprec)/(2*deltat));
			 this.Vy= (-(ycoli-yprec)/(2*deltat));
		}
		 System.out.println("Percussion");
		 System.out.println("valeur de Vx ");			
	     System.out.println(Vx);
		 System.out.println("valeur de Vy ");			
	     System.out.println(Vy);
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