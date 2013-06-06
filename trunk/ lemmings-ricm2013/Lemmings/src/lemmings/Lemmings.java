package lemmings;

import java.util.LinkedList;
import java.util.List;

public class Lemmings extends Automate {

	public Lemmings(int nbTransitions) {
		
		super(nbTransitions);
		List<String> l = new LinkedList<String>();
		
		l.add("marcher");
		listeTransitions.add(new Transition(0, 0, "sol", l));
		l.clear();
		
		l.add("retourner");
		listeTransitions.add(new Transition(0, 0, "mur", l));
		l.clear();
		
		l.add("tomber");
		listeTransitions.add(new Transition(0, 1, "vide", l));
		l.clear();
		
		listeTransitions.add(new Transition(1, 0, "sol", l));
		
		l.add("tomber");
		listeTransitions.add(new Transition(1, 1, "vide", l));
		l.clear();
		
		identifiant = 100;
		
		
	}

}
