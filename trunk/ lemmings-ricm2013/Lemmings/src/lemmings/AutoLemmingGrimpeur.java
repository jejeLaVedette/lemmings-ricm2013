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
		listeTransitions.add(new Transition(1,1,"mur",l));
		listeTransitions.add(new Transition(1,0,"sol",l));
	}

}
