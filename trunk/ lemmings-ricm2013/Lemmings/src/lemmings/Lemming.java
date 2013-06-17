package lemmings;

public class Lemming extends Observable implements Constantes {
	
	protected int direction; /*
	protected Trajectoire_physiqueV trajH;*/
	protected Trajectoire_physiqueV trajV;
	
	protected trajectoireparaphysique trajH;
	
	public Lemming() {
		super();
		super.type = lemmingBase;
		this.direction = droite;
		this.image = "Images/lemming1.png";
		this.etat = etatInitial;
		super.x = Carte.getEntree().x;
		super.y = Carte.getEntree().y;
	}
	
	public Lemming(int x,int y) {
		super();
		super.type = lemmingBase;
		this.direction = droite;
		this.image = "Images/lemming1.png";
		this.etat = etatInitial;
		super.x = x;
		super.y = y;
	}
	
	public Lemming(int x,int y, int type) {
		super();
		super.type = type;
		this.direction = droite;
		this.image = "Images/lemming1.png";
		this.etat = etatInitial;
		super.x = x;
		super.y = y;
	}
	
	public Lemming(int x,int y, int type, int vx, int vy) {
		super(vx,vy);
		super.type = type;
		this.direction = droite;
		this.image = "Images/lemming1.png";
		this.etat = etatInitial;
		super.x = x;
		super.y = y;
	}
	
	public Lemming(int x,int y, int type, int vx, int vy, double elas) {
		super(vx,vy,elas);
		super.type = type;
		this.direction = droite;
		this.image = "Images/lemming1.png";
		this.etat = etatInitial;
		super.x = x;
		super.y = y;
	}
	
	public int getDirection() {
		return direction;
	}

	public int getEtat() {
		return etat;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}
	
	public trajectoireparaphysique getTrajH() {
		return trajH;
	}

	public Trajectoire_physiqueV getTrajV() {
		return trajV;
	}

	public void setTrajH(trajectoireparaphysique trajH) {
		this.trajH = trajH;
	}

	public void setTrajV(Trajectoire_physiqueV trajV) {
		this.trajV = trajV;
	}

}
