import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JFrame;

import java.awt.Graphics;

public class FenAfficheCercle extends JFrame {
	public FenAfficheCercle(String titre, int w, int h) {
		super();
		this.initialise();
		this.setSize(w,h);
		this.setVisible(true);
	}
	
	public void initialise() {
		PanelCercle pan = new PanelCercle();
		this.add(pan, BorderLayout.CENTER);
	}
	
	public static void main (String[] args) {
		new FenAfficheCercle("Ma fenètre de dessin",300,200);
	}
	
	public class PanelCercle extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawOval(50,20,100,100);
		}
	}
}
