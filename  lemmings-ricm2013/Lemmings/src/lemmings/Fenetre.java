package lemmings;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Panneau pan = new Panneau();
	private JButton bouton = new Bouton("Creuser");
	private JButton bouton2 = new Bouton("Parapluie");
	private JButton bouton3 = new Bouton("tombe");
	private JPanel container = new JPanel();


	public static int tailleFX = 1000;
	public static int tailleFY = 500;

	public Fenetre() {
		this.setTitle("Lemmings");
		this.setSize(tailleFX, tailleFY);
		this.setResizable(false);
		//Positionne l'objet au centre
		this.setLocationRelativeTo(null);
		//Termine le processus lorsqu'on clique sur la croix rouge
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  

		//ne pas enlever --> je ne sais pas vraiment ce que ça fais mais sans ça sa bug... ^^
		//this.setContentPane(pan);

		container.setLayout(new BorderLayout());
		container.add(pan, BorderLayout.CENTER);
		JPanel south = new JPanel();
		south.add(bouton);
		south.add(bouton2);
		south.add(bouton3);
		container.add(south, BorderLayout.SOUTH);


		//pan.add(bouton);
		this.setContentPane(container);
		this.setVisible(true);
		afficher();
	}



	private void afficher(){
		//on affiche
		/*pan.repaint(); 
		try {
			Thread.sleep(10); // a une certaine vitesse --> 1000 = 1sec
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
	}
}