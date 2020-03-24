import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.Dimension;

import javax.swing.JFrame;

// Question 2.3
public class FenSimple23 extends JFrame {
	public FenSimple23 (String title, int x, int y, int w, int h ) {
                super(title); // Titre de la fen
                this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Quelle opération a la sortie?
                this.setBounds(x,y,w,h);
                this.setVisible(true);
        }

	public FenSimple23 (String title, int w, int h) {
		super(title); // Titre de la fen
		this.centreEcran(w, h);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public FenSimple23 (String title, int w, int h, Cursor c) {
		this(title, w, h);
		this.setCursor(c);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void centreEcran(int w, int h) {
		Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = new Dimension (w, h);

		this.setBounds ( (ss.width-frameSize.width) / 2 ,
                  (ss.height-frameSize.height) / 2,
                  frameSize.width, frameSize.height );
	}

	public static void main(String[] args) {
		new FenSimple23("Fenètre 2 avec curseur", 300, 1000, new Cursor(Cursor.HAND_CURSOR));
	}
}
