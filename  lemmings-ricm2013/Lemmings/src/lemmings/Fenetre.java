package lemmings;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;


public class Fenetre extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Panneau zone_map = new Panneau();
	public static int tailleFX = 1000;
	public static int tailleFY = 550;
	
	
	public Fenetre(){
		this.setTitle("Lemmings");
		this.setSize(tailleFX, tailleFY);
		//empeche le redimentionnement de la fenetre
		this.setResizable(false);
		//Positionne l'objet au centre
		this.setLocationRelativeTo(null);
		//Termine le processus lorsqu'on clique sur la croix rouge
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel zone_controle = new JPanel();
		getContentPane().add(zone_controle, BorderLayout.SOUTH);
		zone_controle.setLayout(new BoxLayout(zone_controle, BoxLayout.X_AXIS));
		
		JPanel zone_gauche = new JPanel();
		FlowLayout fl_zone_gauche = (FlowLayout) zone_gauche.getLayout();
		fl_zone_gauche.setAlignOnBaseline(true);
		fl_zone_gauche.setVgap(1/4*tailleFY);
		fl_zone_gauche.setHgap(1/2*tailleFX);
		zone_controle.add(zone_gauche);
		
		JButton btnBoutonGauche = new JButton("bouton gauche");
		zone_gauche.add(btnBoutonGauche);
		
		JButton btnParapluie = new JButton("Parapluie");
		zone_gauche.add(btnParapluie);
		
		JPanel zone_droite = new JPanel();
		FlowLayout fl_zone_droite = (FlowLayout) zone_droite.getLayout();
		fl_zone_droite.setVgap(1/4*tailleFY);
		fl_zone_droite.setHgap(1/2*tailleFX);
		zone_controle.add(zone_droite);
		
		JButton btnBoutonDroite = new JButton("bouton droite");
		zone_droite.add(btnBoutonDroite);
				
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnJouer = new JMenu("Jouer");
		menuBar.add(mnJouer);
		
		JMenu mnJouer_1 = new JMenu("Jouer");
		mnJouer.add(mnJouer_1);
		
		JMenuItem mntmMap = new JMenuItem("map1");
		mnJouer_1.add(mntmMap);
		
		JMenuItem mntmMap_1 = new JMenuItem("map2");
		mnJouer_1.add(mntmMap_1);
		
		JMenuItem mntmRgle = new JMenuItem("r\u00E8gle");
		mnJouer.add(mntmRgle);
		

		this.setVisible(true);
		
	}
	
	public void afficher(){

		getContentPane().add(zone_map, BorderLayout.CENTER);
		zone_map.repaint(); 

		try {
			Thread.sleep(10); // a une certaine vitesse --> 1000 = 1sec
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

}
