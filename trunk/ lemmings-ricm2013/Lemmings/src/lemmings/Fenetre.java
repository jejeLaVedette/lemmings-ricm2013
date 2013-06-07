package lemmings;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
//import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Fenetre extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Panneau pan = new Panneau();
	/*private JButton bouton = new Bouton("Creuser");
	private JButton bouton2 = new Bouton("Parapluie");
	private JButton bouton3 = new Bouton("tombe");*/
	private JPanel container = new JPanel();


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

		//pan.add(bouton);
		this.setContentPane(container);
		this.setVisible(true);
	}



	public void afficher(){
		
		pan.repaint(); 
		container.repaint();

		container.setLayout(new BorderLayout());
		container.add(pan, BorderLayout.CENTER);
		/*
		JPanel south = new JPanel();
		south.add(bouton);
		south.add(bouton2);
		south.add(bouton3);
		container.add(south, BorderLayout.SOUTH);*/
		
		
		try {
			Thread.sleep(10); // a une certaine vitesse --> 1000 = 1sec
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	
}