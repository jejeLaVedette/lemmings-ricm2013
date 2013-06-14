package lemmings;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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



public class Fenetre extends JFrame implements Constantes{//implements MouseListener, ActionListener
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static int tailleFX = 1000;
	private JSplitPane split2, split3;
	public static int tailleFY = 700;
	private int espacement_hori = 20;
	private double coefFenetre = 0.75;
	private int knowButton;
	private int typeCourant;
	private Panneau zone_map = new Panneau(Fenetre.tailleFX/Carte.LARGEUR_CARTE,(int)(coefFenetre*Fenetre.tailleFY/Carte.HAUTEUR_CARTE));
	private Panneau2 mini_map = new Panneau2(Fenetre.tailleFX/Carte.LARGEUR_CARTE,(int)(coefFenetre*Fenetre.tailleFY/Carte.HAUTEUR_CARTE));
	public static int restey = tailleFY%Carte.HAUTEUR_CARTE;
	public static int restex = tailleFX%Carte.LARGEUR_CARTE;




	public Fenetre() throws IOException {

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

		//ZONE QUI CONTIENT LA MINIMAP
		JPanel zone_droite = new JPanel();
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.ipadx = tailleFX/2;
		c.ipady = tailleFY/4;
		zone_droite.setLayout(new GridBagLayout());
		FlowLayout flowLayout = (FlowLayout) mini_map.getLayout();
		flowLayout.setVgap(25);
		flowLayout.setHgap(-6);
		zone_droite.add(mini_map,c);


		//ZONE QUI CONTIENT LES BOUTONS
		JPanel zone_gauche = new JPanel();

		
		zone_map.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent event) {
				modifType(event);
			}
		});

		JPanel bouton_sup = new JPanel();
		//On dï¿½finit le layout en lui indiquant qu'il travaillera en ligne
		bouton_sup.setLayout(new BoxLayout(bouton_sup, BoxLayout.LINE_AXIS));
		zone_gauche.add(bouton_sup);

		JButton bouton_creuse = new JButton(new ImageIcon(((new ImageIcon("Images/pioche.png")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)));
		bouton_creuse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				typeCourant = lemmingCreuseur;
			}
		});
		bouton_sup.add(bouton_creuse);

		Component horizontalStrut_3 = Box.createHorizontalStrut(espacement_hori);
		bouton_sup.add(horizontalStrut_3);

		JButton bouton_parapluie = new JButton(new ImageIcon(((new ImageIcon("Images/parapluie_ferme.jpg")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)));  
		bouton_parapluie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				typeCourant = lemmingParapluie;
			}
		});
		bouton_sup.add(bouton_parapluie);

		Component horizontalStrut_4 = Box.createHorizontalStrut(espacement_hori);
		bouton_sup.add(horizontalStrut_4);

		JButton bouton_escalier = new JButton(new ImageIcon(((new ImageIcon("Images/escalier.png")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)));  
		bouton_sup.add(bouton_escalier);

		Component horizontalStrut_5 = Box.createHorizontalStrut(espacement_hori);
		bouton_sup.add(horizontalStrut_5);

		JButton bouton_futur1 = new JButton(new ImageIcon(((new ImageIcon("Images/interrogation.png")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)));  
		bouton_sup.add(bouton_futur1);

		Component horizontalStrut_6 = Box.createHorizontalStrut(espacement_hori);
		bouton_sup.add(horizontalStrut_6);



		JPanel bouton_inf1 = new JPanel();
		//Idem pour cette ligne
		bouton_inf1.setLayout(new BoxLayout(bouton_inf1, BoxLayout.LINE_AXIS));
		JButton bouton_escalade = new JButton(new ImageIcon(((new ImageIcon("Images/escalade.png")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)));  
		bouton_inf1.add(bouton_escalade);

		Component horizontalStrut_10 = Box.createHorizontalStrut(espacement_hori);
		bouton_inf1.add(horizontalStrut_10);

		JButton bouton_bombe = new JButton(new ImageIcon(((new ImageIcon("Images/bombe.png")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)));  
		bouton_inf1.add(bouton_bombe);

		Component horizontalStrut_7 = Box.createHorizontalStrut(espacement_hori);
		bouton_inf1.add(horizontalStrut_7);

		JButton bouton_stop = new JButton(new ImageIcon(((new ImageIcon("Images/lemming3.png")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH))); 
		bouton_inf1.add(bouton_stop);

		Component horizontalStrut_8 = Box.createHorizontalStrut(espacement_hori);
		bouton_inf1.add(horizontalStrut_8);

		JButton bouton_futur2 = new JButton(new ImageIcon(((new ImageIcon("Images/interrogation.png")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH))); 
		bouton_inf1.add(bouton_futur2);

		Component horizontalStrut_9 = Box.createHorizontalStrut(espacement_hori);
		bouton_inf1.add(horizontalStrut_9);



		JPanel bouton_inf2 = new JPanel();
		//Idem pour cette ligne
		bouton_inf2.setLayout(new BoxLayout(bouton_inf2, BoxLayout.LINE_AXIS));
		JButton bouton_play = new JButton(new ImageIcon(((new ImageIcon("Images/play.png")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)));  
		bouton_inf2.add(bouton_play);

		Component horizontalStrut = Box.createHorizontalStrut(espacement_hori);
		bouton_inf2.add(horizontalStrut);
		JButton bouton_pause = new JButton(new ImageIcon(((new ImageIcon("Images/pause.png")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)));  
		bouton_inf2.add(bouton_pause);

		Component horizontalStrut_1 = Box.createHorizontalStrut(espacement_hori);
		bouton_inf2.add(horizontalStrut_1);
		JButton bouton_accelerer = new JButton(new ImageIcon(((new ImageIcon("Images/accelerer.png")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH))); 
		bouton_inf2.add(bouton_accelerer);

		Component horizontalStrut_2 = Box.createHorizontalStrut(espacement_hori);
		bouton_inf2.add(horizontalStrut_2);
		JButton bouton_recharger = new JButton(new ImageIcon(((new ImageIcon("Images/recharger.png")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH))); 
		bouton_inf2.add(bouton_recharger);
		Component horizontalStrut_42 = Box.createHorizontalStrut(espacement_hori);
		bouton_inf2.add(horizontalStrut_42);

		//On positionne maintenant ces trois lignes en colonne
		zone_gauche.setLayout(new BoxLayout(zone_gauche, BoxLayout.PAGE_AXIS));
		zone_gauche.add(bouton_sup);
		zone_gauche.add(bouton_inf1);
		zone_gauche.add(bouton_inf2);

		//On place le premier séparateur
		split2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, zone_gauche, zone_droite);
		//On place le deuxiï¿½me séparateur
		split2.setDividerLocation(tailleFX/2);
		//On passe les deux prï¿½cï¿½dents JSplitPane ï¿½ celui-ci
		split3 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, zone_map, split2);
		//On place le troisiï¿½me sï¿½parateur
		split3.setDividerLocation(3*tailleFY/5);

		//On le passe ensuite au content pane de notre objet Fenetre
		//placï¿½ au centre pour qu'il utilise tout l'espace disponible
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

		JMenuItem mntmRgle = new JMenuItem("r\u00E8gle");
		mnJouer.add(mntmRgle);

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

	public void mouseClicked(MouseEvent arg0) {
		knowButton=1;
		System.out.println("j'ai cliquer sur le bouton pioche");
	}
	


	public void modifType(MouseEvent event){
		System.out.println("je clique sur la map pioche");
		System.out.println("je clique sur la map parapluie");
		//on récupère les coordonnée X de la souris    
        int newCx = ((event.getX())*Carte.LARGEUR_CARTE)/(tailleFX);
        //on réccupère les coordonnée Y de la souris
        int newCy = ((event.getY())*Carte.HAUTEUR_CARTE)/(3*tailleFY/5);
        
        Observable lem;
        System.out.println("tentative de suppr lemmings#######1");
        for (int i =0;i<Carte.obs.size();i++){
                lem = Carte.obs.get(i);
                System.out.println("tentative de suppr lemmings#######1.2");
                if((newCy<lem.getY() && newCy>lem.getY() - Panneau.coeff) && ((newCx<lem.getX()+3/2*Panneau.coeff && newCx > lem.getX()-3/2*Panneau.coeff))){
                        System.out.println("tentative de suppr lemmings#######2");
                        if(typeCourant == lemmingParapluie){
                        	Carte.obs.get(i).setEtat(etatParapluieOuvert);
                        }
                        Carte.obs.get(i).type=typeCourant;
                }
        }
	}
}
