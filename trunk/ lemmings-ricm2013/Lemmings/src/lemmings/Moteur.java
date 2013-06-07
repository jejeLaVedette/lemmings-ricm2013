package lemmings;

public class Moteur {
	
	public static void miseAJourObservables()
	{
		for(int i=0;i<Carte.HAUTEUR_CARTE;i++) {
			for(int j=0;j<Carte.LARGEUR_CARTE;j++) {
				
				// Analyse de l'element courant
				
				// Si on a un Lemming
				if(Carte.map[i][j].type==2) {
					// Analyse de l'environnement du lemming courant
					String cond;
					if(j==0 || Carte.map[i][j-1].type==0)
						cond = "mur";
					else if(Carte.map[i-1][j-1].type==1)
						cond = "vide";
					else cond = "sol";
					
					
					
					
					
					
					
				}
			}
		}
	}
	
	private void marcher(int x,int y) {
		
	}
	
	private void retourner(int x, int y) {
		
	}
	
	private void tomber(int x, int y) {
		
	}
	

}
