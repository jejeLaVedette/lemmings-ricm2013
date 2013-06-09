package lemmings;
import java.util.ArrayList;



public abstract class Automate {
	
	protected ArrayList<Transition> listeTransitions;
	protected int identifiant;
	
	public Automate(int nbTransitions, int id)
	{
		listeTransitions = new ArrayList<Transition>(nbTransitions);
		this.identifiant = id;
		
	}

	public int getIdentifiant() {
		return identifiant;
	}


	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	

}
