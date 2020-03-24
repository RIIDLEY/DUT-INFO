package TP4.exemplesgraphisme;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JFrame;

import java.awt.Graphics;

public class FenAfficheDiagonale extends JFrame {
	public FenAfficheDiagonale(String titre, int w, int h) {
		super();
		this.initialise();
		this.setSize(w,h);
		this.setVisible(true);
	}
	
	public void initialise() {
		PanelDiagonale pan = new PanelDiagonale();
		this.add(pan, BorderLayout.CENTER);
	}
	
	public static void main (String[] args) {
		new FenAfficheDiagonale("Ma fenètre de dessin",300,200);
	}
	
	public class PanelDiagonale extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			int larg = this.getWidth();
			int haut = this.getHeight();
			g.drawLine(0, 0, larg, haut);
		}
	}
}
