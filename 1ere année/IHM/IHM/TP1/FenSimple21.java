import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.Dimension;

import javax.swing.JFrame;

// Question 2.1
public class FenSimple21 extends JFrame {
	public FenSimple21 (String title, int x, int y, int w, int h ) {
		super(title); // Titre de la fen
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Quelle opération a la sortie?

		this.setBounds(x,y,w,h);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		// On récupère la taille de l'écran par défaut
		Toolkit aTK = Toolkit.getDefaultToolkit();
		Dimension dim = aTK.getScreenSize();
		new FenSimple21 ("Ma premiere fenetre", 0, 0, dim.width, dim.height);
	}
}
