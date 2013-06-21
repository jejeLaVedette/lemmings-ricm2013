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
			Carte.lemmingASauver=10;
			Carte.initCmp(10, 10, 10, 10, 10, 10, 10, 10);
			
			Jeu.initialiserJeu(file.getAbsolutePath(), 
					file.getAbsolutePath().substring(0, file.getAbsolutePath().length()-4)+"bg.png", 
					"", 
					"Automates/automate.xml", 
					new Point(60,55), 
					new Point(330,125),
					new Point(0,0),
					20);
        }
    }
}