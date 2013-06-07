package lemmings;

import java.util.ArrayList;

public class Carte {

	public static int LARGEUR_CARTE = 50;
	public static int HAUTEUR_CARTE = 20;

	public static Element[][] map = new Element[HAUTEUR_CARTE][LARGEUR_CARTE];
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
					Carte.map[i][j] = new Sol();
				else
					Carte.map[i][j] = new Air();
			}
		}

		// On place 2 lemmings sur le sol
		Lemming bob = new Lemming(Carte.HAUTEUR_CARTE-Carte.HAUTEUR_CARTE/4,10);
		obs.add(bob);
		bob = new Lemming(Carte.HAUTEUR_CARTE-Carte.HAUTEUR_CARTE/4,12);
		obs.add(bob);
		bob = new Lemming(9,20);
		obs.add(bob);
		bob = new Lemming(9,27);
		bob.setDirection(0);
		obs.add(bob);
		
		
		// On place des murs
		Carte.map[Carte.HAUTEUR_CARTE-Carte.HAUTEUR_CARTE/4][40] = new Sol();
		Carte.map[Carte.HAUTEUR_CARTE-Carte.HAUTEUR_CARTE/4][5] = new Sol();
		for(int u=20;u<28;u++) 
			Carte.map[10][u] = new Sol();
		
	}

}
