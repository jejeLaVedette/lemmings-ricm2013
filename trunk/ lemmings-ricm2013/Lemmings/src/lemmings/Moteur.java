package lemmings;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Moteur implements Constantes {

	private static int relief=0;

	public static void miseAJourObservables() throws IOException
	{

		for(int i=0;i<Carte.obs.size();i++) {

			// Analyse de l'element courant

			// Si on a un Lemming
			Lemming  lem = (Lemming) Carte.obs.get(i);

			// Si l'état est -2 : on "convertit" le lemming en lemming de base
			if(lem.getEtat()==etatReinit) {
				lem.type = lemmingBase;
				lem.setEtat(etatInitial);
			}
			if(lem.getEtat()==etatReinitParapluie) {
				lem.type = lemmingParapluie;
				lem.setEtat(etatInitial);
			}
			int x = lem.getX();
			int y = lem.getY();

			// S'il est mort, et ben... il est mort !
			if(lem.getY()==Carte.HAUTEUR_CARTE-1) {
				Carte.obs.remove(i);
				break;
			}

			// Analyse de l'environnement du lemming courant
			String cond;

			// Présence d'un vide
			if( ( lem.getDirection()==gauche && Carte.map[x][y+1].type>=typeAirInf && Carte.map[x][y+1].type<=typeAirSup ) ||
					( lem.getDirection()==droite && Carte.map[x][y+1].type>=typeAirInf && Carte.map[x][y+1].type<=typeAirSup )	) 
				cond = "vide";

			// Présence d'un mur
			else if( (x==0 && lem.getDirection()==gauche) || 
					(x==Carte.LARGEUR_CARTE-1 && lem.getDirection()==1) ||
					(lem.getDirection()==gauche && Carte.map[x-1][y].type<=typeSolSup && Carte.map[x-1][y-1].type<=typeSolSup && Carte.map[x-1][y-2].type<=typeSolSup)||
					(lem.getDirection()==droite && Carte.map[x+1][y].type<=typeSolSup && Carte.map[x+1][y-1].type<=typeSolSup && Carte.map[x+1][y-2].type<=typeSolSup)||
					(lem.type == lemmingCatapulte && Carte.map[x][y-1-coeff*3/4].type<=typeSolSup && Carte.map[x-1][y-1-coeff*3/4].type<=typeSolSup && Carte.map[x+1][y-1-coeff*3/4].type<=typeSolSup )
					) 
				cond = "mur";

			else 
				cond = "sol";




			// Calcul du relief
			if(cond=="sol") {
				relief = 0;
				if(lem.getDirection()==gauche) {

					if(Carte.map[x-1][y].type<=typeSolSup) {
						relief--;
						if(Carte.map[x-1][y-1].type<=typeSolSup) {
							relief--;
							if(Carte.map[x-1][y-2].type<=typeSolSup) relief--;
						}
					}					

					if(Carte.map[x-1][y+1].type>=typeAirInf && Carte.map[x-1][y+1].type<=typeAirSup) {
						relief++;
						if(Carte.map[x-1][y+2].type>=typeAirInf && Carte.map[x-1][y+2].type<=typeAirSup) {
							relief++;
							//if(Carte.map[x-1][y+2].type>=typeAirInf && Carte.map[x-1][y+2].type<=typeAirSup) relief++;
						}
					}
				}
				else {
					if(Carte.map[x+1][y].type<=typeSolSup) {
						relief--;
						if(Carte.map[x+1][y-1].type<=typeSolSup) {
							relief--;
							if(Carte.map[x+1][y-2].type<=typeSolSup) relief--;
						}
					}

					if(Carte.map[x+1][y+1].type>=typeAirInf && Carte.map[x+1][y+1].type<=typeAirSup) {
						relief++;
						if(Carte.map[x+1][y+2].type>=typeAirInf && Carte.map[x+1][y+2].type<=typeAirSup) {
							relief++;
							//if(Carte.map[x+1][y+2].type>=typeAirInf && Carte.map[x+1][y+2].type<=typeAirSup) relief++;
						}
					}


				}
			}

			// S'il est mort, et ben... il est mort !
			if(lem.getEtat()==etatMort && cond=="sol") {
				Carte.obs.remove(i);
				break;
			}

			//System.out.println("x: "+lem.getX()+ " y:"+lem.getY()+" relief: "+relief + " cond:"+cond);

			// Recherche de l'automate correspondant
			Automate aut = null;
			for(int m=0;m<Jeu.listeAutomates.size();m++)
				if(Jeu.listeAutomates.get(m).identifiant == lem.type) {
					aut = Jeu.listeAutomates.get(m); break;
				}

			if(aut == null) {
				System.out.println("Modèle d'automate introuvable !");
				System.exit(1);
			}
			
			// Recherche de la transition dans l'automate
			int k=0;
			while(k<aut.listeTransitions.size()) {
				if( aut.listeTransitions.get(k).getEtatInitial()==lem.getEtat() && 
					aut.listeTransitions.get(k).getCondition().equals(cond)) break;

				k++;
			}

			if(k==aut.listeTransitions.size()) {
				System.out.println("Automate n°"+ aut.identifiant +" non-déterministe !");
				System.exit(1);
			}
			// On applique les actions associées
			if (aut.listeTransitions.get(k).getActions() != null)
			{
				for(int l=0;l<aut.listeTransitions.get(k).getActions().size();l++) {
					appliquerAction(aut.listeTransitions.get(k).getActions().get(l),lem);
				}
			}
			lem.setEtat(aut.listeTransitions.get(k).getEtatFinal());

		} // Fin for(i)
	}

	private static void appliquerAction(String s, Lemming l) throws IOException {

		if(s.equals("marcher"))
			marcher(l);
		else if(s.equals("retourner"))
			retourner(l);
		else if(s.equals("tomber"))
			tomber(l);
		else if(s.equals("bloquer"))
			bloquer(l);
		else if(s.equals("tomberParapluie"))
			tomberParapluie(l);
		else if(s.equals("creuser"))
			creuser(l);
		else if(s.equals("voler"))
			voler(l);
		else if(s.equals("rebondir"))
			rebondir(l);
		else if(s.equals("grimper"))
			grimper(l);
		else if(s.equals("initTrajectoire"))
			initTrajectoire(l);
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

		if(l.getDirection()==0) {
			l.image = "Images/lemming4.png";
		}
		else if(l.getDirection()==1) {
			l.image = "Images/lemming3.png";
		}

		Carte.map[l.getX()][l.getY()].type = typeSolInvisible;
		Carte.map[l.getX()][l.getY()-1].type = typeSolInvisible;
		Carte.map[l.getX()][l.getY()-2].type = typeSolInvisible;
		Carte.map[l.getX()][l.getY()-3].type = typeSolInvisible;
	}

	private static void tomberParapluie(Lemming l) {
		l.setY(l.getY()+1);
		l.image = "Images/lemming6.png";
	}

	private static void creuser(Lemming l) throws IOException {

		int x,y;
		y = l.getY();
		x = l.getX();
		BufferedImage arrierePlan=ImageIO.read(new File(Carte.background));
		for(int i=0;i<(coeff/2);i++) {
			Carte.map[x+i][y] = new Air(new Color(arrierePlan.getRGB(x+i,y)));
			Carte.map[x-i][y] = new Air(new Color(arrierePlan.getRGB(x-i,y)));
		}

		l.setY(y+1);
	}

	private static void initTrajectoire(Lemming l) {
		 
		trajectoireparaphysique t=new trajectoireparaphysique(l.getX(),l.getY(),30,Math.PI/2,1);
 l.setTrajH(t);
	}

	private static void voler(Lemming l) {
		l.setXp(l.getX());
		l.setYp(l.getY());
		trajectoireparaphysique t = l.getTrajH();		
		l.setX(t.calculx(l.time));
		l.setY(t.calculy(l.time));
		
		l.setTime();
		Carte.map[l.getX()][l.getY()].couleur = new Color(255,0,0);
		
	}

	private static void rebondir(Lemming l) {
		/*
		if(!l.getTrajV().doit_tomber(l.getY())) {
			l.setX(l.getTrajV().get_trajectoireX(l.getY()));
			l.setY(l.getY()+1);
			System.out.println("x:"+l.getX()+" y:"+l.getY());
			Carte.map[l.getX()][l.getY()].couleur = new Color(0,0,255);
		}
		else {
			l.type = lemmingParapluie; 
			l.setEtat(hauteurLetale);*/
		System.out.println("x:"+l.getX()+" y:"+l.getY()+" Xp"+l.getXp() +"Yp" + l.getYp());

		trajectoireparaphysique t= l.getTrajH() ;
		t.calculcolision(l.getX(), l.getY(), l.getXp()  , l.getYp() , l.getElasticite(),0.0, false);
		l.setTrajH(t);
		System.out.println("x:"+l.getX()+" y:"+l.getY());
			//Carte.map[l.getX()][l.getY()].couleur = new Color(0,0,255);
			l.resetTime();
		
	}

	private static void grimper(Lemming l) {
		System.out.println("TOTO");
		l.setY(l.getY()-1);
	}

}
