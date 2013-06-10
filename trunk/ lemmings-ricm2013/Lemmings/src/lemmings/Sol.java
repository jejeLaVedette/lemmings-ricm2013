package lemmings;

import java.awt.Color;

public class Sol extends Element implements Constantes {
	
	public Sol() {
		super.type = 0;
		super.couleur = defautSol;
	}
	
	public Sol(Color c) {
		super.type = typeSolInf;
		super.couleur = c;
	}

}
