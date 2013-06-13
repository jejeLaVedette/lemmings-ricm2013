package lemmings;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;

import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.BoxLayout;
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
	
	private Panneau zone_map = new Panneau();
	public static int tailleFX = 1000;
	public static int tailleFY = 650;
	private int espacement_hori = 20;
	
	
	public Fenetre() throws IOException{
		this.setTitle("Lemmings");
		this.setSize(tailleFX, tailleFY);
		//empeche le redimentionnement de la fenetre
		this.setResizable(false);
		//Positionne l'objet au centre
		this.setLocationRelativeTo(null);
		//Termine le processus lorsqu'on clique sur la croix rouge
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		getContentPane().add(zone_map, BorderLayout.CENTER);
		
		JPanel zone_controle = new JPanel();
		getContentPane().add(zone_controle, BorderLayout.SOUTH);
		zone_controle.setLayout(new BoxLayout(zone_controle, BoxLayout.X_AXIS));

		JPanel zone_gauche = new JPanel();
		//zone_gauche.setBounds(0,3/4*tailleFY ,tailleFX/2,1/4*tailleFY);
		zone_controle.add(zone_gauche);
		//zone_gauche.setPreferredSize(new Dimension(tailleFX/2, 1/4*tailleFY));

		JPanel bouton_sup = new JPanel();
	    //On dï¿½finit le layout en lui indiquant qu'il travaillera en ligne

		bouton_sup.setLayout(new BoxLayout(bouton_sup, BoxLayout.LINE_AXIS));
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
	    
	    JSeparator separator = new JSeparator();
	    separator.setOrientation(SwingConstants.VERTICAL);
	    //separator.setBounds(tailleFX/2, 1/4*tailleFY, 100, 100);
	    zone_controle.add(separator);
	    //System.out.println("sepa : "+separator.setB);

	    
	    JPanel zone_droite = new JPanel();
		zone_droite.setBounds(tailleFX/2,(3/4)*tailleFY ,tailleFX/2,tailleFY/4);
	    zone_controle.add(zone_droite);
	    System.out.println("x zone : " + zone_droite.getX());
	    
	    JLabel img = new JLabel();
	    BufferedImage b = ImageIO.read(new File(Carte.miniMap));
	    float newx = ((float) zone_droite.getWidth())/((float)b.getWidth());
	    float newy = ((float) zone_droite.getHeight())/((float)b.getHeight());
	    System.out.println("zone_droite.getWidth() : "+zone_droite.getWidth());
	    System.out.println("zone_droite.getHeight() : "+zone_droite.getHeight());
	    System.out.println("b.getWidth() : "+b.getWidth());
	    System.out.println("b.getHeight() : "+b.getHeight());

	    System.out.println("newx : "+newx);
	    System.out.println("newy : "+newy);


	    img.setIcon(new ImageIcon(scale(b,newx,newy)));
	    //img.setBounds(tailleFX/2,(3/4)*tailleFY ,tailleFX/2,tailleFY/4);
	    
	    System.out.println("y img : "+img.getHeight());
	    System.out.println("x img : "+img.getWidth());

	    zone_droite.add(img);
		
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
		

		System.out.println("y zone_droite : "+zone_droite.getHeight());
		System.out.println("x zone_droite : "+zone_droite.getWidth());
		System.out.println("tailleFy : "+tailleFY);
		
		this.setVisible(true);
		
	}
	
	public void afficher(){

		zone_map.repaint(); 

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
	//créer l'image de destination
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
