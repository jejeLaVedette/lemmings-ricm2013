package lemmings;

import java.awt.Color;

public class Air extends Element implements Constantes {
	
	private double resistance;

	public Air () {
		super.type = typeAirInf;
		super.couleur = defautAir;
		resistance = 0;
	}
	
	public Air (Color c) {
		super.type = typeAirInf;
		super.couleur = c;
		resistance = 0;
	}
	
	public Air (Color c, double resist) {
		super.type = typeAirInf;
		super.couleur = c;
		resistance = resist;
	}
	
	public Air (double resist) {
		super.type = typeAirInf;
		super.couleur = defautAir;
		resistance = resist;
	}
	
	public double getResistance() {
		return resistance;
	}

	public void setResistance(double resistance) {
		this.resistance = resistance;
	}

}
