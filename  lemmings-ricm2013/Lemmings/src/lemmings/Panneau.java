package lemmings;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Panneau extends JPanel { 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Image perso;
	private int posX = 0;
	private int posY = 0;
	private int tailleRX = Fenetre.tailleFX/Carte.LARGEUR_CARTE;
	private int tailleRY = Fenetre.tailleFY/Carte.HAUTEUR_CARTE;
	public static final int coeff = 10;
	public void paintComponent(Graphics g)
	{
		for(int i=0; i<Carte.HAUTEUR_CARTE; i++){

			for(int j=0; j<Carte.LARGEUR_CARTE; j++){ 
		
				g.setColor(Carte.map[j][i].couleur);
				g.fillRect(posX, posY, tailleRX, tailleRY);
				
				// on avance en longueur
				posX=posX+tailleRX;

			}
			//on se replace tout a gauche de l'écran
			posX=0;
			//et on diminue d'un rang en hauteur
			posY=posY+tailleRY;
		}
		
		//si on repaint, on repart de 0
		posX=0;
		posY=0;
			
		//on affiche les lemmings
		for(int k =0;k<Carte.obs.size();k++){				
			perso = new ImageIcon(Carte.obs.get(k).image).getImage();
			g.setColor(new Color(51,204,0));
			setOpaque(false);
			g.drawImage(perso, Carte.obs.get(k).getX()*tailleRX-tailleRX*coeff/2, 
							   (Carte.obs.get(k).getY()-coeff)*tailleRY,
							   tailleRX*coeff,tailleRY*coeff, null);
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
