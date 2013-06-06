package lemmings;

import javax.swing.JFrame;

public class Fenetre extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Panneau pan = new Panneau();

	public static int tailleFX = 1000;
	public static int tailleFY = 500;

	public Fenetre(){
		this.setTitle("Lemmings");
		this.setSize(tailleFX, tailleFY);
		this.setResizable(false);
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
		//on affiche
		pan.repaint(); 
		try {
			Thread.sleep(10); // a une certaine vitesse --> 1000 = 1sec
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}