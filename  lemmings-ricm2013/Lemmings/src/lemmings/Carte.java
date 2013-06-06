package lemmings;

public class Carte {
	
	public static int LARGEUR_CARTE = 50;
	public static int HAUTEUR_CARTE = 20;
	
	public static int[][] map;
	public static int taille;
	public static int hauteur;
	public static int largeur;
	
	public Carte()
	{
		Carte.map = new int[HAUTEUR_CARTE][LARGEUR_CARTE];
		Carte.taille = HAUTEUR_CARTE * LARGEUR_CARTE;
		Carte.hauteur = HAUTEUR_CARTE;
		Carte.largeur = LARGEUR_CARTE;
	}
	
	public Carte(int hauteur, int largeur)
	{
		Carte.map = new int[hauteur][largeur];
		Carte.taille = hauteur * largeur;
		Carte.hauteur = hauteur;
		Carte.largeur = largeur;
	}
	
	public void initialiser()
	{
		/* Convention :
		 * de 0 à 49 : sols
		 * de 50 à 99: air
		 * 100 : lemmings
		 */
		for(int i=0; i<Carte.hauteur; i++)
		{
			for(int j=0; j<Carte.largeur; i++)
			{
				if (i>Carte.hauteur/4)
					Carte.map[i][j] = 0;
				else
					Carte.map[i][j] = 50;
			}
		}
		
		// On place 2 lemmings sur le sol
		map[Carte.hauteur-1][10] = 100;
		map[Carte.hauteur-1][15] = 100;
		
	}

}
