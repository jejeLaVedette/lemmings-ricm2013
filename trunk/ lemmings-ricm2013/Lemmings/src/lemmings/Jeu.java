package lemmings;

import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Jeu implements Constantes {
	
	public static List<Automate>listeAutomates = new ArrayList<Automate>();
	/*private int x;
	private int y;
	private int vectx;
	private int vecty;*/
	
	public static Trajectoire_physiqueH traj;
	
	public static void main(String[] args) throws InterruptedException, IOException{
		
		listeAutomates.add(new AutoLemmingBasique(5));
		listeAutomates.add(new AutoLemmingStop(5));
		listeAutomates.add(new AutoLemmingParapluie(5));
		listeAutomates.add(new AutoLemmingCreuseur(5));
		listeAutomates.add(new AutoLemmingCatapulte(5));
		//Carte.initialiser();
		Carte.charger("Images/Carte.png");
		Carte.setEntree(new Point(120, 30));
		Carte.setNbLemmings(0);
		
		int wait = delaiPop + 1;
		
		Fenetre f = new Fenetre();
		f.afficher();
		
		// Lemmings bloqueurs
		//Carte.obs.add(new Lemming(150,30,lemmingStop));
		//Carte.obs.add(new Lemming(80,80,lemmingStop));
		
		// Lemmings creuseurs
		//Carte.obs.add(new Lemming(45,80,lemmingCreuseur));
		
		// Lemmings catapulte

		Carte.obs.add(new Lemming(120,150,lemmingCatapulte));
		traj = new Trajectoire_physiqueH(120,150,40,20,true);

		
		while(true) {
			
			if(wait>delaiPop) {
				Carte.popLemmings();
				wait = 0;
			}
			
			Moteur.miseAJourObservables();
			Thread.sleep(delaiAttente);
			f.afficher();
			
			if(Carte.getNbLemmings()!=0)
				wait++;
		}
		
		/*
		Trajectoire_physique tp = new Trajectoire_physique(0, 0, 10, 10);
		for(int i = 0 ; i<Fenetre.tailleFX/Carte.LARGEUR_CARTE;i++){
			int y = tp.get_trajectoireY(0);
			System.out.println(y);
		}
		*/
		
		
	}

}
