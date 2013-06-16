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
		System.out.println("valeur de vx ");			
		System.out.println(this.Vx);
		this.Vy=norme*Math.sin(angle);
		System.out.println("valeur de vy ");			
		System.out.println(this.Vy);
		this.masse=masselemming;
		
	}
	 private double calculkx (){
		 
		 double x= (1.0/2)*massevolair*hauteurlemmings*proflemmings*coefftraineelemming;
		 System.out.println("valeur de kx ");			
			System.out.println(x);
		 return x;
		 
	 }
	 private double calculky (){
		 double y=(1.0/2)*massevolair*larglemmings*proflemmings*coefftraineelemming;
		 System.out.println("valeur de ky ");			
			System.out.println(y);
		 return y; 
		 
	 }
	 
	 public int calculx(double t){
		 return (int)(this.base_x+ ((masselemming/this.calculkx())*this.Vx*(1-Math.exp(-(this.calculkx()*t)/masselemming))));
	 }
	 public int calculy(double t){
		 return (int) (this.base_y-((masselemming/this.calculky())*(this.Vy+((masselemming/this.calculky())*coeffgravite))*(1-Math.exp(-(this.calculky()/masselemming)*t))-((masselemming/this.calculky())*coeffgravite*t)));
	 }
	 
}
