package lemmings;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Panneau2 extends JPanel implements Constantes { 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Image perso;
	private int posX = 0;
	private int posY = 0;
	private int tailleRX;
	private int tailleRY;
	public static final int coeff = 10;

	public Panneau2(int tailleX, int tailleY) {
		this.tailleRX = tailleX;
		this.tailleRY = tailleY;
	}

	public void paintComponent(Graphics g)
	{
		int luminance; Color c;
		for(int i=0; i<Carte.HAUTEUR_CARTE; i++){

			for(int j=0; j<Carte.LARGEUR_CARTE; j++){ 
				
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
				j+=2;
			}
			//on se replace tout a gauche de l'écran
			posX=0;
			//et on diminue d'un rang en hauteur
			posY=posY+tailleRY;
			i+=2;
		}

		//si on repaint, on repart de 0
		posX=0;
		posY=0;
		
		//on affiche les lemmings
		for(int k =0;k<Carte.obs.size();k++){				
			/*perso = new ImageIcon(Carte.obs.get(k).image).getImage();
			g.setColor(new Color(51,204,0));
			setOpaque(false);
			g.drawImage(perso, Carte.obs.get(k).getX()*tailleRX/3-tailleRX*coeff/2, 
					(Carte.obs.get(k).getY()-coeff)*tailleRY/3,
					tailleRX*coeff/3,tailleRY*coeff/3, null);*/
			g.setColor(new Color(0,200,0));
			g.fillRect(Carte.obs.get(k).getX()*tailleRX/3-tailleRX*coeff/2, (Carte.obs.get(k).getY()-coeff)*tailleRY/3, Constantes.coeff/2, Constantes.coeff);
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
