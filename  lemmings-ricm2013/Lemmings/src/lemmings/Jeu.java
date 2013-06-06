package lemmings;

import java.util.ArrayList;
import java.util.List;

public class Jeu {
	
	public static List<Automate>listeAutomates = new ArrayList<Automate>();
	
	public static void main(String[] args){
		
		listeAutomates.add(new Lemmings(5));
		Carte.initialiser();
		Fenetre f = new Fenetre();
	}

}
