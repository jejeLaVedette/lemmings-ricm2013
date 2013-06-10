package lemmings;

import java.util.ArrayList;
import java.util.List;




public class Test_trajectoire {
	public static List<Automate>listetoto = new ArrayList<Automate>();
public static void main(String[] args){
	
		
		listetoto.add(new AutoLemmingBasique(5));
		Carte.initialiser();
		Fenetre f = new Fenetre();
		f.afficher();
		Trajectoire_physique tp = new Trajectoire_physique(80, 170, 50, 60);
		for(int i = 0 ; i<250;i++){
			int y = tp.get_trajectoireY(i);
			System.out.println(y);}
	}

}
