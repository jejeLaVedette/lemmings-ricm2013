package lemmings;

import java.awt.Color;

public class Air extends Element implements Constantes {
	
	public Air () {
		super.type = typeAirInf;
		super.couleur = defautAir;
	}
	
	public Air (Color c) {
		super.type = typeAirInf;
		super.couleur = c;
	}

}
