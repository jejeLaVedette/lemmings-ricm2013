package lemmings;

import java.awt.Color;

public interface Constantes {
	
	// Constantes de carte
	public final static int LARGEUR_CARTE = 500;
	public final static int HAUTEUR_CARTE = 200;
	public final static Color pixelAir = new Color(255,0,255);
	public final static Color defautAir = new Color(50,50,50);
	
	// Constantes des Elements
	public final static int typeSolInf = 0;
	public final static int typeSolSup = 9;
	public final static int typeAirInf = 10;
	public final static int typeAirSup = 19;
	public final static int typeSolInvisible = 1;
	
	// Constantes des Lemmings
	public final static int droite = 1;
	public final static int gauche = 0;
	
	// Constantes de la fenêtre
	
	// Constantes Automates
	public final static int etatInitial = 0;
	public final static int etatMort = -1;
	public final static int lemmingBase = 0;
	public final static int lemmingStop = 1;
	public final static int lemmingParapluie = 2;
	
	// Constantes de Jeu
	public final static int delaiAttente = 10;
	public final static int delaiPop = 50;

}
