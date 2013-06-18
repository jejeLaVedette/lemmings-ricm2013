package lemmings;

public abstract class Observable {
	
	protected int type;
	protected int x;
	protected int y;
	protected int etat;
	protected String image;
	protected int imageCourante = 0;
	protected int sousAction = 0;
	protected String condPrecedente = "";
	
	protected double elasticite;
	protected double Xprec;
	protected double Yprec;
	protected double time;
	public Observable () {
		elasticite = 0.6;
		Xprec = 0;
		Yprec = 0;
		time = 0.1;
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

	public double getXp() {
		return Xprec;
	}

	public double getYp() {
		return Yprec;
	}

	public void setXp(double d) {
		this.Xprec = d;
	}

	public void setYp(double vy) {
		this.Yprec = vy;
	}
	public void setTime(){
		time = time +0.1;
	}
	public void resetTime(){
		time=0.1;
	}

	public int getImageCourante() {
		return imageCourante;
	}

	public void setImageCourante(int imageCourante) {
		this.imageCourante = imageCourante;
	}

	public int getSousAction() {
		return sousAction;
	}

	public void setSousAction(int sousAction) {
		this.sousAction = sousAction;
	}

	public String getCondPrecedente() {
		return condPrecedente;
	}

	public void setCondPrecedente(String condPrecedente) {
		this.condPrecedente = condPrecedente;
	}
	
	
	
	
	
}
