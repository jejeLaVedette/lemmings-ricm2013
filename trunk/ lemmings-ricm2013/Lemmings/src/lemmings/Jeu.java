package lemmings;

import java.awt.Cursor;
import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Jeu implements Constantes {

	public static List<Automate>listeAutomates = new ArrayList<Automate>();

	public static void main(String[] args) throws InterruptedException, IOException{




		Carte.initCmp(0, 0, 0, 0, 0, 0, 0, 0);
		Jeu.initialiserJeu("Images/Carte2.png", "Images/chat.png", "", "Documents partagés/automate.xml", new Point(60,55), new Point(330,125), 20);
		
		int wait = delaiPop + 1;

		Fenetre f = new Fenetre(tailleFenetreH,tailleFenetreV);
		f.afficher();

		// Lemmings bloqueurs
		//Carte.obs.add(new Lemming(100,61,lemmingStop));
		//Carte.obs.add(new Lemming(80,80,lemmingStop));
		//Carte.obs.add(new Lemming(80,80,lemmingStop));
		//Carte.obs.add(new Lemming(160,30,lemmingStop));

		f.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));


		// Lemmings creuseurs
		//Carte.obs.add(new Lemming(80,80,lemmingCreuseur));
		//Carte.obs.add(new Lemming(330,80,lemmingCreuseur));


		// Lemmings catapultes


		//Carte.obs.add(new Lemming(250,150,lemmingCatapulte));
		//Carte.obs.add(new Lemming(350,150,lemmingCatapulte));
		//Carte.obs.add(new Lemming(250,150,lemmingCatapulte));
		//Carte.obs.add(new Lemming(350,150,lemmingCatapulte));
		//((Lemming) Carte.obs.get(0)).setDirection(gauche);
		//((Lemming) Carte.obs.get(1)).setDirection(gauche);*/



		Carte.obs.add(new Lemming(400,150,Math.PI/4,50));






		while(true) {
			//f.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
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

		Carte.miniMap = "Images/Carte.png";
		//Thread playWave=new AePlayWave(musique);
		//playWave.start();


		Carte.charger(map,background);
		
		Carte.setEntree(ptEntree);
		Carte.setSortie(ptSortie);

		Carte.setNbLemmings(nbLemmings);

	}

}
