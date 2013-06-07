package lemmings;

import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Jeu {
	
	public static List<Automate>listeAutomates = new ArrayList<Automate>();
	/*private int x;
	private int y;
	private int vectx;
	private int vecty;*/
	
	public static void main(String[] args) throws InterruptedException, IOException{
		
		listeAutomates.add(new AutoLemmingBasique(5));
		listeAutomates.add(new AutoLemmingStop(2));
		//Carte.initialiser();
		Carte.charger("Images/Carte.png");
		Carte.setEntree(new Point(120, 20));
		Carte.setNbLemmings(20);
		
		int wait = 51;
		
		Fenetre f = new Fenetre();
		f.afficher();
		
		// Lemmings bloqueurs
		Carte.obs.add(new Lemming(150,20,1));
		
		while(true) {
			
			if(wait>50) {
				Carte.popLemmings();
				wait = 0;
			}
			
			Moteur.miseAJourObservables();
			Thread.sleep(50);
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
