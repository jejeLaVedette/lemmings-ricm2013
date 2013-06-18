package lemmings;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class Carte implements Constantes {

	public static Point entree,sortie;
	public static int nbLemmings = 0;
	public static int lemmingSauf = 0;

	public static int LARGEUR_CARTE;
	public static int HAUTEUR_CARTE;
	public static int taille;
	
	public static double gravite = 9.81;
	
	public static String background;
	public static String miniMap;

	public static Element[][] map;// = new Element[LARGEUR_CARTE][HAUTEUR_CARTE];
	public static ArrayList<Observable> obs = new ArrayList<Observable>();

	//DECLARATION DES COMPTEURS DE TOUT LES OBJET
	public static int cmpPioche,cmpParapluie,cmpEscalier,cmpFutur1,cmpEscalade,cmpBombe,cmpStop,cmpFutur2;

	public static void charger(String carte, String background) throws IOException {


		BufferedImage arrierePlan=ImageIO.read(new File(background));
		BufferedImage maCarte=ImageIO.read(new File(carte));
		
		if(arrierePlan.getHeight()<maCarte.getHeight() || arrierePlan.getWidth()<maCarte.getWidth()) { 
			System.out.println("Erreur : arrière plan trop petit !");
			System.out.println("Taille de l'arriere plan : "+arrierePlan.getWidth()+"x"+arrierePlan.getHeight());
			System.out.println("Taille de la carte : "+maCarte.getWidth()+"x"+maCarte.getHeight());
			System.exit(1);
		}
		else
			Carte.background = background;

		Carte.map = new Element[maCarte.getWidth()][maCarte.getHeight()];
		HAUTEUR_CARTE = maCarte.getHeight();
		LARGEUR_CARTE = maCarte.getWidth();
		taille = LARGEUR_CARTE * HAUTEUR_CARTE;

		Color c;
		for(int i=0;i<maCarte.getHeight();i++) {
			for(int j=0;j<maCarte.getWidth();j++) {

				c = new Color(maCarte.getRGB(j,i));
				
				if ( (Math.abs(c.getBlue()-pixelAir.getBlue())< toleranceAir) &&
						(Math.abs(c.getRed()-pixelAir.getRed())< toleranceAir) &&
						(Math.abs(c.getGreen()-pixelAir.getGreen())< toleranceAir))
					map[j][i] = new Air(new Color(arrierePlan.getRGB(j,i)));
				else
					map[j][i] = new Sol(c);

			}
		}


	}

	public static void popLemmings (int type)
	{
		obs.add(new Lemming(entree.x,entree.y,type));
		nbLemmings--;
	}

	public static Point getEntree() {
		return entree;
	}

	public static void setEntree(Point entree) {
		Carte.entree = entree;
	}

	public static Point getSortie() {
		return sortie;
	}

	public static void setSortie(Point sortie) {
		Carte.sortie = sortie;
	}

	public static int getNbLemmings() {
		return nbLemmings;
	}

	public static void setNbLemmings(int nbLemmings) {
		Carte.nbLemmings = nbLemmings;
	}
	
	public static void initCmp(int pioche, int parapluie, int escalier, int futur1, int grimpeur, int bombe, int stop, int futur2) {
		cmpPioche = pioche;
		cmpParapluie = parapluie;
		cmpEscalier = escalier;
		cmpFutur1 = futur1;  
		cmpEscalade = grimpeur;  
		cmpBombe = bombe;  
		cmpStop = stop; 
		cmpFutur2 = futur2; 
	}


}

