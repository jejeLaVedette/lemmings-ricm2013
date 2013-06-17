package lemmings;

import java.awt.Color;

public abstract class Element implements Constantes{
	
	protected int type;	
	protected Color couleur;
	
	public boolean isAir() {
		if(this.type>=typeAirInf && this.type<=typeAirSup) return true;
		return false;
	}
	
	public boolean isSol() {
		if(this.type>=typeSolInf && this.type<=typeSolSup) return true;
		return false;
	}
}
