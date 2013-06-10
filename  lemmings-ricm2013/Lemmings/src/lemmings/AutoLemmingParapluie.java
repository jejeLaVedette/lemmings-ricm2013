package lemmings;

import java.util.ArrayList;
import java.util.List;

public class AutoLemmingParapluie extends Automate implements Constantes {

	public AutoLemmingParapluie(int nbTransitions) {
		
		super(nbTransitions, lemmingParapluie);
		List<String> l = new ArrayList<String>();
		
		l.add("marcher");
		listeTransitions.add(new Transition(0, 0, "sol", l));
		
		l = new ArrayList<String>();
		l.add("retourner");
		listeTransitions.add(new Transition(0, 0, "mur", l));
		
		l = new ArrayList<String>();
		l.add("tomber");
		listeTransitions.add(new Transition(0, 1, "vide", l));
		
		//l = new ArrayList<String>();
		//listeTransitions.add(new Transition(1, 0, "sol", l));
		
		int v = 2;
		for(int u=1;u<40;u++)
		{
			// Tombe et atterit
			l = new ArrayList<String>();
			listeTransitions.add(new Transition(u, 0, "sol", l));
			// Tombe et tombe encore
			l = new ArrayList<String>();
			l.add("tomber");
			listeTransitions.add(new Transition(u, v, "vide", l));
			v++;
		}
		
		v--;
		l = new ArrayList<String>();
		l.add("tomber");
		listeTransitions.add(new Transition(v, v+1, "vide", l));
		
		l = new ArrayList<String>();
		listeTransitions.add(new Transition(v, v+1, "sol", l));
		
		l = new ArrayList<String>();
		listeTransitions.add(new Transition(v+1, 0, "sol", l));
		
		l = new ArrayList<String>();
		l.add("tomberParapluie");
		listeTransitions.add(new Transition(v+1, v+1, "vide", l));
	}

}
