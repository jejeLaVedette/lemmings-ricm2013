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
		listeTransitions.add(new Transition(0, etatReinit, "sol", l));
		listeTransitions.add(new Transition(0, etatReinit, "mur", l));
	}

}
