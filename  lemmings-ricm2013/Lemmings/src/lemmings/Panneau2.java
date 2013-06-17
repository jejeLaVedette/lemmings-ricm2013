package lemmings;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Panneau2 extends JPanel implements Constantes { 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//private Image perso;
	private int posX = 0;
	private int posY = 0;
	private int tailleRX;
	private int tailleRY;
	private double coefFenetre = 0.75;
	public static final int coeff = 10;
	
	private int coefRetrecissementx;
	private int coefRetrecissementy;

	public Panneau2(int tailleFX, int tailleFY) {
		//on test les x
		/*if(tailleFX >= Carte.LARGEUR_CARTE) this.tailleRX = Fenetre.tailleFX/Carte.LARGEUR_CARTE;
		else this.tailleRX = Carte.LARGEUR_CARTE/Fenetre.tailleFX;
		
		//on test les y
		if(coefFenetre*tailleFY>=Carte.HAUTEUR_CARTE) this.tailleRY = (int)(coefFenetre*Fenetre.tailleFY/Carte.HAUTEUR_CARTE);
		else this.tailleRY = (int) (Carte.HAUTEUR_CARTE/coefFenetre*Fenetre.tailleFY);
		
		this.coefRetrecissement = 3;*/
		
		if(tailleFX >= Carte.LARGEUR_CARTE) {
			this.tailleRX = Fenetre.tailleFX/Carte.LARGEUR_CARTE;
			this.coefRetrecissementx = this.tailleRX;
		}
		else {
			this.tailleRX = 1;
			this.coefRetrecissementx = this.tailleRX*2+1;//*2 car la mini_map n'est que 1/2 de x de l'écran et +1 pour prendre le pixel supérieur
		}
		
		//on test les y
		if(coefFenetre*tailleFY>=Carte.HAUTEUR_CARTE) {
			this.tailleRY = (int)(coefFenetre*Fenetre.tailleFY/Carte.HAUTEUR_CARTE);
			this.coefRetrecissementy = this.tailleRY;
		}
		else {
			this.tailleRY =1;
			this.coefRetrecissementy = this.tailleRY*2+1;
		}
		
	}

	public void paintComponent(Graphics g)
	{
		int luminance; Color c;
		for(int i=0; i<Carte.HAUTEUR_CARTE; i+=coefRetrecissementy){

			for(int j=0; j<Carte.LARGEUR_CARTE; j+=coefRetrecissementx){ 
				
				if (Carte.map[j][i].type >= typeSolInf && Carte.map[j][i].type <= typeSolSup)
				{
					c = Carte.map[j][i].couleur;
					luminance = (int) (c.getRed() * 0.2126 + c.getGreen() * 0.7152 + c.getBlue() * 0.0722);
					g.setColor(new Color(luminance,luminance,luminance));
				}
				if (Carte.map[j][i].type >= typeAirInf && Carte.map[j][i].type <= typeAirSup)
					g.setColor(new Color(200,200,200));
				
				g.fillRect(posX, posY, tailleRX, tailleRY);

				// on avance en longueur
				posX=posX+tailleRX;
				
			}
			//on se replace tout a gauche de l'Ã©cran
			posX=0;
			//et on diminue d'un rang en hauteur
			posY=posY+tailleRY;
			;
		}

		//si on repaint, on repart de 0
		posX=0;
		posY=0;
		
		//on affiche les lemmings
		for(int k =0;k<Carte.obs.size();k++){				
			g.setColor(new Color(0,200,0));
			g.fillRect(Carte.obs.get(k).getX()*tailleRX/coefRetrecissementx-tailleRX*coeff/2, 
					   (Carte.obs.get(k).getY()-coeff)*tailleRY/coefRetrecissementy, 
					   Constantes.coeff/2, 
					   Constantes.coeff);
		}
		

	}


	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}    

}
