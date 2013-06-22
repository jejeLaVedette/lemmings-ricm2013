package lemmings;

import java.awt.Color;
import java.awt.Graphics;
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
		
	}

	public void paintComponent(Graphics g)
	{
		int posX=0;
		int posY=0;
		
		for(int i=0; i<Carte.HAUTEUR_CARTE; i++){

			for(int j=0; j<Carte.LARGEUR_CARTE; j++){ 

				g.setColor(Carte.map[j][i].couleur);
				g.fillRect(posX, posY, tailleRX, tailleRY);

				// on avance en longueur
				posX=posX+tailleRX;
			}
			//on se replace tout a gauche de l'�cran
			posX=0;
			//et on diminue d'un rang en hauteur
			posY=posY+tailleRY;
		}


		Observable o;
		//on affiche les lemmings
		for(int k =0;k<Carte.obs.size();k++){	
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


  

}
