package lemmings;

public class Moteur {
	
	public static void miseAJourObservables()
	{
		
		for(int i=0;i<Carte.HAUTEUR_CARTE;i++) {
			for(int j=0;j<Carte.LARGEUR_CARTE;j++) {
				
				// Analyse de l'element courant
				
				// Si on a un Lemming
				if(Carte.map[i][j].type==2) {
					System.out.println("i: "+i+" j: "+j);
					Lemming lem = (Lemming) Carte.map[i][j];
					// Analyse de l'environnement du lemming courant
					String cond;
					// Présence d'un mur
					if( (j==0 && lem.getDirection()==0) || 
						(j==Carte.LARGEUR_CARTE-1 && lem.getDirection()==1) ||
						(lem.getDirection()==0 && Carte.map[i][j-1].type==0) ||
						(lem.getDirection()==1 && Carte.map[i][j+1].type==0) )
						cond = "mur";
					// Présence d'un vide
					else if( (lem.getDirection()==0 && Carte.map[i-1][j-1].type==1) ||
							 (lem.getDirection()==1 && Carte.map[i+1][j+1].type==1) )
						cond = "vide";
					else cond = "sol";
					
					// Recherche de l'automate correspondant (ici, un seul...)
					Automate aut = Jeu2.listeAutomates.get(0);
										
					// Recherche de la transition dans l'automate
					int k=0;
					while(k<aut.listeTransitions.size()) {
						if( aut.listeTransitions.get(k).getEtatInitial()==lem.getEtat() && 
								aut.listeTransitions.get(k).getCondition()==cond)
							break;
								
						k++;
					}
					
					if(k==aut.listeTransitions.size())
						System.out.println("Automate non-déterministe !");
					// On applique les actions associées
					for(int l=0;l<aut.listeTransitions.get(k).getActions().size();l++) {
						appliquerAction(aut.listeTransitions.get(k).getActions().get(l),i,j,lem.getDirection());
					}
					
					
					
				} // fin if(Lemmings)
				
				
				
			} // Fin for(j)
		} // Fin for(i)
	}
	
	private static void appliquerAction(String s, int x, int y, int direction) {
		
		if(s=="marcher")
			marcher(x,y,direction);
		else if(s=="retourner")
			retourner(x,y,direction);
		else if(s=="tomber")
			tomber(x,y);
		else
			System.out.println("Action invalide !");
	}
	
	private static void marcher(int x,int y,int direction) {
		if(direction==0)
			Carte.map[x][y-1] = Carte.map[x][y];
		if(direction==1) 
			Carte.map[x][y+1] = Carte.map[x][y];
		
		Carte.map[x][y] = new Air();
		System.out.println("Lemming marche : x: "+x+" y: "+y); 
		
	}
	
	private static void retourner(int x, int y, int direction) {
		
	}
	
	private static void tomber(int x, int y) {
		
	}
	

}
