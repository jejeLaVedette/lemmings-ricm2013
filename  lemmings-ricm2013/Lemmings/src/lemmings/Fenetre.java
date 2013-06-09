package lemmings;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Fenetre extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Panneau pan = new Panneau();

	//private JPanel container = new JPanel();


	public static int tailleFX = 1000;
	public static int tailleFY = 500;

	public Fenetre() {
		this.setTitle("Lemmings");
		this.setSize(tailleFX, tailleFY);
		//empeche le redimentionnement de la fenetre
		this.setResizable(false);
		//Positionne l'objet au centre
		this.setLocationRelativeTo(null);
		//Termine le processus lorsqu'on clique sur la croix rouge
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  

		//modifie le logo en haut a gauche
		Image icone = new ImageIcon("Images/Logo.jpg").getImage();
		setIconImage(icone);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new Bouton("Creuse");
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new Bouton("Parapluie");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new Bouton("Super Saiyen");
		panel.add(btnNewButton_2);
		
		this.setVisible(true);
	}



	public void afficher(){

		getContentPane().add(pan, BorderLayout.CENTER);
		pan.repaint(); 
		
		try {
			Thread.sleep(10); // a une certaine vitesse --> 1000 = 1sec
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	
}