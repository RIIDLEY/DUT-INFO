import java.awt.Toolkit;
import java.awt.Dimension;

public class TestFen {
	public static void main(String[] args) {	
		// Question 1.1: hauteur de l'écran
		Toolkit aTK = Toolkit.getDefaultToolkit();
		Dimension dim = aTK.getScreenSize();
		System.out.println("Largeur: "+dim.width+" hauteur: "+dim.height);
		
		// Question 1.2
		String version = System.getProperty("java.version");
		String username = System.getProperty("user.name");
		String classpath = System.getenv("CLASSPATH");	
		String dir = System.getProperty("user.dir");
		System.out.println("Version: "+version + 
			"\nUtilisateur: "+username+
			"\nVariable d'environnement CLASSPATH: "+classpath+
			"\nDossier actuel: "+dir);
	}
}
