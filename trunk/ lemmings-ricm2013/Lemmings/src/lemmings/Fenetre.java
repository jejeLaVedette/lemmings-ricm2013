package lemmings;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Fenetre extends JFrame implements MouseListener, ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Panneau pan = new Panneau();
	private JPanel panel = new JPanel();
	private JButton bouton1 = new Bouton("Creuse");
	private JButton bouton2 = new Bouton("Parapluie");
	private JButton bouton3 = new Bouton("Pop lemmings");
	private JButton bouton4 = new Bouton("Super Saiyen");
	private int knowButton;

	//private JPanel container = new JPanel();


	public static int tailleFX = 1000;
	public static int tailleFY = 500;
	public static int restey = tailleFY%Carte.HAUTEUR_CARTE;
	public static int restex = tailleFX%Carte.LARGEUR_CARTE;

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

		//Nos boutons sont en attente de cliques
		bouton1.addActionListener(this);
		bouton2.addActionListener(this);
		bouton3.addActionListener(this);
		bouton4.addActionListener(this);

		//on met les boutons dans la zone sud
		getContentPane().add(panel, BorderLayout.SOUTH); 		

		panel.add(bouton1);

		panel.add(bouton2);

		panel.add(bouton3);

		panel.add(bouton4);

		pan.addMouseListener(this);
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

	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == bouton1){
			knowButton = 1;
		}

		if(arg0.getSource() == bouton2){
			knowButton = 2;
		}

		if(arg0.getSource() == bouton3){
			knowButton=3;
			this.addMouseListener(this);
		}

		if(arg0.getSource() == bouton4){
			knowButton = 4;
			this.addMouseListener(this);
		}
	}



	//Méthode appelée lors du clic de souris
	public void mouseClicked(MouseEvent event) { 
		if(knowButton==3){
			//on récupère les coordonnée X de la souris	
			int newCx = (event.getX()*Carte.LARGEUR_CARTE)/(tailleFX-restex);
			//on réccupère les coordonnée Y de la souris
			int newCy = ((event.getY()*(Carte.HAUTEUR_CARTE))/(tailleFY-restey));
			Carte.obs.add( new Lemming(newCx , newCy));
		}
		
		if(knowButton==4){
			
			//on récupère les coordonnée X de la souris	
			int newCx = (event.getX()*Carte.LARGEUR_CARTE)/(tailleFX-restex);
			//on réccupère les coordonnée Y de la souris
			int newCy = ((event.getY()*(Carte.HAUTEUR_CARTE))/(tailleFY-restey));
			
			
			Observable lem;
			System.out.println("tentative de suppr lemmings#######1");
			for (int i =0;i<Carte.obs.size();i++){
				lem = Carte.obs.get(i);
				System.out.println("tentative de suppr lemmings#######1.2");
				if((newCy<lem.getY() && newCy>lem.getY() - Panneau.coeff) && ((newCx<lem.getX()+3/2*Panneau.coeff && newCx > lem.getX()-3/2*Panneau.coeff))){
						System.out.println("tentative de suppr lemmings#######2");
						Carte.obs.remove(i);
					}
				}
				
			}
			System.out.println("tentative de suppr lemmings#######3");

		}
	
	

	//Méthode appelée lors du survol de; la souris
	public void mouseEntered(MouseEvent event) { 

	}

	//Méthode appelée lorsque la souris sort de la zone du bouton
	public void mouseExited(MouseEvent event) { 


	}

	//Méthode appelée lorsque l'on presse le bouton gauche de la souris
	public void mousePressed(MouseEvent event) {


	}

	//Méthode appelée lorsque l'on relâche le clic de souris
	public void mouseReleased(MouseEvent event) { 


	}



}