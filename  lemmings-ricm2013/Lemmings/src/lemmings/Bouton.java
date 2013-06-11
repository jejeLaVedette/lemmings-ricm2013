package lemmings;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;

public class Bouton extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private Image img;

	public Bouton(String str){
		super(str);
		this.name = str;
		if(str=="Creuser"){
			try {
				img = ImageIO.read(new File("Images/pioche.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}

		if(str=="Parapluie"){
			try {
				img = ImageIO.read(new File("Images/parapluie_ferme.jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		else{
			try {
				img = ImageIO.read(new File("Images/pioche.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D)g;
		//GradientPaint gp = new GradientPaint(0, 0, Color.blue, 0, 20, Color.cyan, true);
		//g2d.setPaint(gp);
		g2d.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		g2d.setColor(Color.black);
		g2d.drawString(this.name, this.getWidth() / 2 - (this.getWidth() / 4), (this.getHeight() / 2) + 5);
	}

	
}
