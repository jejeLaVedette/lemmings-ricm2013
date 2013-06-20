package lemmings;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Point;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import java.awt.Component;
import java.io.IOException;
import java.text.NumberFormat;

import javax.swing.ImageIcon;
import javax.swing.Box;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;



public class Fenetre extends JFrame implements Constantes, MouseListener, ActionListener{

	private static final long serialVersionUID = 1L;

	private JPanel container = new JPanel();
	private JFormattedTextField Tangle = new JFormattedTextField(NumberFormat.getIntegerInstance());
	private JFormattedTextField Tpuissance = new JFormattedTextField(NumberFormat.getIntegerInstance());
	private JLabel label = new JLabel("Entrez un angle : ");
	private JLabel label2 = new JLabel("Entrez une puissance : ");
	private final JFrame frame = new JFrame("R�glage catapulte");
	private JSplitPane split2, split3;
	private int espacement_hori = 20;
	private int espacement_text = 65;
	private int typeCourant;
	private int catapulteX = 100;
	private int catapulteY = 150;

	public static Panneau zone_map;
	public static Panneau2 mini_map;

	public static JScrollPane scroll;

	public static int tailleFX;
	public static int tailleFY;

	public static int restey = tailleFenetreV%Carte.HAUTEUR_CARTE;
	public static int restex = tailleFenetreH%Carte.LARGEUR_CARTE;
	public static int etatSouris;

	//DECLARATION DE TOUT LES BOUTONS
	private JButton bouton_creuse;
	private JButton bouton_parapluie;  
	private JButton bouton_escalier;  
	private JButton bouton_Catapulte;  
	private JButton bouton_escalade;  
	private JButton bouton_bombe;  
	private JButton bouton_stop; 
	private JButton bouton_futur2; 
	private JButton bouton_play;  
	private JButton bouton_pause;  
	private JButton bouton_accelerer; 
	private JButton bouton_recharger; 
	private JButton bouton_lemmingSave;
	private JButton bouton_suppr;
	private JButton b2 = new JButton ("OK");

	//DECLARATION DE TOUT LES TEXTES DES COMPTEURS
	private JLabel tPioche;
	private JLabel tParapluie;
	private JLabel tEscalier;
	private JLabel tCatapulte;
	private JLabel tEscalade;
	private JLabel tBombe;
	private JLabel tStop;
	private JLabel tFutur2;
	private JLabel tLemmingSave;

	private int ancienNum;
	private int puissance;
	private double angle;

	// Menu
	private JMenuBar menuBar;
	private JMenu mnJouer;
	private JMenu mnCarte;
	private JMenuItem mnJouer_1;
	private JMenuItem mntmMap;
	private JMenuItem mntmMap2;
	private JMenuItem mntmMap3;
	private JMenuItem mntmMap4;
	private JMenuItem mntmMap5;
	private JMenuItem mntmRgle;
	private JMenuItem mntmFermer;
	private JMenuItem chargement;
	private JMenu mnMap;
	private JMenuItem mapDetail;

	private JMenu mnMap2;

	private JMenuItem map2Detail;

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

		zone_map = new Panneau(Fenetre.tailleFX, Fenetre.tailleFY);
		mini_map = new Panneau2(Fenetre.tailleFX, Fenetre.tailleFY);


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

		//LES CHIFFRES QUI REPRESENTE LE NOMBRE D'OBJETS
		JPanel text1 = new JPanel();
		JPanel text2 = new JPanel();

		JPanel bouton_sup = new JPanel();

		//On d�finit le layout en lui indiquant qu'il travaillera en ligne
		bouton_sup.setLayout(new BoxLayout(bouton_sup, BoxLayout.LINE_AXIS));

		bouton_sup.add(bouton_creuse);

		Component horizontalStrut_3 = Box.createHorizontalStrut(espacement_hori);
		bouton_sup.add(horizontalStrut_3);

		bouton_sup.add(bouton_parapluie);

		Component horizontalStrut_4 = Box.createHorizontalStrut(espacement_hori);
		bouton_sup.add(horizontalStrut_4);

		bouton_sup.add(bouton_escalier);

		Component horizontalStrut_5 = Box.createHorizontalStrut(espacement_hori);
		bouton_sup.add(horizontalStrut_5);

