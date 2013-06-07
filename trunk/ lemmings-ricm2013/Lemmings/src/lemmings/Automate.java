package lemmings;
import java.util.ArrayList;



public abstract class Automate {
	
	protected ArrayList<Transition> listeTransitions;
	protected int identifiant;
	protected String image;
	
	public Automate(int nbTransitions, int id, String image)
	{
		listeTransitions = new ArrayList<Transition>(nbTransitions);
		this.identifiant = id;
		this.image = image;
		
	}

	public int getIdentifiant() {
		return identifiant;
	}

	public String getImage() {
		return image;
	}

	public void setIdentifiant(int identifiant) {
		this.identifiant = identifiant;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
