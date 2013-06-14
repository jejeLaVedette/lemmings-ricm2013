package lemmings;

import java.util.List;

public class Transition {
	private int etatInitial, etatFinal;
	private String condition;
	private List<String> actions;
	   
	public Transition(){}
	   
	public int getEtatInitial(){return etatInitial;}
	public String getCondition(){return condition;}
	public int getEtatFinal(){return etatFinal;}
	public List<String> getActions(){return actions;}
	   
	public void setEtatInitial(int etatInitial){this.etatInitial = etatInitial;}
	public void setCondition(String condition){this.condition = condition;}
	public void setEtatFinal(int etatFinal){this.etatFinal = etatFinal;}
	public void setActions(List<String> actions){this.actions = actions;}
	
	public Transition (int init, int fina, String cond, List<String> actions)
	{
		this.etatInitial = init;
		this.etatFinal = fina;
		this.condition = cond;
		this.actions = actions;
	}
	
	public String toString(){
	      return new StringBuffer("Transition : Etat : ").append(etatInitial).append(", ")
	      			.append("Condition : ").append(condition).append(", ")
	      			.append("Actions : ").append(actions).append(", ")
	      			.append("Etat suivant : ").append(etatFinal)
	      			.toString();	
	   }
}
