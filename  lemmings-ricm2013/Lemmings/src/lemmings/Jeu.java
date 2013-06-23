package lemmings;

import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Jeu implements Constantes {

	public static List<Automate>listeAutomates = new ArrayList<Automate>();

	public static Fenetre f;
	public static Thread playWave;
	public static boolean play = true;
	public static boolean accelerer = false;
	public static void main(String[] args) throws InterruptedException, IOException{

		Carte.initCmp(0, 0, 0, 0, 0, 0, 0, 0);

		Jeu.initialiserJeu("Images/depart.png", 
				"Images/departbg.png",
				"Musiques/Rayman.wav",
				"Automates/automate.xml",
				new Point(61,124), 
				new Point(450,141),
				new Point(0,0),
				50);

		int wait = delaiPop + 1;

		f = new Fenetre(tailleFenetreH,tailleFenetreV);
		f.afficher();

		while(true) {

			if(play){
				if(wait>delaiPop && Carte.getNbLemmings()!=0) {
					Carte.popLemmings(lemmingBase);
					wait = 0;
				}


				Moteur.miseAJourObservables();
				f.afficher();

				if(Carte.getNbLemmings()!=0)
					wait++;


			}
			
			if(accelerer) Thread.sleep(delaiAttente/4);
			else Thread.sleep(delaiAttente);

		}


	}

	public static void initialiserJeu(String map,String background, String musique, String fichierAutomates, Point ptEntree, Point ptSortie, Point ptCatapulte, int nbLemmings) throws IOException {

		Carte.obs.removeAll(Carte.obs);

		AutomateHandler.initAutomates(fichierAutomates);

		
		//on reinitialise tout les compteurs
		Carte.lemmingSauf=0;
		playWave = new AePlayWave(musique);
		playWave.start();

		Carte.charger(map,background);

		Carte.setEntree(ptEntree);
		Carte.setSortie(ptSortie);
		Carte.setCatapulte(ptCatapulte);

		Carte.setNbLemmings(nbLemmings);
		if (f!=null) {
			f.setVisible(false);
			f = new Fenetre(tailleFenetreH,tailleFenetreV);
		}

	}

}