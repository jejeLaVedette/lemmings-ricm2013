package lemmings;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;




public class Test_trajectoire {
	public static List<Automate>listetoto = new ArrayList<Automate>();
public static void main(String[] args) throws IOException{
	
		
		listetoto.add(new AutoLemmingBasique(5));
		Carte.initialiser();
		Fenetre f = new Fenetre(Fenetre.tailleFX,Fenetre.tailleFY);
		f.afficher();
		CopyOfTrajectoire_physiqueH tp = new CopyOfTrajectoire_physiqueH(80, 80, 50, -100,0);
		for(int i = 0 ; i<20;i++){
			int y = tp.get_trajectoireY(i);
			System.out.println("valeur de y finale");
			 
			
			System.out.println(y);}
	}

}
