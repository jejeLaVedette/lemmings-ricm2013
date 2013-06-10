package lemmings;

public class Moteur implements Constantes {
	
	private static int relief=0;
	
	public static void miseAJourObservables()
	{
		
		for(int i=0;i<Carte.obs.size();i++) {
			
			// Analyse de l'element courant
				
			// Si on a un Lemming
			Lemming lem = (Lemming) Carte.obs.get(i);
			
			// Si l'état est -2 : on "convertit" le lemming en lemming de base
			if(lem.getEtat()==etatReinit) {
				lem.type = lemmingBase;
				lem.setEtat(etatInitial);
			}
			
			// Cas du lemmings catapulté
			if(lem.type == 5) {
				lem.setY(Jeu.traj.get_trajectoireY(lem.getX()));
				lem.setX(lem.getX()+1);
				continue;			
			}
			
			int x = lem.getX();
			int y = lem.getY();
			// Analyse de l'environnement du lemming courant
			String cond;
			
			
			// Présence d'un mur
			if( (x==0 && lem.getDirection()==gauche) || 
				(x==Carte.LARGEUR_CARTE-1 && lem.getDirection()==1) ||
				(lem.getDirection()==gauche && Carte.map[x-1][y].type<=typeSolSup && Carte.map[x-1][y-1].type<=typeSolSup && Carte.map[x-1][y-2].type<=typeSolSup)||
				(lem.getDirection()==droite && Carte.map[x+1][y].type<=typeSolSup && Carte.map[x+1][y-1].type<=typeSolSup && Carte.map[x+1][y-2].type<=typeSolSup) ) {
					cond = "mur";
			}
			// Présence d'un vide
			else { 
				if( ( lem.getDirection()==gauche && Carte.map[x][y+1].type>=typeAirInf && Carte.map[x][y+1].type<=typeAirSup ) ||
					( lem.getDirection()==droite && Carte.map[x][y+1].type>=typeAirInf && Carte.map[x][y+1].type<=typeAirSup )	) {
					cond = "vide";
				}
				else {
					cond = "sol";
				}
			}
			
			// Calcul du relief
			if(cond=="sol") {
				relief = 0;
				if(lem.getDirection()==gauche) {
					if(Carte.map[x-1][y-1].type<=typeSolSup) relief--;
					if(Carte.map[x-1][y-2].type<=typeSolSup) relief--;
					if(Carte.map[x-1][y+1].type>=typeAirInf && Carte.map[x-1][y+1].type<=typeAirSup) relief++;
					if(Carte.map[x-1][y+2].type>=typeAirInf && Carte.map[x-1][y+2].type<=typeAirSup) relief++;
				}
				else {
					if(Carte.map[x+1][y-1].type<=typeSolSup) relief--;
					if(Carte.map[x+1][y-2].type<=typeSolSup) relief--;
					if(Carte.map[x+1][y+1].type>=typeAirInf && Carte.map[x+1][y+1].type<=typeAirSup) relief++;
					if(Carte.map[x+1][y+2].type>=typeAirInf && Carte.map[x+1][y+2].type<=typeAirSup) relief++;
				}
			}
			
			// S'il est mort, et ben... il est mort !
			if(lem.getEtat()==etatMort && cond=="sol") {
				Carte.obs.remove(i);
				break;
			}
				
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
		else if(s=="tomberParapluie")
			tomberParapluie(l);
		else if(s=="creuser")
			creuser(l);
		else
			System.out.println("Action invalide !");
	}
	
	private static void marcher(Lemming l) {
		if(l.getDirection()==0) {
			l.image = "Images/lemming2.png";
			l.setX(l.getX()-1);
			l.setY(l.getY()+relief);
		}			
		else if(l.getDirection()==1) {
			l.setX(l.getX()+1);
			l.setY(l.getY()+relief);
			l.image = "Images/lemming1.png";
		}
	}
	
	private static void retourner(Lemming l) {
		
		if(l.getDirection()==0) {
			l.setDirection(1);
			l.image = "Images/lemming1.png";
		}
		else if(l.getDirection()==1) {
			l.setDirection(0);
			l.image = "Images/lemming2.png";
		}
	}
	
	private static void tomber(Lemming l) {
		l.setY(l.getY()+1);
		l.image = "Images/lemming5.png";
		
	}
	
	private static void bloquer(Lemming l) {
		if(l.getDirection()==0)
			l.image = "Images/lemming4.png";
		else if(l.getDirection()==1)
			l.image = "Images/lemming3.png";
		
		Carte.map[l.getX()][l.getY()].type = typeSolInvisible;
		Carte.map[l.getX()][l.getY()-1].type = typeSolInvisible;
		Carte.map[l.getX()][l.getY()-2].type = typeSolInvisible;
	}
	
	private static void tomberParapluie(Lemming l) {
		l.setY(l.getY()+2);
		l.image = "Images/lemming6.png";
	}
	
	private static void creuser(Lemming l) {
		for(int i=0;i<(coeff/2);i++) {
			Carte.map[l.getX()+i][l.getY()] = new Air();
			Carte.map[l.getX()-i][l.getY()] = new Air();
		}
		l.setY(l.getY()+1);
	}
	

}