		bouton_sup.add(bouton_Catapulte);

		Component horizontalStrut_12 = Box.createHorizontalStrut(espacement_hori);
		bouton_sup.add(horizontalStrut_12);

		bouton_sup.add(bouton_lemmingSave);

		
		
		text1.setLayout(new BoxLayout(text1, BoxLayout.LINE_AXIS));

		text1.add(tPioche);
		Component horizontalStrut_t1 = Box.createHorizontalStrut(espacement_text);
		text1.add(horizontalStrut_t1);

		text1.add(tParapluie);
		Component horizontalStrut_t2 = Box.createHorizontalStrut(espacement_text);
		text1.add(horizontalStrut_t2);

		text1.add(tEscalier);
		Component horizontalStrut_t3 = Box.createHorizontalStrut(espacement_text);
		text1.add(horizontalStrut_t3);

		text1.add(tCatapulte);

		Component horizontalStrut_t11 = Box.createHorizontalStrut(espacement_text);
		text1.add(horizontalStrut_t11);

		text1.add(tLemmingSave);



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


		text2.setLayout(new BoxLayout(text2, BoxLayout.LINE_AXIS));

		Component horizontalStrut_tbonus = Box.createHorizontalStrut(espacement_text);
		text2.add(horizontalStrut_tbonus);

		text2.add(tEscalade);
		Component horizontalStrut_t4 = Box.createHorizontalStrut(espacement_text);
		text2.add(horizontalStrut_t4);

		text2.add(tBombe);
		Component horizontalStrut_t5 = Box.createHorizontalStrut(espacement_text);
		text2.add(horizontalStrut_t5);

		text2.add(tStop);
		Component horizontalStrut_t6 = Box.createHorizontalStrut(espacement_text);
		text2.add(horizontalStrut_t6);

		text2.add(tFutur2);
		Component horizontalStrut_t7 = Box.createHorizontalStrut(espacement_text);
		text2.add(horizontalStrut_t7);


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
		
		Component horizontalStrut_13 = Box.createHorizontalStrut(espacement_hori);
		bouton_inf2.add(horizontalStrut_13);
		bouton_inf2.add(bouton_suppr);

		//On positionne maintenant en colonne
		zone_gauche.setLayout(new BoxLayout(zone_gauche, BoxLayout.PAGE_AXIS));
		zone_gauche.add(bouton_sup);
		zone_gauche.add(text1);
		zone_gauche.add(bouton_inf1);
		zone_gauche.add(text2);
		zone_gauche.add(bouton_inf2);

		// Scrollbar
		scroll = new JScrollPane(zone_map);
		zone_map.setPreferredSize(new Dimension(Carte.LARGEUR_CARTE,Carte.HAUTEUR_CARTE));
		this.setLayout(new BorderLayout());

