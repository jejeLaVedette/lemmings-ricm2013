package lemmings;

public class Carte {
	
	public static int LARGEUR_CARTE = 50;
	public static int HAUTEUR_CARTE = 20;
	
	public static int[][] map = new int[HAUTEUR_CARTE][LARGEUR_CARTE];
	public static int taille = LARGEUR_CARTE * HAUTEUR_CARTE;
	
	public static void initialiser()
	{
		/* Convention :
		 * de 0 à 49 : sols
		 * de 50 à 99: air
		 * 100 : lemmings
		 */
		for(int i=0; i<Carte.HAUTEUR_CARTE; i++)
		{
			for(int j=0; j<Carte.LARGEUR_CARTE; i++)
			{
				if (i>Carte.HAUTEUR_CARTE/4)
					Carte.map[i][j] = 0;
				else
					Carte.map[i][j] = 50;
			}
		}
		
		// On place 2 lemmings sur le sol
		map[Carte.HAUTEUR_CARTE-1][10] = 100;
		map[Carte.HAUTEUR_CARTE-1][15] = 100;
		
	}

}
