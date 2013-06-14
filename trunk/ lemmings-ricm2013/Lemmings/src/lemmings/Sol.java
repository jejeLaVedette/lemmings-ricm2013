package lemmings;

import java.awt.Color;

public class Sol extends Element implements Constantes {
	
	private double elasticite;
	
	public Sol() {
		super.type = 0;
		this.elasticite = 0;
		super.couleur = defautSol;
	}
	
	public Sol(Color c) {
		super.type = typeSolInf;
		super.couleur = c;
		this.elasticite = 0;
	}
	
	public Sol(Color c, double elas) {
		super.type = typeSolInf;
		super.couleur = c;
		this.elasticite = elas;
	}
	
	public Sol(double elas) {
		super.type = typeSolInf;
		super.couleur = defautSol;
		this.elasticite = elas;
	}

	public double getElasticite() {
		return elasticite;
	}

	public void setElasticite(double elasticite) {
		this.elasticite = elasticite;
	}
	
	
	
	

}
