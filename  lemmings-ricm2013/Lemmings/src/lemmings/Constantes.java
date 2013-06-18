package lemmings;

import java.awt.Color;

public interface Constantes {
	
	// Constantes de carte	
	public final static Color pixelAir = new Color(255,0,255);
	public final static Color defautAir = new Color(50,50,50);
	public final static Color defautSol = new Color(0,0,0);
	public final static int toleranceAir = 10;
	
	// Constantes des Elements
	public final static int typeSolInf = 0;
	public final static int typeSolSup = 9;
	public final static int typeAirInf = 10;
	public final static int typeAirSup = 19;
	public final static int typeSolInvisible = 1;
	
	// Constantes des Lemmings
	public final static int haut =1;
	public final static int bas =0;
	public final static int droite = 1;
	public final static int gauche = 0;
	public final static int profondeurCreuser = 10;
	public final static int hauteurLetale = 40;
	
	// Constantes de la fenêtre
	public final static int coeff = 10;
	public final static int tailleFenetreH = 1000;
	public final static int tailleFenetreV = 700;
	public final static int nbSprite = 8;
	
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
	public final static int lemmingGrimpeur = 5;
	public final static int lemmingEscalier = 6;
	
	// Constantes de Jeu

	public final static int delaiAttente = 40;
	public final static int delaiPop = 50;
	public final static int nbMarche = 15;
	public final static int delaiSousAction = 4;
	public final static int toleranceSortie = 10;
	
	// Constantes trajectoires
	public final static  double coeffreductionx= 0.4;
	public final static  double coeffreductiony= 0.2;
	public final static  int coeffdecalagedirectrice = 30;
	public static int vx = 50;
	public static int vy = 50;
	public static double coeffgravite=9.8;
	public static double hauteurlemmings=1.20;
	public static double larglemmings=0.20;
	public static double proflemmings=0.60;
	public static double massevolair=1.184;
	public static double masselemming=80;
	public static double coefftraineelemming=1.05;
	public static double deltat=0.1;
	
	
}
