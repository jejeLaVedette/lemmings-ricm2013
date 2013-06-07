package lemmings;

public class Lemming extends Observable {
	
	private int direction;
	private int etat;
	
	public Lemming(int x,int y) {
		super.type = 2;
		this.direction = 1;
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
