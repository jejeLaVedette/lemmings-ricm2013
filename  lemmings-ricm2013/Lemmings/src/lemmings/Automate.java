package lemmings;
import java.util.ArrayList;



public abstract class Automate {
	
	protected ArrayList<Transition> listeTransitions;
	protected int identifiant;
	protected String nom;
	
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
	
	public static int nomVersIdentifiant (String nom) {
		return 0;
	}

	

}
