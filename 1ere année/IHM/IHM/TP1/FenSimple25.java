import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.JFrame;

// Question 2.4
public class FenSimple25 extends JFrame {
	public FenSimple25 (String title, int x, int y, int w, int h ) {
                super(title); // Titre de la fen
                this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Quelle opération a la sortie?
                this.setBounds(x,y,w,h);
                this.setVisible(true);
        }

	public FenSimple25 (String title, int w, int h) {
		super(title); // Titre de la fen
		this.centreEcran(w, h);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public FenSimple25 (String title, int w, int h, Cursor c) {
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
		Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
		int ht = ss.height/3;
		int wt = ss.width;
		for (int i=1;i<=3;i++) {
			new FenSimple25("Fenètre "+i, 0, (i-1)*ht, wt, ht);
		}
	}
}
