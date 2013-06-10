package lemmings;

public class Lemming extends Observable implements Constantes {
	
	private int direction;
	private int etat;
	
	public Lemming() {
		super.type = lemmingBase;
		this.direction = droite;
		this.image = "Images/lemming1.png";
		this.etat = etatInitial;
		super.x = Carte.getEntree().x;
		super.y = Carte.getEntree().y;
	}
	
	public Lemming(int x,int y) {
		super.type = lemmingBase;
		this.direction = droite;
		this.image = "Images/lemming1.png";
		this.etat = etatInitial;
		super.x = x;
		super.y = y;
	}
	
	public Lemming(int x,int y, int type) {
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

}
