package lemmings;
import java.util.ArrayList;

import lemmings.Transition;

public class Automate {

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
    switch (nom) {
        case "Classique":  id = 0;
                 break;
        case "Parapluie":  id = 1;
                 break;
        case "Creuseur":   id = 2;
                 break;
        case "Grimpeur":   id = 3;
                 break;
                 
        // A completer //
                 
        default: id = 0;
                 break;
    }
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
