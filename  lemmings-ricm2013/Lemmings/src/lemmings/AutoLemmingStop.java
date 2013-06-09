package lemmings;

import java.util.ArrayList;
import java.util.List;

public class AutoLemmingStop extends Automate {

	public AutoLemmingStop (int nbTransitions) {
		super(nbTransitions,1);
		List<String> l = new ArrayList<String>();
		
		l.add("tomber");
		listeTransitions.add(new Transition(0, 1, "vide", l));
		
		listeTransitions.add(new Transition(1, 1, "vide", l));
		
		l = new ArrayList<String>();
		listeTransitions.add(new Transition(1, 0, "sol", l));
		
		l = new ArrayList<String>();
		l.add("bloquer");
		listeTransitions.add(new Transition(0, 0, "sol", l));
			
		
	}
}
