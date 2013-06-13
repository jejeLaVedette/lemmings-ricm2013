package lemmings;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JSplitPane;
import javax.swing.Spring;
import javax.swing.SpringLayout.Constraints;

import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;



public class Fenetre extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static int tailleFX = 1000;
	private JSplitPane split2, split3;
	public static int tailleFY = 650;
	private int espacement_hori = 20;
	private double coefFenetre = 0.75;
	private Panneau zone_map = new Panneau(Fenetre.tailleFX/Carte.LARGEUR_CARTE,(int)(coefFenetre*Fenetre.tailleFY/Carte.HAUTEUR_CARTE));
	private Panneau2 mini_map = new Panneau2(Fenetre.tailleFX/Carte.LARGEUR_CARTE,(int)(coefFenetre*Fenetre.tailleFY/Carte.HAUTEUR_CARTE));


	public Fenetre() throws IOException{
		this.setTitle("Lemmings");
		this.setSize(tailleFX, tailleFY);
		//empeche le redimentionnement de la fenetre
		this.setResizable(false);
		//Positionne l'objet au centre
		this.setLocationRelativeTo(null);
		//Termine le processus lorsqu'on clique sur la croix rouge
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//ZONE QUI CONTIENT LA MINIMAP
		JPanel zone_droite = new JPanel();
		GridBagConstraints c = new GridBagConstraints();
		c.ipadx = tailleFX/2;
		c.ipady = tailleFY/4;
		zone_droite.setLayout(new GridBagLayout());
		zone_droite.add(mini_map,c);



		//ZONE QUI CONTIENT LES BOUTONS
		JPanel zone_gauche = new JPanel();

		JPanel bouton_sup = new JPanel();
		//On d�finit le layout en lui indiquant qu'il travaillera en ligne
		bouton_sup.setLayout(new BoxLayout(bouton_sup, BoxLayout.LINE_AXIS));
		zone_gauche.add(bouton_sup);

		JButton bouton_creuse = new JButton(new ImageIcon(((new ImageIcon("Images/pioche.png")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)));
		bouton_sup.add(bouton_creuse);

		Component horizontalStrut_3 = Box.createHorizontalStrut(espacement_hori);
		bouton_sup.add(horizontalStrut_3);

		JButton bouton_parapluie = new JButton(new ImageIcon(((new ImageIcon("Images/parapluie_ferme.jpg")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)));  
		bouton_sup.add(bouton_parapluie);

		Component horizontalStrut_4 = Box.createHorizontalStrut(espacement_hori);
		bouton_sup.add(horizontalStrut_4);

		JButton bouton_saiyan = new JButton(new ImageIcon(((new ImageIcon("Images/ss.png")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)));  
		bouton_sup.add(bouton_saiyan);
		// zone_gauche.setBackground(Color.orange);


		JPanel bouton_inf = new JPanel();
		//Idem pour cette ligne
		bouton_inf.setLayout(new BoxLayout(bouton_inf, BoxLayout.LINE_AXIS));
		JButton bouton_play = new JButton(new ImageIcon(((new ImageIcon("Images/play.png")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)));  
		bouton_inf.add(bouton_play);

		Component horizontalStrut = Box.createHorizontalStrut(espacement_hori);
		bouton_inf.add(horizontalStrut);
		JButton bouton_pause = new JButton(new ImageIcon(((new ImageIcon("Images/pause.png")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)));  
		bouton_inf.add(bouton_pause);

		Component horizontalStrut_1 = Box.createHorizontalStrut(espacement_hori);
		bouton_inf.add(horizontalStrut_1);
		JButton bouton_accelerer = new JButton(new ImageIcon(((new ImageIcon("Images/accelerer.png")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH))); 
		bouton_inf.add(bouton_accelerer);

		Component horizontalStrut_2 = Box.createHorizontalStrut(espacement_hori);
		bouton_inf.add(horizontalStrut_2);
		JButton bouton_recharger = new JButton(new ImageIcon(((new ImageIcon("Images/recharger.png")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH))); 
		bouton_inf.add(bouton_recharger);
		Component horizontalStrut_42 = Box.createHorizontalStrut(espacement_hori);
		bouton_inf.add(horizontalStrut_42);

		//On positionne maintenant ces trois lignes en colonne
		zone_gauche.setLayout(new BoxLayout(zone_gauche, BoxLayout.PAGE_AXIS));
		zone_gauche.add(bouton_sup);
		zone_gauche.add(bouton_inf);




		//On place le premier s�parateur
		split2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, zone_gauche, zone_droite);
		//On place le deuxi�me s�parateur
		split2.setDividerLocation(tailleFX/2);
		//On passe les deux pr�c�dents JSplitPane � celui-ci
		split3 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, zone_map, split2);
		//On place le troisi�me s�parateur
		split3.setDividerLocation(3*tailleFY/4);




		//On le passe ensuite au content pane de notre objet Fenetre
		//plac� au centre pour qu'il utilise tout l'espace disponible
		this.getContentPane().add(split3, BorderLayout.CENTER);

		this.setVisible(true);

	}

	public void afficher(){

		zone_map.repaint();
		mini_map.repaint();

		try {
			Thread.sleep(10); // a une certaine vitesse --> 1000 = 1sec
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int getTailleX() {
		return zone_map.getWidth();
	}

	public int getTailleY() {
		return zone_map.getHeight();
	}

	public static BufferedImage scale(BufferedImage bImage, float factorx, float factory) {
		int destWidth=(int) (bImage.getWidth() * factorx);	
		int destHeight=(int) (bImage.getHeight() * factory);
		//cr�er l'image de destination
		GraphicsConfiguration configuration = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
		BufferedImage bImageNew = configuration.createCompatibleImage(destWidth, destHeight);
		Graphics2D graphics = bImageNew.createGraphics();
		graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
		//dessiner l'image de destination
		graphics.drawImage(bImage, 0, 0, destWidth, destHeight, 0, 0, bImage.getWidth(), bImage.getHeight(), null);
		graphics.dispose();

		return bImageNew;
	}


}
