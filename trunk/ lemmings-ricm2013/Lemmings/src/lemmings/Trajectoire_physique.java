package lemmings;
import java.awt.Point;






public class Trajectoire_physique {
	private int base_x;
	private int base_y;
	private int vect_x;
	private int vect_y;
	
	public Trajectoire_physique(int x,int y,int vx,int vy){
		this.base_x=x;
		this.base_y=y;
		this.vect_x=vx;
		this.vect_y=vy;
	}
	
	private Point get_f(){
		 Point a=new Point((vect_x+base_x),base_y);
		 
		 return a;
	}
	
	private double get_d(){
		int calculnorme=vect_x*vect_x+vect_y*vect_y;
		
			return Math.sqrt(calculnorme);	
		
	}
	
	
	
	private Point get_s(){
		int x =(int)this.get_f().getX();
		int y =(int)((this.get_f().getY())+this.get_d())/2;
		Point s=new Point(x,y);
		return s;
	}
	
	private double get_p(){
		double rep= this.get_f().getY()-this.get_d();
		return rep;		
	}
	
	private int get_XpourS (int x){
	return	x-(int)this.get_s().getX();
		
	}
	
	public int get_trajectoireY(int x){
		int xrel=this.get_XpourS(x);
		int temp=(int)this.get_p();
		int yrel;
		if(temp==0){
		yrel=(xrel*xrel)/2;
		}
		else{
			yrel=(xrel*xrel)/(2*temp);		
		}
		int ydepart=(int)this.get_s().getY()-yrel;
		return -ydepart+(int)base_y;
		
	}
	
	
	

}
