package lemmings;
 
import java.io.*;
import java.awt.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
 

public class AutomatesChooser extends JPanel  {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    JFileChooser fc;
 
    public AutomatesChooser() throws IOException {
        super(new BorderLayout());
 
       
        FileNameExtensionFilter fnef = new FileNameExtensionFilter(null, "xml");
        //Create a file chooser
        fc = new JFileChooser();
        fc.addChoosableFileFilter(fnef);
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        int returnVal = fc.showOpenDialog(AutomatesChooser.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
        	
        	File file = fc.getSelectedFile();
            System.out.println("le fichier automate demandé est : "+file.getAbsolutePath());
            
        }
    }
}