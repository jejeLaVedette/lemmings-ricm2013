package lemmings;

public class Carte {

	public static int LARGEUR_CARTE = 50;
	public static int HAUTEUR_CARTE = 20;

	public static Element[][] map = new Element[HAUTEUR_CARTE][LARGEUR_CARTE];
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
		Lemming bob = new Lemming();
	
		map[Carte.HAUTEUR_CARTE-Carte.HAUTEUR_CARTE/4][10] = bob;
		map[Carte.HAUTEUR_CARTE-Carte.HAUTEUR_CARTE/4][15] = bob;

	}

}
