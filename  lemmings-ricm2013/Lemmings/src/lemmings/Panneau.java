package lemmings;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Panneau extends JPanel implements Constantes{ 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Image perso;
	private int posX = 0;
	private int posY = 0;
	private int tailleRX;
	private int tailleRY;
	public static double coefFenetre = 0.75;

	public Panneau(int tailleFX, int tailleFY) {
		//on test les x
		if(tailleFX >= Carte.LARGEUR_CARTE) this.tailleRX = (int) (Fenetre.tailleFX/Carte.LARGEUR_CARTE);
		else this.tailleRX = 1;

		//on test les y
		if(coefFenetre*tailleFY>=Carte.HAUTEUR_CARTE) this.tailleRY = (int)(coefFenetre*Fenetre.tailleFY/Carte.HAUTEUR_CARTE);
		else this.tailleRY = 1;

		System.out.println("tailleRX : "+tailleRX);
		System.out.println("tailleRY : "+tailleRY);
	}

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

		Observable o;
		//on affiche les lemmings
		for(int k =0;k<Carte.obs.size();k++){				
			//perso = new ImageIcon(Carte.obs.get(k).image).getImage();
			o = Carte.obs.get(k);
			BufferedImage buffer;
			try {
				buffer = ImageIO.read(new File(o.image));
				buffer = buffer.getSubimage((o.getImageCourante()/2)*20, 0, 20, 40);
				g.setColor(new Color(51,204,0));
				setOpaque(false);
				g.drawImage(buffer, o.getX()*tailleRX-tailleRX*coeff/2, 
						(o.getY()+1-coeff)*tailleRY,
						tailleRX*coeff,tailleRY*coeff, null);
				o.setImageCourante((o.getImageCourante()+1)%(nbSprite*2));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

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
