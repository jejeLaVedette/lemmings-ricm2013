package lemmings;

import java.awt.Cursor;
import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Jeu implements Constantes {

	public static List<Automate>listeAutomates = new ArrayList<Automate>();
	

	public Jeu (String map, String bg, String fichierAutomates, String musique,
				int nbLemming, Point ptEntre, Point ptSortie) throws IOException, InterruptedException
	{
		AutomateHandler.initAutomates(fichierAutomates);
		//AutomateHandler.initAutomates("./Documents partagés/automate.xml");
		
		Thread playWave=new AePlayWave(musique);
		playWave.start();

		Carte.charger(map,bg);
		

		//Carte.initCmp(5, 1, 6, 0, 0, 0, 2, 0);

		//Carte.setEntree(new Point(60, 55));
		//Carte.setSortie(new Point(330, 125));
		Carte.setEntree(ptEntre);
		Carte.setSortie(ptSortie);
		Carte.setNbLemmings(nbLemming);
		
		Main.maFenetre.chargerFenetre();
		int wait = delaiPop + 1;


		// Lemmings bloqueurs
		//Carte.obs.add(new Lemming(100,61,lemmingStop));
		//Carte.obs.add(new Lemming(80,80,lemmingStop));
		//Carte.obs.add(new Lemming(80,80,lemmingStop));
		//Carte.obs.add(new Lemming(160,30,lemmingStop));

		
		// Lemmings creuseurs
		//Carte.obs.add(new Lemming(80,80,lemmingCreuseur));
		//Carte.obs.add(new Lemming(330,80,lemmingCreuseur));


		// Lemmings catapultes

		/*Carte.obs.add(new Lemming(250,150,lemmingCatapulte));
                Carte.obs.add(new Lemming(350,150,lemmingCatapulte));
                Carte.obs.add(new Lemming(250,150,lemmingCatapulte));
                Carte.obs.add(new Lemming(350,150,lemmingCatapulte));
                ((Lemming) Carte.obs.get(0)).setDirection(gauche);
                ((Lemming) Carte.obs.get(1)).setDirection(gauche);*/

		//Carte.obs.add(new Lemming(70,150,Math.PI/6,40));




		while(true) {
			//f.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			if(wait>delaiPop && Carte.getNbLemmings()!=0) {
				Carte.popLemmings(lemmingBase);
				wait = 0;
			}

			Moteur.miseAJourObservables();
			Thread.sleep(delaiAttente);
			Main.maFenetre.afficher();

			if(Carte.getNbLemmings()!=0)
				wait++;
		}


	}

}
