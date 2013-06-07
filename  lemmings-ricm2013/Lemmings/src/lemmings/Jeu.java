package lemmings;

import java.util.ArrayList;
import java.util.List;

public class Jeu {
	
	public static List<Automate>listeAutomates = new ArrayList<Automate>();
	private int x;
	private int y;
	private int vectx;
	private int vecty;
	
	public static void main(String[] args){
		
		listeAutomates.add(new AutoLemmings(5));
		Carte.initialiser();
		Fenetre f = new Fenetre();
		//Carte.map[1][1]=new Lemming();
		f.afficher();
		/*
		Trajectoire_physique tp = new Trajectoire_physique(0, 0, 10, 10);
		for(int i = 0 ; i<Fenetre.tailleFX/Carte.LARGEUR_CARTE;i++){
			int y = tp.get_trajectoireY(0);
			System.out.println(y);
		}
		*/
		
		
	}

}
