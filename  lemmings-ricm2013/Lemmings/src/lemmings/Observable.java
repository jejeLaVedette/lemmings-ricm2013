package lemmings;

public class Observable {
	
	protected int type;
	protected int x;
	protected int etat;
	protected int y;
	protected String image;
	
	protected double elasticite;
	protected double vx;
	protected double vy;
	
	public Observable () {
		elasticite = 0;
		vx = 0;
		vy = 0;
	}
	
	public Observable(double vx, double vy) {
		elasticite = 0;
		this.vx = vx;
		this.vy = vy;
	}
	
	public Observable(double vx, double vy, double elas) {
		this.vx = vx;
		this.vy = vy;
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

	public double getVx() {
		return vx;
	}

	public double getVy() {
		return vy;
	}

	public void setVx(double vx) {
		this.vx = vx;
	}

	public void setVy(double vy) {
		this.vy = vy;
	}
	
}
