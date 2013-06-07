package lemmings;

import java.awt.Color;

public class Sol extends Element {
	
	public Sol() {
		super.type = 0;
		super.couleur = new Color(0,0,0);
	}
	
	public Sol(Color c) {
		super.type = 0;
		super.couleur = c;
	}

}
