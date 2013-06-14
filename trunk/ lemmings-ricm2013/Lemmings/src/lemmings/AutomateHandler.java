package lemmings;

import org.xml.sax.*;
import org.xml.sax.helpers.*;

import javax.swing.plaf.basic.BasicSliderUI.ActionScroller;
import javax.xml.parsers.*; 
import java.io.*; 
import java.util.*; 

public class AutomateHandler extends DefaultHandler{
   //resultats de notre parsing
   private Automate automate;
   private List<Automate> listeAutomate;
   private ArrayList<Transition> transit;
   private Transition transition;
   //flags nous indiquant la position du parseur
   private boolean inOpen, inAutomate, inTransition, inCondition, inAction;
   private List<String> mouvements;
   // simple constructeur
   public AutomateHandler(){
      super();	
      
   }
   //detection d'ouverture de balise
   public void startElement(String uri, String localName, String qName, Attributes attributes)
                  throws SAXException{
      System.out.println(uri+" "+localName+" "+qName);
      if(qName.equals("open")){
    	  listeAutomate = new LinkedList<Automate>();
    	  inOpen=true;
      }else if(qName.equals("automate")){
         automate = new Automate();
         transit = new ArrayList<Transition>();
         try{
          	String nom = attributes.getValue("nom");
             automate.setNom(nom);
         }catch(Exception e){
          	//erreur, le nom n'est pas defini
             throw new SAXException(e);
             }
         inAutomate = true;
      }else if(qName.equals("transition")){
         transition = new Transition();
         mouvements = new ArrayList<String>();
         try{
         	int etat = Integer.parseInt(attributes.getValue("etat"));
            transition.setEtatInitial(etat);
         }catch(Exception e){
         	//erreur, le contenu de l'etat n'est pas un entier
            throw new SAXException(e);
         }
         try{
          	int etatsuivant = Integer.parseInt(attributes.getValue("etatsuivant"));
             transition.setEtatFinal(etatsuivant);
          }catch(Exception e){
          	//erreur, le contenu de l'etat n'est pas un entier
             throw new SAXException(e);
          }
         inTransition = true;	
      }else if(qName.equals("condition")){
         inCondition = true;	
      }else if(qName.equals("action")){
         inAction = true;
      }else{
         //erreur, on peut lever une exception
         throw new SAXException("Balise "+qName+" inconnue.");	
      }
   }
   //detection fin de balise
   public void endElement(String uri, String localName, String qName)
                throws SAXException{
	   if(qName.equals("open")){
		   inOpen=false;
	   }else if(qName.equals("automate")){
    	  automate.setListeTransitions(transit);
    	  listeAutomate.add(automate);
       	 automate = null;
         inAutomate = false;
	   }else if(qName.equals("transition")){
      	 transit.add(transition);
      	 transition = null;
         inTransition = false;	
	   }else if(qName.equals("condition")){
         inCondition = false;	
	   }else if(qName.equals("action")){
         inAction = false;		
	   }else{
         //erreur, on peut lever une exception
         throw new SAXException("Balise "+qName+" inconnue.");	
	   }          	
   }
   //detection de caracteres
   public void characters(char[] ch, int start, int length)
                throws SAXException{
      String lecture = new String(ch,start,length);
      if(inCondition){
         transition.setCondition(lecture);	
      }else if(inAction){        
    	  mouvements.add(lecture);
    	  transition.setActions(mouvements);
      }          	
   }
   //debut du parsing
   public void startDocument() throws SAXException {
   	  System.out.println("Debut du parsing");
   }
   //fin du parsing
   public void endDocument() throws SAXException {
   	  System.out.println("Fin du parsing");
   	  System.out.println("Resultats du parsing");
   	  for(Automate a : listeAutomate){
   	     System.out.println(a);
   	  }
   }
   
   // test
   public static void main(String[] args){
      try{
         // creation d'une fabrique de parseurs SAX
         SAXParserFactory fabrique = SAXParserFactory.newInstance();
			
         // creation d'un parseur SAX
         SAXParser parseur = fabrique.newSAXParser();
			
         // lecture d'un fichier XML avec un DefaultHandler
         File fichier = new File("./automate2.xml");
         DefaultHandler gestionnaire = new AutomateHandler();
         parseur.parse(fichier, gestionnaire);
		
      }catch(ParserConfigurationException pce){
         System.out.println("Erreur de configuration du parseur");
         System.out.println("Lors de l'appel a SAXParser.newSAXParser()");
      }catch(SAXException se){
         System.out.println("Erreur de parsing");
         System.out.println("Lors de l'appel a parse()");
         se.printStackTrace();
      }catch(IOException ioe){
         System.out.println("Erreur d'entree/sortie");
         System.out.println("Lors de l'appel a parse()");
      }
   }	
}