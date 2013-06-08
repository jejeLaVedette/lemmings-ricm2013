package lemmings;

public class Lemming extends Observable {
	
	private int direction;
	private int etat;
	
	public Lemming() {
		super.type = 0;
		this.direction = 1;
		this.image = "Images/lemming1.png";
		this.etat = 0;
		super.x = Carte.getEntree().x;
		super.y = Carte.getEntree().y;
	}
	
	public Lemming(int x,int y) {
		super.type = 0;
		this.direction = 1;
		this.image = "Images/lemming1.png";
		this.etat = 0;
		super.x = x;
		super.y = y;
	}
	
	public Lemming(int x,int y, int type) {
		super.type = type;
		this.direction = 1;
		this.image = "Images/lemming1.png";
		this.etat = 0;
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
