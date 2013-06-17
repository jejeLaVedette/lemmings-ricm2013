package lemmings;
import java.util.ArrayList;

import lemmings.Transition;

public class Automate implements Constantes {

	protected ArrayList<Transition> listeTransitions;
	protected int identifiant;
	protected String nom;
	
public Automate(int nbTransitions, int id)
	{
		listeTransitions = new ArrayList<Transition>(nbTransitions);
		this.identifiant = id;
		
	}
	
public Automate() {}
public static int nomVersIdentifiant (String nom) {
	int id;
	
	if(nom.equals("Classique"))
		id = lemmingBase;
	else if (nom.equals("Parapluie"))
		id = lemmingParapluie;
	else if (nom.equals("Creuseur"))
		id = lemmingCreuseur;
	else if (nom.equals("Grimpeur"))
		id = lemmingGrimpeur;
	else if (nom.equals("Escalier"))
		id = lemmingEscalier;
	else
		id = 0;
    return id;
	}

public ArrayList<Transition> getListe() {return listeTransitions;}
public String getNom() {return nom;}
public int getIdentifiant() {return identifiant;}

public void setListeTransitions(ArrayList<Transition> listeTransitions) {this.listeTransitions = listeTransitions;}
public void setNom(String nom) {this.nom = nom;}
public void setIdentifiant(int identifiant) {this.identifiant = identifiant;}

public String toString(){
    return new StringBuffer("Automate : Nom : ").append(nom).append(", ")
    			.append("Transitions : ").append(listeTransitions).toString();	
 }

}
