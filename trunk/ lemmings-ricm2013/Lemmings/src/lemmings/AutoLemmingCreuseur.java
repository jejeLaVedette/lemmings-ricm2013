package lemmings;

import java.util.ArrayList;
import java.util.List;

public class AutoLemmingCreuseur extends Automate implements Constantes {
	
	public AutoLemmingCreuseur (int nbTransitions) {
		super(nbTransitions, lemmingCreuseur);
		List<String> l = new ArrayList<String>();
		
		l.add("tomber");
		listeTransitions.add(new Transition(0,0,"vide",l));
		
		l = new ArrayList<String>();
		listeTransitions.add(new Transition(0,1,"sol",l));
		
		l = new ArrayList<String>();
		l.add("creuser");
		int i=1;
		while(i<profondeurCreuser+1) {
			listeTransitions.add(new Transition(i, i+1, "sol", l));
			listeTransitions.add(new Transition(i, etatReinit, "vide", l));
			i++;
		}
		
		l = new ArrayList<String>();
		listeTransitions.add(new Transition(i, etatReinit, "sol", l));
		listeTransitions.add(new Transition(i, etatReinit, "vide", l));
		listeTransitions.add(new Transition(i, etatReinit, "mur", l));
	}

}
