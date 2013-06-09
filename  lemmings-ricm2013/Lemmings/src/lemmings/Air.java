package lemmings;

import java.awt.Color;

public class Air extends Element {
	
	public Air () {
		super.type = 10;
		super.couleur = new Color(255,255,255);
	}
	
	public Air (Color c) {
		super.type = 10;
		super.couleur = c;
	}

}
