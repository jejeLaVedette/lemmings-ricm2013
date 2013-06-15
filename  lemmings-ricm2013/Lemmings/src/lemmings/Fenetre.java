package lemmings;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.ScrollPane;

import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import java.awt.Component;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.Box;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;



public class Fenetre extends JFrame implements Constantes, MouseListener, ActionListener{//implements MouseListener, ActionListener
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JSplitPane split2, split3;
	private int espacement_hori = 20;
	//private double coefFenetre = 0.75;
	private int typeCourant;
	
	//private Panneau zone_map = new Panneau(Jeu.tailleFX/Carte.LARGEUR_CARTE,(int)(coefFenetre*Jeu.tailleFY/Carte.HAUTEUR_CARTE));
	//private Panneau2 mini_map = new Panneau2(Jeu.tailleFX/Carte.LARGEUR_CARTE,(int)(coefFenetre*Jeu.tailleFY/Carte.HAUTEUR_CARTE));
	
	private Panneau zone_map;
	private Panneau2 mini_map;
	
	private JScrollPane scroll;
	
	public static int tailleFX;
	public static int tailleFY;
	
	//public static int restey = Jeu.tailleFY%Carte.HAUTEUR_CARTE;
	//public static int restex = Jeu.tailleFX%Carte.LARGEUR_CARTE;

	//DECLARATION DE TOUT LES BOUTONS
	private JButton bouton_creuse;
	private JButton bouton_parapluie;  
	private	JButton bouton_escalier;  
	private JButton bouton_futur1;  
	private JButton bouton_escalade;  
	private JButton bouton_bombe;  
	private JButton bouton_stop; 
	private JButton bouton_futur2; 
	private JButton bouton_play;  
	private JButton bouton_pause;  
	private JButton bouton_accelerer; 
	private JButton bouton_recharger; 


