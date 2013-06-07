package lemmings;

import java.util.ArrayList;
import java.util.List;

public class AutoLemmings extends Automate {

	public AutoLemmings(int nbTransitions) {
		
		super(nbTransitions);
		List<String> l = new ArrayList<String>();
		
		l.add("marcher");
		listeTransitions.add(new Transition(0, 0, "sol", l));
		
		l = new ArrayList<String>();
		l.add("retourner");
		listeTransitions.add(new Transition(0, 0, "mur", l));
		
		l = new ArrayList<String>();
		l.add("tomber");
		listeTransitions.add(new Transition(0, 1, "vide", l));
		
		l = new ArrayList<String>();
		listeTransitions.add(new Transition(1, 0, "sol", l));
		
		l = new ArrayList<String>();
		l.add("tomber");
		listeTransitions.add(new Transition(1, 1, "vide", l));		
		
		identifiant = 2;
		
		
	}

}
