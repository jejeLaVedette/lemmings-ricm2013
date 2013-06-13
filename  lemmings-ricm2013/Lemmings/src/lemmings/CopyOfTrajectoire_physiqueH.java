package lemmings;
import java.awt.Point;
public class CopyOfTrajectoire_physiqueH implements Constantes {
	private int base_x;
	private int base_y;
	private int vect_x;
	private int vect_y;
	private int constante;

	private int sens_courbe;//True=courbe vers le haut
	
	public CopyOfTrajectoire_physiqueH(int x,int y,int vx,int vy,int sens){
		this.base_x=x;
		this.base_y=y;
		this.vect_x=vx/2;
		this.vect_y=-vy;
		this.sens_courbe=sens;
		this.constante=y-get_trajectoire(base_x);
		
		
	}	
	//Renvoit la coordonnées y de la directrice D
	private double get_d(){
		int calculnorme;		
		calculnorme=this.base_y+2*this.vect_y;	
		return calculnorme;			
	}	
	//Calcul des coordonnées de S ,milieu de OF
	private Point get_s(){
		int x =this.base_x+this.vect_x;
		int y;
		y =(int)(this.base_y+this.vect_y);
		Point s=new Point(x,y);
		return s;
	}	
	//Calcul de p,distance OF
	private double get_p(){
		double rep= 2*this.vect_y;
		return Math.abs((int)rep);		
	}	
	//Retourne le x relatif par rapport au repere S
	private int get_XpourS (int x){
	return	x-this.base_x-this.vect_x;		
	}
	//RetourS. Si sens=true-> En haut,false->en bas
	private int get_YpourS(int x){
		int yrel;
		int temp=(int)this.get_p();
		yrel=(x*x)/(2*temp);			
		if(this.sens_courbe==haut)
		{
		return yrel;
		}
		else{
			return -yrel;
		}		
	}	
	private int get_trajectoire(int x){
		int yrel;
		int rep;
		yrel=this.get_YpourS(this.get_XpourS(x));
		rep=((int)this.get_s().getY())+yrel;
		return rep;		
	}	
	private Point get_favecconst(){
		 Point a=new Point((this.vect_x+this.base_x),this.base_y+this.constante);
		 return a;
	}	
	//Renvoit la coordonnées y de la directrice D
	private double get_davecconst(){
		return -this.constante+this.get_d();
	}
	
	//Calcul des coordonnées du point O,projeté orthogonal de F sur D
	private Point get_oavecconst(){		
		int x=this.base_x+this.vect_x;
		int y=(int)this.get_davecconst();
		Point o=new Point(x,y);
		return o;
	}
	private double get_pavecconst(){
		double rep= this.get_favecconst().getY()-this.get_oavecconst().getY();;
		return Math.abs((int)rep);		
	}
	private int get_YpourSavecconst(int x){
		int yrel;
		int temp=(int)this.get_pavecconst();
		yrel=(x*x)/(2*temp);			
		if(this.sens_courbe==haut)
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
		yrel=this.get_YpourSavecconst(this.get_XpourS(x));
		rep=((int)this.get_s().getY())+yrel;
		return rep;
		
	}
	
	
	
	

}
