import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelDiagonale extends JPanel {
		private Color coul;
		public PanelDiagonale() {
			coul=Color.black;
		}
		
		public void setColor(Color c) {
			coul=c;
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(coul);
			int larg = this.getWidth();
			int haut = this.getHeight();
			g.drawLine(0, 0, larg, haut);
		}
	}
