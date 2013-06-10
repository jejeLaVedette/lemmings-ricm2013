package lemmings;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Carte implements Constantes {
	
	public static Point entree;
	public static int nbLemmings;

	public static Element[][] map = new Element[LARGEUR_CARTE][HAUTEUR_CARTE];
	public static ArrayList<Observable> obs = new ArrayList<Observable>();
	public static int taille = LARGEUR_CARTE * HAUTEUR_CARTE;

	public static void initialiser()
	{
		/* Convention :
		 * 0 : sols
		 * 1 : air
		 * 2 : lemmings
		 */
		for(int i=0; i<Carte.HAUTEUR_CARTE; i++)
		{
			for(int j=0; j<Carte.LARGEUR_CARTE; j++)
			{
				if (i>3*Carte.HAUTEUR_CARTE/4)
					Carte.map[j][i] = new Sol();
				else
					Carte.map[j][i] = new Air();
			}
		}

		// On place 2 lemmings sur le sol
		Lemming bob = new Lemming(Carte.HAUTEUR_CARTE-Carte.HAUTEUR_CARTE/4,10);
		obs.add(bob);
		bob = new Lemming(Carte.HAUTEUR_CARTE-Carte.HAUTEUR_CARTE/4,12);
		obs.add(bob);
		bob = new Lemming(9,50);
		obs.add(bob);
		bob = new Lemming(9,77);
		bob.setDirection(0);
		obs.add(bob);
		
		
		// On place des murs
		Carte.map[Carte.HAUTEUR_CARTE-Carte.HAUTEUR_CARTE/4][40] = new Sol();
		Carte.map[Carte.HAUTEUR_CARTE-Carte.HAUTEUR_CARTE/4][5] = new Sol();
		for(int u=50;u<78;u++) 
			Carte.map[u][30] = new Sol();
		
	}

	public static void charger(String input) throws IOException {
		
		BufferedImage maCarte=ImageIO.read(new File(input));
		
		if(maCarte.getHeight() != HAUTEUR_CARTE || maCarte.getWidth() != LARGEUR_CARTE)
			System.out.println("Carte invalide : erreur de dimension");
		else {
			Color c;
			for(int i=0;i<maCarte.getHeight();i++) {
				for(int j=0;j<maCarte.getWidth();j++) {
					
					c = new Color(maCarte.getRGB(j,i));
					
					// Test : air ou pas air ?
					if (c.getBlue() == pixelAir.getBlue() &&
						c.getRed() == pixelAir.getRed() &&
						c.getGreen() == pixelAir.getGreen())
						map[j][i] = new Air();		
					else
						map[j][i] = new Sol(c);
					
				}
			}
		}
			
	}

	public static void popLemmings ()
	{
		if(nbLemmings>0) {
			Lemming lem;
			if((nbLemmings%2)==0)
				lem = new Lemming(entree.x,entree.y);
			else
				lem = new Lemming(entree.x,entree.y,2);
			obs.add(lem);
			nbLemmings--;
		}
	}
	
	public static Point getEntree() {
		return entree;
	}

	public static void setEntree(Point entree) {
		Carte.entree = entree;
	}

	public static int getNbLemmings() {
		return nbLemmings;
	}

	public static void setNbLemmings(int nbLemmings) {
		Carte.nbLemmings = nbLemmings;
	}
	
	
}
