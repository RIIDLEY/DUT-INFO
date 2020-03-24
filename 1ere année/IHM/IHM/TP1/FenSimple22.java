import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.Dimension;

import javax.swing.JFrame;

// Question 2.2
public class FenSimple22 extends JFrame {
	public FenSimple22 (String title, int x, int y, int w, int h ) {
                super(title); // Titre de la fen
                this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Quelle opération a la sortie?
                this.setBounds(x,y,w,h);
                this.setVisible(true);
        }

	public FenSimple22 (String title, int w, int h) {
		super(title); // Titre de la fen
		this.centreEcran(w, h);
		this.setVisible(true);
	}

	public void centreEcran(int w, int h) {
		Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = new Dimension (w, h);
	
		this.setBounds ( (ss.width-frameSize.width) / 2 , 
                  (ss.height-frameSize.height) / 2,
                  frameSize.width, frameSize.height );	
	}
	
	public static void main(String[] args){
		new FenSimple22("Fenètre 2 avec curseur", 300, 1000);
	}
}
