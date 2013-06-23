package lemmings;
 
import java.io.*;
import java.awt.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
 

public class FileChooser extends JPanel  {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    JFileChooser fc;
 
    public FileChooser() throws IOException {
        super(new BorderLayout());
 
       
        FileNameExtensionFilter fnef = new FileNameExtensionFilter(null, "xml");
        //Create a file chooser
        fc = new JFileChooser();
        fc.addChoosableFileFilter(fnef);
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
  
        int returnVal = fc.showOpenDialog(FileChooser.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            
            Jeu.playWave.stop();
						
			
			String[] tab,entree,sortie,catapulte;
			int nbLem,aSauve;
			
			// On lit les informations du fichier texte
			try{
				InputStream ips=new FileInputStream(file.getAbsolutePath().substring(0, file.getAbsolutePath().length()-4)+".txt"); 
				InputStreamReader ipsr=new InputStreamReader(ips);
				BufferedReader br=new BufferedReader(ipsr);
				String ligne;
				
				nbLem = Integer.valueOf(br.readLine());
				aSauve = Integer.valueOf(br.readLine());
				entree = br.readLine().split(" ");
				sortie = br.readLine().split(" ");
				catapulte = br.readLine().split(" ");
				tab = br.readLine().split(" ");
				
				Carte.lemmingASauver=aSauve;
				Carte.initCmp(Integer.valueOf(tab[0]), Integer.valueOf(tab[1]), Integer.valueOf(tab[2]), 
						Integer.valueOf(tab[3]), Integer.valueOf(tab[4]), Integer.valueOf(tab[5]), Integer.valueOf(tab[6]), Integer.valueOf(tab[7]));
				
				Jeu.initialiserJeu(file.getAbsolutePath(), 
						file.getAbsolutePath().substring(0, file.getAbsolutePath().length()-4)+"bg.png", 
						"", 
						"Automates/automate.xml", 
						new Point(Integer.valueOf(entree[0]),Integer.valueOf(entree[1])),
						new Point(Integer.valueOf(sortie[0]),Integer.valueOf(sortie[1])),
						new Point(Integer.valueOf(catapulte[0]),Integer.valueOf(catapulte[1])),
						nbLem);
				
				br.close(); 
			}		
			catch (Exception e){
				System.out.println(e.toString());
			}
			
			
			
			
        }
    }
}