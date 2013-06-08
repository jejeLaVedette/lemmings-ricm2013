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
	 
	//private Image img = new ImageIcon("Images/sol.png").getImage();
	private Image perso;// = new ImageIcon("Images/perso2.png").getImage();
	private int posX = 0;
	private int posY = 0;
	private int tailleRX = Fenetre.tailleFX/Carte.LARGEUR_CARTE;
	private int tailleRY = Fenetre.tailleFY/Carte.HAUTEUR_CARTE;
	public static final int coeff = 10;
	public void paintComponent(Graphics g)
	{

		for(int i=0; i<Carte.HAUTEUR_CARTE; i++){

			for(int j=0; j<Carte.LARGEUR_CARTE; j++){ 

				//si c'est un sol je colori en rouge et je cr�er le rectangle ad�quoit
				/*if (Carte.map[j][i].type == 0){
					g.setColor(new Color(102,51,0));
					//g.drawImage(img, posX, posY, null);
					g.fillRect(posX, posY, tailleRX, tailleRY);
				}

				//si c'est air je colori en noir et je cr�er le rectangle ad�quoit
				else if (Carte.map[j][i].type ==1){
					g.setColor(new Color(153,153,153));
					g.fillRect(posX, posY, tailleRX, tailleRY);
				}*/
				
				g.setColor(Carte.map[j][i].couleur);
				//g.drawImage(img, posX, posY, null);
				g.fillRect(posX, posY, tailleRX, tailleRY);
				
				// on avance en longueur
				posX=posX+tailleRX;

			}
			//on se replace tout a gauche de l'�cran
			posX=0;
			//et on diminue d'un rang en hauteur
			posY=posY+tailleRY;
		}
		
		//si on repaint, on repart de 0
		posX=0;
		posY=0;
			
		for(int k =0;k<Carte.obs.size();k++){
			// Recherche de l'image à afficher
			/*int indiceAutomate=0;
			while (indiceAutomate<Jeu.listeAutomates.size() && Jeu.listeAutomates.get(indiceAutomate).identifiant != Carte.obs.get(k).type) {
				indiceAutomate++;
			}*/
			
				
			perso = new ImageIcon(Carte.obs.get(k).image).getImage();
			g.setColor(new Color(51,204,0));
			setOpaque(false);
			g.drawImage(perso, Carte.obs.get(k).getX()*tailleRX-tailleRX*coeff/2, 
							   (Carte.obs.get(k).getY()-coeff)*tailleRY,
							   tailleRX*coeff,tailleRY*coeff, null);
			//g.fillRect(Carte.obs.get(k).getY()*tailleRX, Carte.obs.get(k).getX()*tailleRY, tailleRX, tailleRY);
		}
		
	}
	
	public void paintLemmings(Graphics g, int x, int y){
		g.setColor(new Color(51,204,0));
		g.drawImage(perso, x, y, null);
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
