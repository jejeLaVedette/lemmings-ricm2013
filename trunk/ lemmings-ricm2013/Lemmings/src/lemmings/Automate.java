package lemmings;
import java.util.ArrayList;



public abstract class Automate {
	
	protected ArrayList<Transition> listeTransitions;
	protected int identifiant;
	
	public Automate(int nbTransitions)
	{
		listeTransitions = new ArrayList<Transition>(nbTransitions);
		
	}

}
