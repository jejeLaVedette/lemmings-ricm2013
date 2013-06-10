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
		CopyOfTrajectoire_physique tp = new CopyOfTrajectoire_physique(80, 80, 50, -100,true);
		for(int i = 0 ; i<20;i++){
			int y = tp.get_trajectoireY(i);
			System.out.println("valeur de y finale");
			 
			
			System.out.println(y);}
	}

}
