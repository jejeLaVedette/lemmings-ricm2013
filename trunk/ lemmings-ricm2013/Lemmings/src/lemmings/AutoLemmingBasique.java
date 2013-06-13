package lemmings;

import java.util.ArrayList;
import java.util.List;

public class AutoLemmingBasique extends Automate implements Constantes {

	public AutoLemmingBasique(int nbTransitions) {
		
		super(nbTransitions,lemmingBase);
		List<String> l = new ArrayList<String>();
		
		l.add("marcher");
		listeTransitions.add(new Transition(0, 0, "sol", l));
		
		l = new ArrayList<String>();
		l.add("retourner");
		listeTransitions.add(new Transition(0, 0, "mur", l));
		
		l = new ArrayList<String>();
		l.add("tomber");
		listeTransitions.add(new Transition(0, 1, "vide", l));
		
		int v = 2;
		for(int u=1;u<hauteurLetale;u++)
		{
			// Tombe et atterit
			l = new ArrayList<String>();
			l.add("tomber");
			listeTransitions.add(new Transition(u, 0, "sol", l));
			// Tombe et tombe encore			
			listeTransitions.add(new Transition(u, v, "vide", l));
			v++;
		}
		
		v--;
		l = new ArrayList<String>();
		l.add("tomber");
		listeTransitions.add(new Transition(v, -1, "vide", l));
		
		l = new ArrayList<String>();
		listeTransitions.add(new Transition(v, -1, "sol", l));
		
		l = new ArrayList<String>();
		listeTransitions.add(new Transition(-1, -1, "sol", l));
		
		l = new ArrayList<String>();
		l.add("tomber");
		listeTransitions.add(new Transition(-1, -1, "vide", l));
		
	}

}