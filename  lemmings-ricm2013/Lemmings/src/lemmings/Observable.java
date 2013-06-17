package lemmings;

public class Observable {
	
	protected int type;
	protected int x;
	protected int etat;
	protected int y;
	protected String image;
	
	protected double elasticite;
	protected int Xprec;
	protected int Yprec;
	protected double time;
	public Observable () {
		elasticite = 0.5;
		Xprec = 0;
		Yprec = 0;
		time = 0.05;
	}
	
	public Observable(int vx, int vy) {
		elasticite = 0;
		this.Xprec = vx;
		this.Yprec=  vy;
	}
	
	public Observable(int vx, int vy, double elas) {
		this.Xprec = vx;
		this.Yprec = vy;
		this.elasticite = elas;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

	public double getElasticite() {
		return elasticite;
	}

	public void setElasticite(double elasticite) {
		this.elasticite = elasticite;
	}

	public int getXp() {
		return Xprec;
	}

	public int getYp() {
		return Yprec;
	}

	public void setXp(int vx) {
		this.Xprec = vx;
	}

	public void setYp(int vy) {
		this.Yprec = vy;
	}
	public void setTime(){
		time = time +0.05;
	}
	public void resetTime(){
		time=0;
	}
	
}
