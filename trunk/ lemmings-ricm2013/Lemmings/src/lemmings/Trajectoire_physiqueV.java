package lemmings;
import java.awt.Point;

//Mode d'emploi: passer en base_x base_y les coordonnées des points de colisions
//en vect_x et vect_y les coordonnées du vecteur de départ avant colision
public class Trajectoire_physiqueV implements Constantes {
	private int base_x;
	private int base_y;
	private int vect_x;
	private int vect_y;
	private int sens;
	private int constante;
	public boolean init;
	//sens true-> va vers la gauche
	public Trajectoire_physiqueV() {
		init = false;
	}
	
	public Trajectoire_physiqueV(int x,int y,int vx,int vy,int s){
		this.base_x=x;
		this.base_y=y;
		this.vect_x=(int)(vx*coeffreductionx);
		this.vect_y=(int)(-vy*coeffreductiony);	
		this.sens=s;
		this.constante=x-get_trajectoireX(base_y);
		this.init = true;
		
		
	}
	
	//Calcul les coordonnées du foyer de l'ellipse
	private Point get_fV(){
		 Point a=new Point((this.base_x),this.base_y+this.vect_y);
		 return a;
	}
	
	
	//Renvoit la coordonnées y de la directrice D
	private double get_dV(){
		int calculnorme;
		calculnorme=this.base_x+this.vect_x-coeffdecalagedirectrice;
		return calculnorme;			
	}
	
	//Calcul des coordonnées du point O,projeté orthogonal de F sur D
	private Point get_oV(){		
		int x= (int)this.get_dV();
		int y=(int)this.get_fV().getY();
		Point o=new Point(x,y);
		return o;
	}
	
	//Calcul des coordonnées de S ,milieu de OF
	private Point get_sV(){
		int y =(int)this.get_fV().getY();
		int x;
		x =(int)(((this.get_fV().getX())+(this.get_oV().getX()))/2);
		Point s=new Point(x,y);
		return s;
	}
	
	//Calcul de p,distance OF
	private double get_pV(){
		double rep= this.get_fV().getX()-this.get_oV().getX();
		return Math.abs((int)rep);		
	}
	
	//Retourne le x relatif par rapport au repere S
	private int get_XdansS (int y){
	return	(int)this.get_sV().getY()-y;
		
	}
	//RetourS. Si sens=true-> En haut,false->en bas
	private int get_YpourS(int xrel){
		int yrel;
		int temp=(int)this.get_pV();
	
		if(temp==0){
			yrel=(xrel*xrel)/2;
			}
			else{
				yrel=(xrel*xrel)/(2*temp);		
			}
		if(this.sens==gauche)
		{
		return -yrel;
		}
		else{
			return yrel;
		}		
	}
	
	public int get_trajectoireX(int y){
		int xrel;
		int rep;
		xrel=this.get_YpourS(this.get_XdansS(y));
		rep=((int)this.get_sV().getY())+xrel;
		return rep+constante;
		
	}
	public boolean doit_tomber(int y){
		if (y<get_oV().getY())
		{
			return true;
		}
		else {return false;}
	}
	
	


}
