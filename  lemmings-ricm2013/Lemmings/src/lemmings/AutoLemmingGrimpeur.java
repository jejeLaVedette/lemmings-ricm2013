package lemmings;

import java.util.ArrayList;
import java.util.List;

public class AutoLemmingGrimpeur extends Automate implements Constantes {

	public AutoLemmingGrimpeur(int nbTransitions) {
		super(nbTransitions, lemmingGrimpeur);
		List<String> l = new ArrayList<String>();
		
		l.add("grimper");
		listeTransitions.add(new Transition(0,1,"mur",l));
		
		l = new ArrayList<String>();
		l.add("marcher");
		listeTransitions.add(new Transition(0, 0, "sol", l));
		
		l = new ArrayList<String>();
		l.add("retourner");
		listeTransitions.add(new Transition(0, 0, "mur", l));
		
		l = new ArrayList<String>();
		l.add("tomber");
		listeTransitions.add(new Transition(0, 1, "vide", l));
	}

}
