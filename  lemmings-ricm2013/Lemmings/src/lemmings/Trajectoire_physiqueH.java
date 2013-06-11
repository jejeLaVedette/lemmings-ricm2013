package lemmings;
import java.awt.Point;
public class Trajectoire_physiqueH implements Constantes {
	private int base_x;
	private int base_y;
	private int vect_x;
	private int vect_y;
	private int constante;

	private boolean sens_courbe;//True=courbe vers le haut
	
	public Trajectoire_physiqueH(int x,int y,int vx,int vy,boolean sens){
		this.base_x=x;
		this.base_y=y;
		this.vect_x=vx;
		this.vect_y=-vy;
		this.sens_courbe=sens;
		this.constante=y-get_trajectoireY(base_x);
		
		
	}
	public int get_vect_x(){
		return this.vect_x;
		}
	public int get_vect_y(){
		return this.vect_y;
	}
	//Renvoit le sommet max atteint
	public int get_sommet(){
		if(this.sens_courbe==true){
		return (int)this.get_s().getY();
		}
		else
		{
			return (int)((-this.get_s().getY()+this.get_f().getY())+this.get_f().getY());			
		}
	}
	//Renvoit le x ou le lemming reatterit sur un sol horizontal
	public int get_atterissage(){
		return (int) this.get_f().getX()+this.vect_x;
	}
	
	//Calcul les coordonnées du foyer de l'ellipse
	private Point get_f(){
		 Point a=new Point((this.vect_x+this.base_x),this.base_y);
		 return a;
	}
	
	
	//Renvoit la coordonnées y de la directrice D
	private double get_d(){
		int calculnorme;
		if(this.vect_y==coeffdecalagedirectrice)
		{
		calculnorme=this.base_y-this.vect_y-coeffdecalagedirectrice-10;
		}
		else{
			calculnorme=this.base_y-this.vect_y-coeffdecalagedirectrice;
			
		}
		return calculnorme;			
	}
	
	//Calcul des coordonnées du point O,projeté orthogonal de F sur D
	private Point get_o(){		
		int x= (int)this.get_f().getX();
		int y=(int)this.get_d();
		Point o=new Point(x,y);
		return o;
	}
	
	//Calcul des coordonnées de S ,milieu de OF
	private Point get_s(){
		int x =(int)this.get_f().getX();
		int y;
		y =(int)(((this.get_f().getY())+(this.get_o().getY()))/2);
		Point s=new Point(x,y);
		return s;
	}
	
	//Calcul de p,distance OF
	private double get_p(){
		double rep= this.get_f().getY()-this.get_o().getY();
		return Math.abs((int)rep);		
	}
	
	//Retourne le x relatif par rapport au repere S
	private int get_XpourS (int x){
	return	x-(int)this.get_s().getX();
		
	}
	//RetourS. Si sens=true-> En haut,false->en bas
	private int get_YpourS(int x){
		int yrel;
		int temp=(int)this.get_p();
	
		if(temp==0){
			yrel=this.base_y;
			}
			else{
				yrel=(x*x)/(2*temp);		
			}
		if(this.sens_courbe)
		{
		return yrel;
		}
		else{
			return -yrel;
		}		
	}
	
	public int get_trajectoireY(int x){
		int yrel;
		int rep;
		yrel=this.get_YpourS(this.get_XpourS(x));
		rep=((int)this.get_s().getY())+yrel;
		return rep+constante;
		
	}
	
	
	

}
