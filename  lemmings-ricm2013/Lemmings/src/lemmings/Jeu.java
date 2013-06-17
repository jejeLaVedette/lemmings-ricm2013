package lemmings;

import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Jeu implements Constantes {

	public static List<Automate>listeAutomates = new ArrayList<Automate>();

	public static void main(String[] args) throws InterruptedException, IOException{

		//listeAutomates.add(new AutoLemmingBasique(5));
		AutomateHandler.initAutomates("./Documents partagés/automate.xml");
		listeAutomates.add(new AutoLemmingStop(5));
		listeAutomates.add(new AutoLemmingParapluie(5));
		listeAutomates.add(new AutoLemmingCreuseur(5));
		listeAutomates.add(new AutoLemmingCatapulte(5));

		//listeAutomates.add(new AutoLemmingGrimpeur(5));

		//Carte.miniMap = "Images/Carte.png";

		Carte.charger("Images/map1.png","Images/nuages.png");
		Carte.initCmp(0, 0, 4, 0, 0, 0, 2, 0);

		Carte.setEntree(new Point(60, 55));

		Carte.setNbLemmings(20);

		int wait = delaiPop + 1;

		Fenetre f = new Fenetre(tailleFenetreH,tailleFenetreV);
		f.afficher();

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

		//Carte.obs.add(new Lemming(70,150,lemmingCatapulte));



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

}
