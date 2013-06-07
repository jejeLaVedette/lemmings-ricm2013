package lemmings;
import java.awt.Point;






public class Trajectoire_physique {
	private double base_x;
	private double base_y;
	private double vect_x;
	private double vect_y;
	
	public Trajectoire_physique(int x,int y,int vx,int vy){
		this.base_x=(double)x;
		this.base_y=(double)y;
		this.vect_x=(double)vx;
		this.vect_y=(double)vy;
	}
	
	private Point get_f(){
		 Point a=new Point((int)(vect_x+base_x),(int)base_y);
		 
		 return a;
	}
	
	private double get_d(){
		double calculnorme=vect_x*vect_x+vect_y*vect_y;
		if(calculnorme>=0)
		{
			return Math.sqrt(calculnorme);	
		}
		else{
		return -Math.sqrt(-calculnorme);
		}
	}
	
	
	
	private Point get_s(){
		int x =(int)get_f().getX();
		int y =(int)((get_f().getY())+get_d())/2;
		Point s=new Point(x,y);
		return s;
	}
	
	private double get_p(){
		double rep= get_f().getY()-get_d();
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
