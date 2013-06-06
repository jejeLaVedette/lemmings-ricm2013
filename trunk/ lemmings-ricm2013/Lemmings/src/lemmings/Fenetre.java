package lemmings;

import java.awt.Color;

import javax.swing.JFrame;

public class Fenetre extends JFrame {
	private Panneau pan = new Panneau();

	public static int tailleFX = 500;
	public static int tailleFY = 200;

	public Fenetre(){
		this.setTitle("Lemmings");
		this.setSize(tailleFX, tailleFY);
		//Positionne l'objet au centre
		this.setLocationRelativeTo(null);
		//Termine le processus lorsqu'on clique sur la croix rouge
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   

		this.setContentPane(pan);

		//rend visible la fenetre
		this.setVisible(true);
		afficher();
	}

	private void afficher(){
		pan.repaint();  
	      try {
	        Thread.sleep(10);
	      } catch (InterruptedException e) {
	        e.printStackTrace();
	      }
	}
}