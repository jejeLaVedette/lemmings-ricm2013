package lemmings;

import java.util.ArrayList;
import java.util.List;




public class Test_trajectoire {
	public static List<Automate>listetoto = new ArrayList<Automate>();
public static void main(String[] args){
	
		
		listetoto.add(new AutoLemmings(5));
		Carte.initialiser();
		Fenetre f = new Fenetre();
		f.afficher();
		Trajectoire_physique tp = new Trajectoire_physique(2, 5, 4, -4);
		for(int i = 0 ; i<Fenetre.tailleFX/Carte.LARGEUR_CARTE;i++){
			int y = tp.get_trajectoireY(i);
			System.out.println(y);}
	}

}
