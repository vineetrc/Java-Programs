import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Tester {

	public static void main(String[] args) {
		
		 String workDir = System.getProperty("user.dir");
		 
		 
		 
		JFileChooser chooser = new JFileChooser(workDir);
	    //FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
	   // chooser.setFileFilter(filter);
	    int returnVal = chooser.showOpenDialog(null);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	       System.out.println("You chose to open this file: " +
	            chooser.getSelectedFile().getName());
	       ArrayList<String> fileData = FileIO.readFile( chooser.getSelectedFile().getAbsolutePath());
			System.out.println(fileData);
			
			
			FileIO.writeFile("testfile", fileData);
			
			
			
	    }
	    
	    
		
		
		
		
	}

}
