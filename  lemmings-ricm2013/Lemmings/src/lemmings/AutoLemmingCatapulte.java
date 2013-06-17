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

		
		l = new ArrayList<String>();
		listeTransitions.add(new Transition(1, 3, "sol", l));
		listeTransitions.add(new Transition(1, 3, "mur", l));
		
		l = new ArrayList<String>();
		l.add("voler");

		listeTransitions.add(new Transition(2, 2, "vide", l));
		listeTransitions.add(new Transition(2, 2, "sol", l));
		listeTransitions.add(new Transition(2, 2, "mur", l));
		
		l = new ArrayList<String>();
		l.add("rebondir");
		listeTransitions.add(new Transition(3, 2, "vide", l));
		listeTransitions.add(new Transition(3, 2, "sol", l));
		listeTransitions.add(new Transition(3, 2, "mur", l));
		

		
		
		/*l = new ArrayList<String>();
		listeTransitions.add(new Transition(3, etatReinitParapluie, "sol", l));
		listeTransitions.add(new Transition(3, etatReinitParapluie, "mur", l));
		*/
		// Rebond au sol
		//l = new ArrayList<String>();
		
		//l.add("grimper");
		//l.add("initTrajectoire");
		//listeTransitions.add(new Transition(4, 1, "sol", l));
		/*//listeTransitions.add(new Transition(4, 5, "mur", l));
		
		l = new ArrayList<String>();
		l.add("voler");
		listeTransitions.add(new Transition(5, 5, "vide", l));
		
		l = new ArrayList<String>();
		listeTransitions.add(new Transition(5, etatReinitParapluie, "sol", l));
		listeTransitions.add(new Transition(5, etatReinitParapluie, "mur", l));*/
	}

}
