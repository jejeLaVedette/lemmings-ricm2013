package lemmings;

import java.util.ArrayList;
import java.util.List;

public class AutoLemmingCatapulte extends Automate implements Constantes {

	public AutoLemmingCatapulte(int nbTransitions) {
		
		super(nbTransitions, lemmingCatapulte);
		
		List<String> l = new ArrayList<String>();
		
		l.add("initTrajectoire");
		listeTransitions.add(new Transition(0, 1, "vide", l));
		listeTransitions.add(new Transition(0, 1, "sol", l));
		listeTransitions.add(new Transition(0, 1, "mur", l));
		
		l = new ArrayList<String>();
		l.add("voler");
		listeTransitions.add(new Transition(1, 1, "vide", l));
		listeTransitions.add(new Transition(2, 2, "vide", l));
		listeTransitions.add(new Transition(3, 3, "vide", l));
		listeTransitions.add(new Transition(4, 4, "vide", l));
		listeTransitions.add(new Transition(5, 5, "vide", l));
		listeTransitions.add(new Transition(7, 7, "vide", l));

		
		l = new ArrayList<String>();
		l.add("rebondirmur");
		
		listeTransitions.add(new Transition(1, 2, "mur", l));
		listeTransitions.add(new Transition(2, 3, "mur", l));
		listeTransitions.add(new Transition(3, 6, "mur", l));
		listeTransitions.add(new Transition(5, 3, "mur", l));
		listeTransitions.add(new Transition(7, 6, "mur", l));

		l = new ArrayList<String>();
		l.add("rebondirsol");
		listeTransitions.add(new Transition(1, 5, "sol", l));
		listeTransitions.add(new Transition(5, 7, "sol", l));
		listeTransitions.add(new Transition(7, 6, "sol", l));
		listeTransitions.add(new Transition(2, 7, "sol", l));
		listeTransitions.add(new Transition(3, 6, "sol", l));

		l = new ArrayList<String>();
		l.add("retourner");
		l.add("initLemmingBase");
		listeTransitions.add(new Transition(6, 0, "vide", l));
		listeTransitions.add(new Transition(6, 0, "sol", l));
		listeTransitions.add(new Transition(6, 0, "mur", l));
		
		

	/*
		l.add("rebondir");
	
		listeTransitions.add(new Transition(2, 4, "vide", l));
		listeTransitions.add(new Transition(2, 3, "sol", l));
		listeTransitions.add(new Transition(2, 3, "mur", l));
		
		l = new ArrayList<String>();
		l.add("voler");
		listeTransitions.add(new Transition(4, 4, "vide", l));

		l = new ArrayList<String>();
		l.add("rebondir");
		listeTransitions.add(new Transition(4, 5, "mur", l));
		listeTransitions.add(new Transition(4, 5, "sol", l));

		l = new ArrayList<String>();

		l.add("voler");
		listeTransitions.add(new Transition(5,5 , "vide", l));
		l = new ArrayList<String>();
		listeTransitions.add(new Transition(5,6 , "mur", l));
		listeTransitions.add(new Transition(5,6 , "sol", l));
		l = new ArrayList<String>();
		listeTransitions.add(new Transition(3, 4 ,"vide", l));
		listeTransitions.add(new Transition(3, 6 ,"sol", l));
		listeTransitions.add(new Transition(3, 6, "mur", l));
		
	

		l = new ArrayList<String>();
		l.add("retourner");
		l.add("initLemmingBase");
		listeTransitions.add(new Transition(6, 0, "vide", l));
		listeTransitions.add(new Transition(6, 0, "sol", l));
		listeTransitions.add(new Transition(6, 0, "mur", l));
		
		// Rebond au sol
		//l = new ArrayList<String>();
		
		//l.add("grimper");
		//l.add("initTrajectoire");
		//listeTransitions.add(new Transition(4, 1, "sol", l));
		//listeTransitions.add(new Transition(4, 5, "mur", l));
		
		l = new ArrayList<String>();
		l.add("voler");
		listeTransitions.add(new Transition(5, 5, "vide", l));
		
		l = new ArrayList<String>();
		listeTransitions.add(new Transition(5, etatReinitParapluie, "sol", l));
		listeTransitions.add(new Transition(5, etatReinitParapluie, "mur", l));*/ 
	}

}
