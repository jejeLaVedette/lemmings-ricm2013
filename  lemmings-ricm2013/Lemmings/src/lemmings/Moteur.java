package lemmings;

import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Moteur implements Constantes {

	private static int relief=0;

	public static void miseAJourObservables() throws IOException
	{

		for(int i=0;i<Carte.obs.size();i++) {

			// Analyse de l'element courant

			// Si on a un Lemming
			Lemming  lem = (Lemming) Carte.obs.get(i);

			int x = lem.getX();
			int y = lem.getY();

			// S'il est sur le point de sortie, +- une certaine tolérance
			if(Math.abs(x-Carte.sortie.x)<(toleranceSortie/2) && Math.abs(y-Carte.sortie.y)<toleranceSortie) {
				Carte.lemmingSauf++;
				Carte.obs.remove(i);
			}

			// S'il est mort, et ben... il est mort !
			if(lem.getY()==Carte.HAUTEUR_CARTE-1) {
				Carte.obs.remove(i);
				continue;
			}

			// Analyse de l'environnement du lemming courant
			String cond;

			if (Carte.map[x][y-1-coeff*3/4].isSol() && Carte.map[x-1][y-1-coeff*3/4].isSol() && Carte.map[x+1][y-1-coeff*3/4].isSol() )
			{	cond = "sol"; }
					
				
			// Présence d'un vide
			
			else 
				if( ( lem.getDirection()==gauche && Carte.map[x][y+1].isAir() ) ||
					( lem.getDirection()==droite && Carte.map[x][y+1].isAir() )	) 
				cond = "vide";

			// Présence d'un mur
			else if( (x==0 && lem.getDirection()==gauche) || 
					(x==Carte.LARGEUR_CARTE-1 && lem.getDirection()==1) ||
					(lem.getDirection()==gauche && Carte.map[x-1][y].isSol() && Carte.map[x-1][y-1].isSol() && Carte.map[x-1][y-2].isSol())||
					(lem.getDirection()==droite && Carte.map[x+1][y].isSol() && Carte.map[x+1][y-1].isSol() && Carte.map[x+1][y-2].isSol())
					) 
			{	cond = "mur"; }

			else 
			{	cond = "sol"; }




			// Calcul du relief
			if(cond=="sol") {
				relief = 0;
				if(lem.getDirection()==gauche) {

					if(Carte.map[x-1][y].isSol()) {
						relief--;
						if(Carte.map[x-1][y-1].isSol()) {
							relief--;
							if(Carte.map[x-1][y-2].isSol()) relief--;
						}
					}					

					if(Carte.map[x-1][y+1].isAir()) {
						relief++;
						if(Carte.map[x-1][y+2].isAir()) {
							relief++;
							//if(Carte.map[x-1][y+2].type>=typeAirInf && Carte.map[x-1][y+2].type<=typeAirSup) relief++;
						}
					}
				}
				else {
					if(Carte.map[x+1][y].isSol()) {
						relief--;
						if(Carte.map[x+1][y-1].isSol()) {
							relief--;
							if(Carte.map[x+1][y-2].isSol()) relief--;
						}
					}

					if(Carte.map[x+1][y+1].isAir()) {
						relief++;
						if(Carte.map[x+1][y+2].isAir()) {
							relief++;
							//if(Carte.map[x+1][y+2].type>=typeAirInf && Carte.map[x+1][y+2].type<=typeAirSup) relief++;
						}
					}


				}
			}

			// S'il est mort, et ben... il est mort !
			if(lem.getEtat()==etatMort && (cond.equals("sol")||cond.equals("mur"))) {
				Carte.obs.remove(i);
				continue;
			}
			if(lem.getEtat()==etatMort && cond.equals("vide")) {
				tomber(lem);
				continue;
			}

			//System.out.println("etat:"+lem.getEtat()+" type:"+lem.getType()+" x: "+lem.getX()+ " y:"+lem.getY()+" relief: "+relief + " cond:"+cond);
			
			// Recherche de l'automate correspondant
			Automate aut = null;
			for(int m=0;m<Jeu.listeAutomates.size();m++) {
				if(Jeu.listeAutomates.get(m).identifiant == lem.type) {
					aut = Jeu.listeAutomates.get(m); break;
				}
			}

			if(aut == null) {
				System.out.println("Modèle d'automate introuvable !");
				System.exit(1);
			}

			// Recherche de la transition dans l'automate
			int k=0;
			while(k<aut.listeTransitions.size()) {
				if( aut.listeTransitions.get(k).getEtatInitial()==lem.getEtat() && 
						(aut.listeTransitions.get(k).getCondition().equals(cond) || aut.listeTransitions.get(k).getCondition().equals("any"))) break;

				k++;
			}

			if(k==aut.listeTransitions.size()) {
				System.out.println("Automate n°"+ aut.identifiant +" non-déterministe !");
				System.exit(1);
			}

			// On applique les actions associées
			if (aut.listeTransitions.get(k).getActions() != null)
			{
				for(int l=0;l<aut.listeTransitions.get(k).getActions().size();l++) {
					appliquerAction(aut.listeTransitions.get(k).getActions().get(l),lem);
				}
			}

			// On met à jour le champs condPrecedente et eventuellement la micro-action
			if(lem.getCondPrecedente()!=cond)
				lem.setSousAction(0);
			lem.setCondPrecedente(cond);
			// On change d'etat, sauf si on n'a pas fini les micro-actions
			if(lem.getSousAction()==0)
				lem.setEtat(aut.listeTransitions.get(k).getEtatFinal());



		} // Fin for(i)
	}

	private static void appliquerAction(String s, Lemming l) throws IOException {

		if(s.equals("marcher"))
			marcher(l);
		else if(s.equals("retourner"))
			retourner(l);
		else if(s.equals("tomber"))
			tomber(l);
		else if(s.equals("bloquer"))
			bloquer(l);
		else if(s.equals("tomberParapluie"))
			tomberParapluie(l);
		else if(s.equals("creuser"))
			creuser(l);
		else if(s.equals("voler"))
			voler(l);
		else if(s.equals("rebondirsol"))
			rebondirsol(l);
		else if(s.equals("rebondirmur"))
			rebondirmur(l);
		else if(s.equals("grimper"))
			grimper(l);
		else if(s.equals("construireEscalier"))
			construireEscalier(l);
		else if(s.equals("initTrajectoire"))
			initTrajectoire(l);
		else if(s.equals("initLemmingBase"))
			initLemmingBase(l);
		else {
			System.out.println("Action invalide !");
			System.exit(1);
		}
	}

	private static void marcher(Lemming l) {
		if(l.getDirection()==gauche) {
			l.image = "Images/lemmingBaseGauche2.png";
			l.setX(l.getX()-1);
			l.setY(l.getY()+relief);
		}			
		else if(l.getDirection()==droite) {
			l.setX(l.getX()+1);
			l.setY(l.getY()+relief);
			l.image = "Images/lemmingBaseDroite2.png";
		}
	}

	private static void retourner(Lemming l) {

		if(l.getDirection()==gauche) {
			l.setDirection(1);
			l.image = "Images/lemmingBaseGauche2.png";
		}
		else if(l.getDirection()==droite) {
			l.setDirection(0);
			l.image = "Images/lemmingBaseDroite2.png";
		}
	}
	

	private static void tomber(Lemming l) {

		if(l.getSousAction()>hauteurLetale) {
			l.setEtat(etatMort);
		}
		else
			l.setSousAction(l.getSousAction()+1);

		l.setY(l.getY()+1);		
		l.image = "Images/tombe2.png";

	}

	private static void bloquer(Lemming l) {

		l.image = "Images/lemmingStop2.png";

		Carte.map[l.getX()][l.getY()].type = typeSolInvisible;
		Carte.map[l.getX()][l.getY()-1].type = typeSolInvisible;
		Carte.map[l.getX()][l.getY()-2].type = typeSolInvisible;
		Carte.map[l.getX()][l.getY()-3].type = typeSolInvisible;
	}

	private static void tomberParapluie(Lemming l) {
		l.setY(l.getY()+1);
		l.image = "Images/parapluie2.png";
	}

	private static void creuser(Lemming l) throws IOException {

		if(l.getSousAction()%delaiSousAction==0) {
			int x,y;
			y = l.getY();
			x = l.getX();
			BufferedImage arrierePlan=ImageIO.read(new File(Carte.background));
			for(int i=0;i<(coeff/2);i++) {
				Carte.map[x+i][y] = new Air(new Color(arrierePlan.getRGB(x+i,y)));
				Carte.map[x-i][y] = new Air(new Color(arrierePlan.getRGB(x-i,y)));
			}

			l.setY(y+1);
		}
		l.setSousAction((l.getSousAction()+1)%(profondeurCreuser*delaiSousAction));
	}

	private static void initTrajectoire(Lemming l) {
		trajectoireparaphysique t=new trajectoireparaphysique(l.getX(),l.getY(),l.puissance,l.angle,1);
		l.setTrajpara(t);
	}

	private static void voler(Lemming l) {
		trajectoireparaphysique t = l.getTrajH();
		//double x=t.calculx(l.time);
		//double y=t.calculy(l.time);
		Point traj=t.trajectoire(l.time);
		double x=traj.getX();
		double y=traj.getY();
		//fin modif perso pour test
		Point pReel = Moteur.collisionTrajectoire(new Point(l.getX(),l.getY()), new Point((int)t.calculx(l.time),(int)t.calculy(l.time)));

		if(hasColision(x,y)){
		l.setX(pReel.x);
		l.setY(pReel.y);
		}
		else{
		l.setX((int)x);
		l.setY((int)y);
		}

		l.setTime();
		Carte.map[l.getX()][l.getY()].couleur = new Color(255,0,0);

	}

	private static void rebondirsol(Lemming l) {

		
		System.out.println("REBONDIR SO!!L");
		
		trajectoireparaphysique t= l.getTrajH() ;
		//double x  = t.calculx(l.time);
		//double y = t.calculy(l.time);
		Point traj=t.trajectoire(l.time);
		Point trajprec=t.trajectoire(l.time-2*deltat);
		double x=traj.getX();
		double y=traj.getY();
		double xp=trajprec.getX();
		double yp=trajprec.getY();
		//l.setXp(t.calculx(l.time -2*deltat));
		//l.setYp(t.calculy(l.time -2*deltat));
		//l.setX((int)t.calculx(l.time -2*deltat));
		//l.setY((int)t.calculy(l.time -2*deltat));
		l.setXp(xp);
		l.setYp(yp);
		l.setX((int)xp);
		l.setY((int)yp);
		t.calculcolision(x, y, l.getXp() , l.getYp(),l.getX(),l.getY() , l.getElasticite(),0.5, false);
         
		if (Math.sqrt(t.getVx()*t.getVx() +t.getVy()*t.getVy()) > 1){
 			l.setTrajpara(t);
 			System.out.println("x:"+l.getX()+" y"+l.getY()); 
 			Carte.map[l.getX()][l.getY()].couleur = new Color(0,0,255);
 			l.resetTime();
 			voler(l);
 		}
         
		
	}
private static void rebondirmur(Lemming l) {

		
		System.out.println("REBONDIR MUR!!");
		trajectoireparaphysique t= l.getTrajH() ;
		//double x  = t.calculx(l.time);
		//double y = t.calculy(l.time);
		//l.setXp(t.calculx(l.time -2*deltat));
		//l.setYp(t.calculy(l.time -2*deltat));
		//l.setX((int)t.calculx(l.time -2*deltat));
		//l.setY((int)t.calculy(l.time -2*deltat));
		Point traj=t.trajectoire(l.time);
		Point trajprec=t.trajectoire(l.time-2*deltat);
		double x=traj.getX();
		double y=traj.getY();
		double xp=trajprec.getX();
		double yp=trajprec.getY();
		l.setXp(xp);
		l.setYp(yp);
		l.setX((int)xp);
		l.setY((int)yp);
		t.calculcolision(x, y, l.getXp() , l.getYp(),l.getX(),l.getY() , l.getElasticite(),0.5, true);
        
		retourner(l);
		if (Math.sqrt(t.getVx()*t.getVx() +t.getVy()*t.getVy()) > 10){
 			l.setTrajpara(t);
 			System.out.println("x:"+l.getX()+" y"+l.getY()); 
 			Carte.map[l.getX()][l.getY()].couleur = new Color(0,0,255);
 			l.resetTime();
 			voler(l);
 		}
         
		
	}
	
		

	private static void grimper(Lemming l) {
		System.out.println("TOTO");
		l.setY(l.getY()-1);
	}

	private static void initLemmingBase(Lemming l) {
		l.setType(lemmingBase);
		l.setEtat(etatInitial);
	}

	private static void construire(Lemming l) {
		int x,y;
		y = l.getY();
		x = l.getX();
		if(l.direction==droite)
			for(int i=0;i<(coeff/2);i++) {
				if(Carte.map[x+i][y].isAir())
					Carte.map[x+i][y] = new Sol(new Color(150,0,0));
			}
		else
			for(int i=0;i<(coeff/2);i++) {
				Carte.map[x-i][y] = new Sol(new Color(150,0,0));
			}	

	}

	private static void construireEscalier(Lemming l) {
		if(l.getSousAction()%delaiSousAction==0) 
			construire(l);
		if(l.getSousAction()%delaiSousAction==1)
			marcher(l);		
		l.setSousAction((l.getSousAction()+1)%(nbMarche*delaiSousAction));
	}

	public static Point collisionTrajectoire (Point pCourant, Point pDest) {
		int coeffDirecteur;
		int yCourant =(int) pCourant.getY();
		Point rep= new Point(0,0);
		int i=0;

		if(((int)pDest.getX() - pCourant.getX())!=0){
			coeffDirecteur = (int)((pDest.getY() - pCourant.getY())/(pDest.getX() - pCourant.getX()));
			int constante = pCourant.y - coeffDirecteur * pCourant.x;
			i = (int)pCourant.getX();
			if ((int)pCourant.getX() < pDest.getX()) {
				while (i< pDest.getX() ) {
					yCourant = coeffDirecteur * i + constante;
					if (Carte.map[i][yCourant].isSol()){
						break; }
					i++;
				}
				rep.x=i;
				rep.y=coeffDirecteur * i + constante;
			}
			else {
				while (i> pDest.x) {
					yCourant = coeffDirecteur * i + constante;
					if (Carte.map[i][yCourant].isSol()){

						break;
					}
					i--;
				}
				rep.x=i;
				rep.y=coeffDirecteur * i + constante;
			}
		}
		else{
			i=(int)pCourant.getY();
			if ((int)pCourant.getY() < pDest.getY()){
				while(i<pDest.getY()){
					if (Carte.map[(int)pCourant.getX()][i].isSol()){
						break;
					}
					i++;
				}
				rep.x=(int)pCourant.getX();
				rep.y=i;
			}
			else{
				while(i>pDest.getY()){
					if (Carte.map[(int)pCourant.getX()][i].isSol()){
						break;
					}
					i--;
				}
				rep.x=(int)pCourant.getX();
				rep.y=i;
			}

		}

		return rep;
	}


	public static boolean hasColision(double x,double y){
		if (Carte.map[(int)x][(int)y].isSol()){
		return true;
		}
		else
		return false;

		}
}