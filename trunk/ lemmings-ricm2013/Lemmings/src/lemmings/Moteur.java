package lemmings;

public class Moteur {
	
	public static void miseAJourObservables()
	{
		
		for(int i=0;i<Carte.obs.size();i++) {
				
			// Analyse de l'element courant
				
			// Si on a un Lemming
			//if(Carte.obs.get(i).type==2) {
				
				Lemming lem = (Lemming) Carte.obs.get(i);
				int x = lem.getX();
				int y = lem.getY();
				// Analyse de l'environnement du lemming courant
				String cond;
				
				// Présence d'un mur
				if( (x==0 && lem.getDirection()==0) || 
					(x==Carte.LARGEUR_CARTE-1 && lem.getDirection()==1) ||
					(lem.getDirection()==0 && Carte.map[x-1][y].type<10) ||
					(lem.getDirection()==1 && Carte.map[x+1][y].type<10) )
					cond = "mur";
				// Présence d'un vide
				else if( (lem.getDirection()==0 && Carte.map[x][y+1].type>9 && Carte.map[x][y+1].type<20) ||
						 (lem.getDirection()==1 && Carte.map[x][y+1].type>9 && Carte.map[x][y+1].type<20) )
					cond = "vide";
				else cond = "sol";
				
				// Recherche de l'automate correspondant
				Automate aut = Jeu.listeAutomates.get(0);
				for(int m=0;m<Jeu.listeAutomates.size();m++)
					if(Jeu.listeAutomates.get(m).identifiant == lem.type) {
						aut = Jeu.listeAutomates.get(m); break;
					}
										
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
					appliquerAction(aut.listeTransitions.get(k).getActions().get(l),lem);
				}
				
				lem.setEtat(aut.listeTransitions.get(k).getEtatFinal());
					
					
			//} // fin if(Lemmings)
				
				
				
		} // Fin for(i)
	}
	
	private static void appliquerAction(String s, Lemming l) {
		
		if(s=="marcher")
			marcher(l);
		else if(s=="retourner")
			retourner(l);
		else if(s=="tomber")
			tomber(l);
		else if(s=="bloquer")
			bloquer(l);
		else
			System.out.println("Action invalide !");
	}
	
	private static void marcher(Lemming l) {
		if(l.getDirection()==0)
			l.setX(l.getX()-1);
		else if(l.getDirection()==1) 
			l.setX(l.getX()+1);		
	}
	
	private static void retourner(Lemming l) {
		
		if(l.getDirection()==0)
			l.setDirection(1);
		else if(l.getDirection()==1)
			l.setDirection(0);
	}
	
	private static void tomber(Lemming l) {
		if(l.getDirection()==0) {
			l.setY(l.getY()+1);
		}			
		else if(l.getDirection()==1) {
			l.setY(l.getY()+1);
		}
	}
	
	private static void bloquer(Lemming l) {
		Carte.map[l.getX()][l.getY()].type = 1;
	}
	

}
