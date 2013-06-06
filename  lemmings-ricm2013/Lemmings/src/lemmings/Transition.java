package lemmings;

import java.util.List;

public class Transition {
	
	private int etatInitial;
	private int etatFinal;
	private String condition;
	private List<String> actions;
	
	public Transition (int init, int fina, String cond, List<String> actions)
	{
		this.etatInitial = init;
		this.etatFinal = fina;
		this.condition = cond;
		this.actions = actions;
	}

	public int getEtatInitial() {
		return etatInitial;
	}

	public int getEtatFinal() {
		return etatFinal;
	}

	public String getCondition() {
		return condition;
	}

	public List<String> getActions() {
		return actions;
	}

}