	public Fenetre(int tFX, int tFY) throws IOException {

		tailleFX = tFX;
		tailleFY = tFY;
		
		this.setTitle("Lemmings");
		this.setSize(tFX, tFY);
		//empeche le redimentionnement de la fenetre
		this.setResizable(false);
		//Positionne l'objet au centre
		this.setLocationRelativeTo(null);
		//Termine le processus lorsqu'on clique sur la croix rouge
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//modifie le logo en haut a gauche
		Image icone = new ImageIcon("Images/Logo.jpg").getImage();
		setIconImage(icone);

		zone_map = new Panneau(tailleFX, tailleFY);
		mini_map = new Panneau2(tailleFX, tailleFY);
		
		//ZONE QUI CONTIENT LA MINIMAP
		JPanel zone_droite = new JPanel();
		GridBagConstraints c = new GridBagConstraints();
		c.ipadx = tailleFX/2;
		c.ipady = tailleFY/4;
		zone_droite.setLayout(new GridBagLayout());
		FlowLayout flowLayout = (FlowLayout) mini_map.getLayout();
		flowLayout.setVgap(25);
		flowLayout.setHgap(-6);
		zone_droite.add(mini_map,c);

		// Initialisation des boutons
		initBoutons();
		
		//ZONE QUI CONTIENT LES BOUTONS
		JPanel zone_gauche = new JPanel();

		JPanel bouton_sup = new JPanel();
		//On définit le layout en lui indiquant qu'il travaillera en ligne
		bouton_sup.setLayout(new BoxLayout(bouton_sup, BoxLayout.LINE_AXIS));
		zone_gauche.add(bouton_sup);

		bouton_sup.add(bouton_creuse);

		Component horizontalStrut_3 = Box.createHorizontalStrut(espacement_hori);
		bouton_sup.add(horizontalStrut_3);

		bouton_sup.add(bouton_parapluie);

		Component horizontalStrut_4 = Box.createHorizontalStrut(espacement_hori);
		bouton_sup.add(horizontalStrut_4);

		bouton_sup.add(bouton_escalier);

		Component horizontalStrut_5 = Box.createHorizontalStrut(espacement_hori);
		bouton_sup.add(horizontalStrut_5);

		bouton_sup.add(bouton_futur1);

		Component horizontalStrut_6 = Box.createHorizontalStrut(espacement_hori);
		bouton_sup.add(horizontalStrut_6);



		JPanel bouton_inf1 = new JPanel();
		//Idem pour cette ligne
		bouton_inf1.setLayout(new BoxLayout(bouton_inf1, BoxLayout.LINE_AXIS));
		bouton_inf1.add(bouton_escalade);

		Component horizontalStrut_10 = Box.createHorizontalStrut(espacement_hori);
		bouton_inf1.add(horizontalStrut_10);

		bouton_inf1.add(bouton_bombe);

		Component horizontalStrut_7 = Box.createHorizontalStrut(espacement_hori);
		bouton_inf1.add(horizontalStrut_7);

		bouton_inf1.add(bouton_stop);

		Component horizontalStrut_8 = Box.createHorizontalStrut(espacement_hori);
		bouton_inf1.add(horizontalStrut_8);

		bouton_inf1.add(bouton_futur2);

		Component horizontalStrut_9 = Box.createHorizontalStrut(espacement_hori);
		bouton_inf1.add(horizontalStrut_9);



		JPanel bouton_inf2 = new JPanel();
		//Idem pour cette ligne
		bouton_inf2.setLayout(new BoxLayout(bouton_inf2, BoxLayout.LINE_AXIS));
		bouton_inf2.add(bouton_play);

		Component horizontalStrut = Box.createHorizontalStrut(espacement_hori);
		bouton_inf2.add(horizontalStrut);
		bouton_inf2.add(bouton_pause);

		Component horizontalStrut_1 = Box.createHorizontalStrut(espacement_hori);
		bouton_inf2.add(horizontalStrut_1);
		bouton_inf2.add(bouton_accelerer);

		Component horizontalStrut_2 = Box.createHorizontalStrut(espacement_hori);
		bouton_inf2.add(horizontalStrut_2);
		bouton_inf2.add(bouton_recharger);
		Component horizontalStrut_42 = Box.createHorizontalStrut(espacement_hori);
		bouton_inf2.add(horizontalStrut_42);

		//On positionne maintenant ces trois lignes en colonne
		zone_gauche.setLayout(new BoxLayout(zone_gauche, BoxLayout.PAGE_AXIS));
		zone_gauche.add(bouton_sup);
		zone_gauche.add(bouton_inf1);
		zone_gauche.add(bouton_inf2);
		
		// Scrollbar
		zone_map.setPreferredSize(new Dimension(Carte.LARGEUR_CARTE,Carte.HAUTEUR_CARTE));
		scroll = new JScrollPane(zone_map);
		this.setLayout(new BorderLayout());
		

		//On place le premier séparateur
		split2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, zone_gauche, zone_droite);
		//On place le deuxième séparateur
		split2.setDividerLocation(tFX/2);
		//On passe les deux précédents JSplitPane à celui-ci
		split3 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, scroll, split2);
		//On place le troisieme séparateur
		split3.setDividerLocation(3*tFY/5);

		//On le passe ensuite au content pane de notre objet Fenetre
		//placé au centre pour qu'il utilise tout l'espace disponible
		//this.add(split3, BorderLayout.CENTER);
		this.getContentPane().add(split3, BorderLayout.CENTER);
		
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

		JMenuItem mntmRgle = new JMenuItem("r\u00E8gles");
		mnJouer.add(mntmRgle);



		zone_map.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				modifType(event);
			}
		});

		this.setVisible(true);

	}

	public void afficher(){
		scroll.repaint();
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

	public void mouseClicked(MouseEvent arg0) {

	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bouton_creuse) {typeCourant = lemmingCreuseur; /*System.out.println("Bouton pioche");*/}
		if(e.getSource()==bouton_parapluie) typeCourant = lemmingParapluie;
	}


	public void modifType(MouseEvent event){
		//on récupére les coordonnée X de la souris    
		int newCx = ((event.getX())*Carte.LARGEUR_CARTE)/(tailleFX);
		//on réccupére les coordonnée Y de la souris
		int newCy = ((event.getY())*Carte.HAUTEUR_CARTE)/(3*tailleFY/5);

		Observable lem;
		for (int i =0;i<Carte.obs.size();i++){
			lem = Carte.obs.get(i);
			if((newCy<lem.getY() && newCy>lem.getY() -2*Panneau.coeff) && ((newCx<lem.getX()+3/2*Panneau.coeff && newCx > lem.getX()-3/2*Panneau.coeff))){
				if(typeCourant == lemmingParapluie){
					Carte.obs.get(i).setEtat(etatParapluieOuvert);
				}
				Carte.obs.get(i).type=typeCourant;
				//System.out.println("x souris : "+newCx);
				//System.out.println("y souris : "+newCy);
				//System.out.println("x lem : "+lem.getX());
				//System.out.println("y lem : "+lem.getY());

				break;
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
	
	private void initBoutons () {
		bouton_creuse = new JButton(new ImageIcon(((new ImageIcon("Images/pioche.png")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)));
		bouton_parapluie = new JButton(new ImageIcon(((new ImageIcon("Images/parapluie_ferme.jpg")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)));  
		bouton_escalier = new JButton(new ImageIcon(((new ImageIcon("Images/escalier.png")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)));  
		bouton_futur1 = new JButton(new ImageIcon(((new ImageIcon("Images/interrogation.png")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)));  
		bouton_escalade = new JButton(new ImageIcon(((new ImageIcon("Images/escalade.png")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)));  
		bouton_bombe = new JButton(new ImageIcon(((new ImageIcon("Images/bombe.png")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)));  
		bouton_stop = new JButton(new ImageIcon(((new ImageIcon("Images/lemming3.png")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH))); 
		bouton_futur2 = new JButton(new ImageIcon(((new ImageIcon("Images/interrogation.png")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH))); 
		bouton_play = new JButton(new ImageIcon(((new ImageIcon("Images/play.png")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)));  
		bouton_pause = new JButton(new ImageIcon(((new ImageIcon("Images/pause.png")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)));  
		bouton_accelerer = new JButton(new ImageIcon(((new ImageIcon("Images/accelerer.png")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH))); 
		bouton_recharger = new JButton(new ImageIcon(((new ImageIcon("Images/recharger.png")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH))); 

		//MISE EN ATTENTE DES BOUTONS
		bouton_creuse.addActionListener(this);
		bouton_parapluie.addActionListener(this);
		bouton_escalier.addActionListener(this);
		bouton_futur1.addActionListener(this);
		bouton_escalade.addActionListener(this);
		bouton_escalade.addActionListener(this);
		bouton_bombe.addActionListener(this);
		bouton_stop.addActionListener(this);
		bouton_futur2.addActionListener(this);
		bouton_play.addActionListener(this);
		bouton_pause.addActionListener(this);
		bouton_accelerer.addActionListener(this);
		bouton_recharger.addActionListener(this);
	}
	
	
}
