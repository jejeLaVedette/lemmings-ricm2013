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
		if(vect_y<0)
		{
			return -Math.sqrt(calculnorme);	
		}
		else{
		return Math.sqrt(-calculnorme);
		}
	}
	
	
	
	private Point get_s(){
		int x =(int)get_f().getX();
		int y =(int)((get_f().getY())+get_d())/2;
		Point s=new Point(x,y);
		return s;
	}
	
	private double get_p(){
		double rep= get_f().getY()-Math.abs(get_d());
		return rep;		
	}
	
	private int get_XpourS (int x){
	return	x-(int)get_s().getX();
		
	}
	
	public int get_trajectoireY(int x){
		int xrel=get_XpourS(x);
		int yrel=(xrel*xrel)/(2*(int)get_p());
		int ydepart=(int)get_s().getY()+yrel;
		return ydepart+(int)base_y;
		
	}
	
	
	

}
