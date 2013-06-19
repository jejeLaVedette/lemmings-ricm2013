package lemmings;

import java.awt.Cursor;
import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Jeu implements Constantes {

	public static List<Automate>listeAutomates = new ArrayList<Automate>();
	
	public static Fenetre f;
	public static void main(String[] args) throws InterruptedException, IOException{




		Carte.initCmp(0, 0, 0, 0, 0, 0, 0, 0);
		Jeu.initialiserJeu("Images/Carte2.png", 
						   "Images/chat.png",
						   "", "Documents partagés/automate.xml",
						   new Point(60,55), 
						   new Point(330,125), 
						   20);
		
		int wait = delaiPop + 1;

		f = new Fenetre(tailleFenetreH,tailleFenetreV);
		f.afficher();

		f.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		
		Carte.obs.add(new Lemming(400,150,Math.PI/4,50));
		
		while(true) {
			
			if(wait>delaiPop && Carte.getNbLemmings()!=0) {
				Carte.popLemmings(lemmingBase);
				wait = 0;
			}

			Moteur.miseAJourObservables();
			Thread.sleep(delaiAttente);
			f.afficher();

			if(Carte.getNbLemmings()!=0)
				wait++;
		}


	}

	public static void initialiserJeu(String map,String background, String musique, String fichierAutomates, Point ptEntree, Point ptSortie, int nbLemmings) throws IOException {
		
		Carte.obs.removeAll(Carte.obs);
		
		AutomateHandler.initAutomates(fichierAutomates);
		
		listeAutomates.add(new AutoLemmingStop(5));
		listeAutomates.add(new AutoLemmingCatapulte(5));

		//Thread playWave=new AePlayWave(musique);
		//playWave.start();
		
		Carte.charger(map,background);
		
		Carte.setEntree(ptEntree);
		Carte.setSortie(ptSortie);

		Carte.setNbLemmings(nbLemmings);
		if (f!=null) {
			f.setVisible(false);
			f = new Fenetre(tailleFenetreH,tailleFenetreV);
		}

	}

}