		//On place le premier s�parateur
		split2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, zone_gauche, zone_droite);
		//On place le deuxi�me s�parateur
		split2.setDividerLocation(tFX/2);
		//On passe les deux pr�c�dents JSplitPane � celui-ci
		split3 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, scroll, split2);
		//On place le troisieme s�parateur
		split3.setDividerLocation(3*tFY/5);

		//On le passe ensuite au content pane de notre objet Fenetre
		//plac� au centre pour qu'il utilise tout l'espace disponible
		this.getContentPane().add(split3, BorderLayout.CENTER);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnJouer = new JMenu("Jouer");
		menuBar.add(mnJouer);

		mnCarte = new JMenu("Carte");
		menuBar.add(mnCarte);

		mnJouer_1 = new JMenuItem("Nouveau Jeu");
		mnJouer.add(mnJouer_1);
		mnJouer_1.addActionListener(this);

		mnMap = new JMenu("map1");
		mnCarte.add(mnMap);
		mntmMap = new JMenuItem("Jouer");
		mnMap.add(mntmMap);
		mntmMap.addActionListener(this);
		mapDetail = new JMenuItem("D�tails");
		mnMap.add(mapDetail);
		mapDetail.addActionListener(this);

		mnMap2 = new JMenu("map2");
		mnCarte.add(mnMap2);
		mntmMap2 = new JMenuItem("Jouer");
		mnMap2.add(mntmMap2);
		mntmMap2.addActionListener(this);
		map2Detail = new JMenuItem("D�tails");
		mnMap2.add(map2Detail);
		map2Detail.addActionListener(this);
		
		

		
		
		
		mntmMap3 = new JMenuItem("map3");
		mnCarte.add(mntmMap3);
		mntmMap3.addActionListener(this);

		mntmMap4 = new JMenuItem("map4");
		mnCarte.add(mntmMap4);
		mntmMap4.addActionListener(this);

		mntmMap5 = new JMenuItem("map5");
		mnCarte.add(mntmMap5);
		mntmMap5.addActionListener(this);

		mntmRgle = new JMenuItem("r\u00E8gles");
		mnJouer.add(mntmRgle);
		mntmRgle.addActionListener(this);

		mntmFermer = new JMenuItem("Fermer");
		mnJouer.add(mntmFermer);
		mntmFermer.addActionListener(this);

		chargement = new JMenuItem("chargement de map...");
		mnCarte.add(chargement);
		chargement.addActionListener(this);


		zone_map.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent event) {
				modifType(event);
			}
		});

		this.setVisible(true);
		
		

	}

	public void afficher(){
		scroll.repaint();
		tLemmingSave.setText("" + Carte.lemmingSauf);
		mini_map.repaint();
		try {
			Thread.sleep(10); // a une certaine vitesse --> 1000 = 1sec
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void mouseClicked(MouseEvent arg0) {

	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==chargement) FileChooser.createAndShowGUI();

		if(e.getSource()==mntmMap || e.getSource()==mnJouer_1){
			try {

				Jeu.playWave.stop();
				Carte.lemmingSauf=0;
				Carte.lemmingASauver=10;
				Carte.initCmp(4, 20, 4, 0, 0, 0, 4, 0);
				afficherTexteCmp();
				Jeu.initialiserJeu("Images/Carte4.png", 
						"Images/Carte4.png", 
						"Musiques/fairy_tail.wav", 
						"Automates/automate.xml", 
						new Point(60,55), 
						new Point(330,125), 
						20);


			} catch (IOException ev) {
				// TODO Auto-generated catch block
				ev.printStackTrace();
			}
		}
		
		if(e.getSource()==mapDetail){
			JOptionPane.showMessageDialog(null, "Map1\n lemmings a sauver : 10 \n every gooo Mariooo!!", "Map Mario", 0, new ImageIcon("ImagesMenu/carte3.png"));
		}
		
		
		
		if(e.getSource()==map2Detail){
			JOptionPane.showMessageDialog(null, "Map1\n lemmings a sauver : 10 \n every gooo Mariooo!!", "Map Mario", 0, new ImageIcon("ImagesMenu/map1.png"));
		}

		if(e.getSource()==mntmMap2){
			try {
				Jeu.playWave.stop();
				Carte.lemmingSauf=0;
				Carte.lemmingASauver=10;
				Carte.initCmp(4, 4, 6, 0, 0, 0, 2, 0);
				afficherTexteCmp();
				Jeu.initialiserJeu("Images/map1.png", 
						"Images/mario.png", 
						"", 
						"Automates/automate.xml", 
						new Point(60,55), 
						new Point(330,125), 
						20);
				

			} catch (IOException ev) {
				// TODO Auto-generated catch block
				ev.printStackTrace();
			} 
		}
	
		if(e.getSource()==mntmRgle) {
			String regle = "Le but du jeu et de sauver les lemmings. \n Pour ce faire, vous devez les ammener de la porte de sortie à la porte d'entrée. \n Evitez de gaspiller vos lemmings, ils ont tous leur importance";
			JOptionPane.showMessageDialog(null, regle);
		}


		if(e.getSource()==mntmFermer) System.exit(0); //on close la fen�tre et le jeu


		if(e.getSource()==mntmMap3){
			try {
				Carte.lemmingSauf=0;
				Carte.lemmingASauver=10;
				Carte.initCmp(4, 4, 6, 0, 0, 0, 2, 0);
				afficherTexteCmp();
				Jeu.initialiserJeu("Images/carte3.png", 
						"Images/carte3.png", 
						"", 
						"Automates/automate.xml", 
						new Point(60,55), 
						new Point(330,125), 
						20);
				
			} catch (IOException ev) {
				// TODO Auto-generated catch block
				ev.printStackTrace();
			}
		}
		


		if(e.getSource()==bouton_creuse) typeCourant = lemmingCreuseur; 
		if(e.getSource()==bouton_parapluie) typeCourant = lemmingParapluie;
		if(e.getSource()==bouton_stop) typeCourant = lemmingStop;
		if(e.getSource()==bouton_escalier) typeCourant = lemmingEscalier;
		if(e.getSource()==bouton_suppr) {
			String s; 
			Carte.setNbLemmings(0);
			Carte.obs.removeAll(Carte.obs);
			if(Carte.lemmingSauf>Carte.lemmingASauver) s = "lemming(s) sauv�(s) : "+ Carte.lemmingSauf+"\n Vous avez gagn�!!";
			else s = "lemming sauver : "+ Carte.lemmingSauf+"\n Vous avez perdu";
			JOptionPane.showMessageDialog(null, s);
		}
		
		if(e.getSource()==bouton_Catapulte){
			Carte.cmpCatapulte--;
			bouton_Catapulte.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(Carte.cmpCatapulte < 0) tCatapulte.setText("0");
					else {
						tCatapulte.setText("" + Carte.cmpCatapulte);
						System.out.println("cmpF : "+Carte.cmpCatapulte);

						frame.setSize(370, 110);
						frame.setResizable(false);
						frame.setLocationRelativeTo(null);

						container.setLayout(new BorderLayout());
						JPanel top = new JPanel();       
						Font police = new Font("Arial", Font.BOLD, 14);

						Tangle.setFont(police);
						Tangle.setPreferredSize(new Dimension(150, 30));
						Tangle.setForeground(Color.BLUE);

						Tpuissance.setFont(police);
						Tpuissance.setPreferredSize(new Dimension(150, 30));
						Tpuissance.setForeground(Color.BLUE);

						b2.addActionListener(new BoutonListener());

						top.add(label); 
						top.add(Tangle);
						top.add(label2);
						top.add(Tpuissance);
						top.add(b2);

						frame.setContentPane(top);
						frame.setVisible(true);
					}
				}
			});
		}

	}


	public void modifType(MouseEvent event){
		int newCx;
		int newCy;
		if(tailleFX>=Carte.LARGEUR_CARTE) {
			newCx = ((event.getX()*Carte.LARGEUR_CARTE))/(tailleFX);
		}
		else {
			newCx =event.getX(); //newCx = ((event.getX()*tailleFX*(Carte.LARGEUR_CARTE/Fenetre.tailleFX)))/(Carte.LARGEUR_CARTE);
		}
		if((3*tailleFY/5)>=Carte.HAUTEUR_CARTE) {
			newCy = ((event.getY())*Carte.HAUTEUR_CARTE)/((3*tailleFY/5));
		}
		else {
			newCy = event.getY();//newCy = ((event.getY())*3*tailleFY/5)/(Carte.HAUTEUR_CARTE);
		}

		Observable lem;
		for (int i =0;i<Carte.obs.size();i++){
			lem = Carte.obs.get(i);
			if((newCy<lem.getY() && newCy>lem.getY() -2*Panneau.coeff) && ((newCx<lem.getX()+3/2*Panneau.coeff && newCx > lem.getX()-3/2*Panneau.coeff))){
				if(typeCourant != lem.type){
					//this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					etatSouris=1;
					if(typeCourant == lemmingParapluie){
						if(Carte.cmpParapluie-- <= 0) tParapluie.setText("0");
						else tParapluie.setText("" + Carte.cmpParapluie);
						this.ancienNum = Carte.cmpParapluie;
					}

					if(typeCourant == lemmingCreuseur){
						if(Carte.cmpPioche-- <= 0) tPioche.setText("0");
						else tPioche.setText("" + Carte.cmpPioche);
						this.ancienNum = Carte.cmpPioche;
					}

					if(typeCourant == lemmingStop){
						if(Carte.cmpStop-- <= 0) tStop.setText("0");
						else tStop.setText("" + Carte.cmpStop);
						this.ancienNum = Carte.cmpStop;
					}

					if(typeCourant == lemmingEscalier){
						if(Carte.cmpEscalier-- <= 0) tEscalier.setText("0");
						else tEscalier.setText("" + Carte.cmpEscalier);
						this.ancienNum = Carte.cmpEscalier;
					}

					if(this.ancienNum>=0) {
						Carte.obs.get(i).type=typeCourant;
					}

					System.out.println("x souris : "+newCx);
					System.out.println("y souris : "+newCy);
					System.out.println("x souris fen: "+event.getX());
					System.out.println("y souris fen: "+event.getY());
					System.out.println("x lem : "+lem.getX());
					System.out.println("y lem : "+lem.getY());
					System.out.println("??????????");
					break;
				}
			}
			System.out.println("x souris map: "+newCx);
			System.out.println("y souris map: "+newCy);
			System.out.println("x souris fen: "+event.getX());
			System.out.println("y souris fen: "+event.getY());
			System.out.println("x lem : "+lem.getX());
			System.out.println("y lem : "+lem.getY());
			System.out.println("###########");
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
		bouton_Catapulte = new JButton(new ImageIcon(((new ImageIcon("Images/Catapulte.png")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)));  
		bouton_escalade = new JButton(new ImageIcon(((new ImageIcon("Images/escalade.png")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)));  
		bouton_bombe = new JButton(new ImageIcon(((new ImageIcon("Images/bombe.png")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)));  
		bouton_stop = new JButton(new ImageIcon(((new ImageIcon("Images/lemming3.png")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH))); 
		bouton_futur2 = new JButton(new ImageIcon(((new ImageIcon("Images/interrogation.png")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH))); 
		bouton_play = new JButton(new ImageIcon(((new ImageIcon("Images/play.png")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)));  
		bouton_pause = new JButton(new ImageIcon(((new ImageIcon("Images/pause.png")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)));  
		bouton_accelerer = new JButton(new ImageIcon(((new ImageIcon("Images/accelerer.png")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH))); 
		bouton_recharger = new JButton(new ImageIcon(((new ImageIcon("Images/recharger.png")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH))); 
		bouton_lemmingSave = new JButton(new ImageIcon(((new ImageIcon("Images/sauver.jpg")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH))); 
		bouton_suppr = new JButton(new ImageIcon(((new ImageIcon("Images/explosion.png")).getImage()).getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH))); 

		tPioche = new JLabel(""+Carte.cmpPioche);
		tParapluie = new JLabel(""+Carte.cmpParapluie);
		tEscalier = new JLabel(""+Carte.cmpEscalier);
		tCatapulte = new JLabel(""+Carte.cmpCatapulte);
		tEscalade = new JLabel(""+Carte.cmpEscalade);
		tBombe = new JLabel(""+Carte.cmpBombe);
		tStop = new JLabel(""+Carte.cmpStop);
		tFutur2 = new JLabel(""+Carte.cmpFutur2);
		tLemmingSave = new JLabel(""+Carte.lemmingSauf);

		//MISE EN ATTENTE DES BOUTONS
		bouton_creuse.addActionListener(this);
		bouton_parapluie.addActionListener(this);
		bouton_escalier.addActionListener(this);
		bouton_Catapulte.addActionListener(this);
		bouton_escalade.addActionListener(this);
		bouton_escalade.addActionListener(this);
		bouton_bombe.addActionListener(this);
		bouton_stop.addActionListener(this);
		bouton_futur2.addActionListener(this);
		bouton_play.addActionListener(this);
		bouton_pause.addActionListener(this);
		bouton_accelerer.addActionListener(this);
		bouton_recharger.addActionListener(this);
		bouton_suppr.addActionListener(this);
	}

	class BoutonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			puissance = Integer.parseInt(Tpuissance.getText());
			angle = (double) ((Integer.parseInt(Tangle.getText()))*Math.PI/180); //on met en radian
			Carte.obs.add(new Lemming(catapulteX,catapulteY,angle,puissance));
			frame.dispose();
		}
	}

	public void afficherTexteCmp(){
		tPioche.setText("" + Carte.cmpPioche);
		tParapluie.setText("" + Carte.cmpParapluie);
		tEscalier.setText("" + Carte.cmpEscalier);
		tEscalade.setText("" + Carte.cmpEscalade);
		tCatapulte.setText("" + Carte.cmpCatapulte);
		tBombe.setText("" + Carte.cmpBombe);
		tStop.setText("" + Carte.cmpStop);
		tFutur2.setText("" + Carte.cmpFutur2);	
	}


}

