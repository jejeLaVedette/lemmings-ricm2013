package lemmings;
import java.awt.Point;






public class CopyOfTrajectoire_physique {
	private int base_x;
	private int base_y;
	private int vect_x;
	private int vect_y;
	private int constante;

	private boolean sens_courbe;//True=courbe vers le haut
	
	public CopyOfTrajectoire_physique(int x,int y,int vx,int vy,boolean sens){
		this.base_x=x;
		this.base_y=y;
		this.vect_x=vx;
		this.vect_y=-vy;
		this.sens_courbe=sens;
		this.constante=y-get_trajectoireY(base_x);
		
		
	}
	
	//Calcul les coordonnées du foyer de l'ellipse
	private Point get_f(){
		 Point a=new Point((this.vect_x+this.base_x),this.base_y);
		 System.out.println("valeur de f");
		 System.out.println("x");
		 System.out.println(this.vect_x+this.base_x);
		 System.out.println("y");
		 System.out.println(this.base_y);
		 
		 
		 return a;
	}
	
	//Renvoit la coordonnées y de la directrice D
	private double get_d(){
		
		int calculnorme;
		calculnorme=this.base_y-this.vect_y-30;
		System.out.println("d");
		 System.out.println(calculnorme);
		return calculnorme;	
		/* calculnorme=vect_x*vect_x+vect_y*vect_y;
		
		return Math.sqrt(calculnorme);*/
		
	}
	
	//Calcul des coordonnées du point O,projeté orthogonal de F sur D
	private Point get_o(){
		
		int x= (int)this.get_f().getX();
		int y=(int)this.get_d();
		Point o=new Point(x,y);
		System.out.println("valeur de o");
		 System.out.println("x");
		 System.out.println(x);
		 System.out.println("y");
		 System.out.println(y);
		return o;
	}
	
	//Calcul des coordonnées de S ,milieu de OF
	private Point get_s(){
		int x =(int)this.get_f().getX();
		int y;
		
		 y =(int)(((this.get_f().getY())+(this.get_o().getY()))/2);
		
		Point s=new Point(x,y);
		System.out.println("valeur de s");
		 System.out.println("x");
		 System.out.println(x);
		 System.out.println("y");
		 System.out.println(y);
		return s;
	}
	
	//Calcul de p,distance OF
	private double get_p(){
		double rep= this.get_f().getY()-this.get_o().getY();
		 System.out.println("p");
		 System.out.println(rep);
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
			yrel=(x*x)/2;
			}
			else{
				yrel=(x*x)/(2*temp);		
			}
		if(this.sens_courbe)
		{
			System.out.println("valeur de y dans S");
			 System.out.println("y");
			 System.out.println(yrel);
		return yrel;
		}
		else{
			System.out.println("valeur de y dans S");
			 System.out.println("y");
			 System.out.println(-yrel);
			return -yrel;
		}
		
	}
	
	
	public int get_trajectoireY(int x){
		int yrel;
		int rep;
		yrel=this.get_YpourS(this.get_XpourS(x));
		rep=((int)this.get_s().getY())+yrel;
		System.out.println("valeur de y final ");
		 System.out.println(rep);
		return rep+constante;
		
	}
	
	
	

}
