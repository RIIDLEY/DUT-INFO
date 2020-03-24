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

public class FenDiagonaleMenu extends JFrame {
	private PanelDiagonale pan;
	private static final String texte = 

	public FenDiagonaleMenu(String titre, int w, int h) {
		super();
		this.initialise();
		this.setSize(w,h);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void initialise() {
		pan = new PanelDiagonale();
		this.add(pan, BorderLayout.CENTER);
		this.initialiseMenu();
	}
	
	public void initialiseMenu() {
		JMenuBar jmb = new JMenuBar();
		this.setJMenuBar(jmb);
		Z
		JMenu mdef = new JMenu("Couleur");
		jmb.add(mdef);
		
		// Création
		JMenuItem iBleu = new JMenuItem(FenDiagonaleMenu.bleu);
		JMenuItem iRouge = new JMenuItem(FenDiagonaleMenu.rouge);
		
		// Mettre les couleurs des items
		iBleu.setForeground(Color.blue);
		iRouge.setForeground(Color.red);
		
		// Set les couleurs
		mdef.add(iBleu);
		mdef.add(iRouge);		
		
		// On registre les MenuItem.
		iBleu.addActionListener(new CouleurListener());
		iRouge.addActionListener(new CouleurListener());
	}
	
	public static void main (String[] args) {
		new FenDiagonaleMenu("Ma fenètre de dessin",300,200);
	}
	
	public class CouleurListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// Commande de l'action performée.
			JMenuItem j = (JMenuItem) e.getSource();
			pan.setColor(j.getForeground());
				
			pan.repaint();
		}
	}
}
