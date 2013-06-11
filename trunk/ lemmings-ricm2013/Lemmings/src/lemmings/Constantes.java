package lemmings;

import java.awt.Color;

public interface Constantes {
	
	// Constantes de carte
	public final static int LARGEUR_CARTE = 500;
	public final static int HAUTEUR_CARTE = 200;
	public final static Color pixelAir = new Color(255,0,255);
	public final static Color defautAir = new Color(50,50,50);
	public final static Color defautSol = new Color(0,0,0);
	
	// Constantes des Elements
	public final static int typeSolInf = 0;
	public final static int typeSolSup = 9;
	public final static int typeAirInf = 10;
	public final static int typeAirSup = 19;
	public final static int typeSolInvisible = 1;
	
	// Constantes des Lemmings
	public final static int droite = 1;
	public final static int gauche = 0;
	public final static int profondeurCreuser = 10;
	public final static int hauteurLetale = 20;
	
	// Constantes de la fenêtre
	public final static int coeff = 10;
	
	// Constantes Automates
	public final static int etatInitial = 0;
	public final static int etatMort = -1;
	public final static int etatReinit = -2;
	public final static int etatReinitParapluie = -3;
	public final static int lemmingBase = 0;
	public final static int lemmingStop = 1;
	public final static int lemmingParapluie = 2;
	public final static int lemmingCreuseur = 3;
	public final static int lemmingCatapulte = 4;
	
	// Constantes de Jeu
	public final static int delaiAttente = 10;
	public final static int delaiPop = 50;
	
	// Constantes trajectoires
	public final static double coeffreductionx= 1;
	public final static double coeffreductiony= 1;
	public final static int coeffdecalagedirectrice = 30;
	public final static int vx = 200;
	public final static int vy = 200;
}
