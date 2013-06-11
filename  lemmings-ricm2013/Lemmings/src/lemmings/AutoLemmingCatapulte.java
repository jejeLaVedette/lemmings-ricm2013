package lemmings;

import java.util.ArrayList;
import java.util.List;

public class AutoLemmingCatapulte extends Automate implements Constantes {

	public AutoLemmingCatapulte(int nbTransitions) {
		
		super(nbTransitions, lemmingCatapulte);
		
		List<String> l = new ArrayList<String>();
		
		l.add("voler");
		listeTransitions.add(new Transition(0, 0, "vide", l));
		
		l = new ArrayList<String>();
		l.add("grimper)");
		listeTransitions.add(new Transition(0, 1, "sol", l));
		l = new ArrayList<String>();
		l.add("tomber");
		listeTransitions.add(new Transition(0, 1, "mur", l));
		
		l = new ArrayList<String>();
		l.add("rebondir");
		listeTransitions.add(new Transition(1, 1, "vide", l));
		
		l = new ArrayList<String>();
		listeTransitions.add(new Transition(1, etatReinitParapluie, "sol", l));
		l = new ArrayList<String>();
		l.add("tomber");
		listeTransitions.add(new Transition(1, etatReinitParapluie, "mur", l));
		
	}

}
