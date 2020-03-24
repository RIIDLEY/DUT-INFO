import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;

/***
 * Class PanneauCentre qui sera appele dans la class Paint. C'est pour gerer les dessins dans le centre de la fenetre.
 * Le background du centre est mis en blanc.
 * PaintCompenent pour dessiner."FillOval" pour le cercle et "FillRect" pour le carre.
 * GetX et GetY pour récuperer la position de la souris.
 * Si jamais je n'ai pas assez bien commenter mon code , je serai disponible pour vous expliquez ma methode a tout moment.
 * Merci
 * @author saied
 *
 */
public class PanneauCentre extends JPanel{
	//Question 6 
	public PanneauCentre(){
		setBackground(Color.WHITE);//Couleur du centre de la fenetre
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		for (Dessin d : Donnees.dessins) {
			if(d.getFormes() == "cercle"){
				g.setColor(d.getCouleurs());
				g.fillOval(d.getX(), d.getY(), d.getTaille(), d.getTaille());
			}else if (d.getFormes()== "carre"){
				g.setColor(d.getCouleurs());
				g.fillRect(d.getX(), d.getY(), d.getTaille(), d.getTaille());
			}
		}
	}

}
