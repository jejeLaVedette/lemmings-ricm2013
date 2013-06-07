package lemmings;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Panneau extends JPanel { 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int posX = 0;
	private int posY = 0;
	private int tailleRX = Fenetre.tailleFX/Carte.HAUTEUR_CARTE;
	private int tailleRY = Fenetre.tailleFY/Carte.LARGEUR_CARTE;

	public void paintComponent(Graphics g)
	{

		for(int i=0; i<Carte.HAUTEUR_CARTE; i++){

			for(int j=0; j<Carte.LARGEUR_CARTE; j++){ 

				//si c'est un sol je colori en rouge et je créer le rectangle adéquoit
				if (Carte.map[i][j] < 50){
					g.setColor(new Color(102,51,0));
					g.fillRect(posX, posY, tailleRX, tailleRY);
				}

				//si c'est air je colori en blanc et je créer le rectangle adéquoit
				else if ((Carte.map[i][j] >= 50)&&(Carte.map[i][j] <100)){
					g.setColor(new Color(153,153,153));
					g.fillRect(posX, posY, tailleRX, tailleRY);
				}

				else if (Carte.map[i][j]==100||Carte.map[i][j]==101){
					g.setColor(new Color(51,204,0));
					g.fillRect(posX, posY, tailleRX, tailleRY);
				}
				posX=posX+tailleRX;

			}
			posX=0;
			posY=posY+tailleRY;
		}

		posX=0;
		posY=0;


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
