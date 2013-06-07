package lemmings;

public class Lemming extends Element {
	
	private int direction;
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

	private int etat;
	
	public Lemming() {
		super.type = 2;
	}

}
