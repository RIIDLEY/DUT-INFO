import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JPanel;

/***
 * C'est pour gerer le sud de la fenetre. Ici c'est pour le logo en bas a gauche de la fenetre.
 * Pour insere une image on utilise paintComponent on utilise une variable de type Image.
 * Assez explicite comme code rien a commenter. Si jamais je n'ai pas assez bien commenter mon code , je serai disponible pour vous expliquez ma methode a tout moment.
 * Merci
 * @author saied
 *
 */
public class PanneauSud extends JPanel{
	//Question 5 
	private Image image;
	
	public PanneauSud(){
		image = Toolkit.getDefaultToolkit().getImage("logoVilletaneuse.png");
		image = image.getScaledInstance(80, 40, Image.SCALE_DEFAULT);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		g.drawImage(image, 0, 0, this);
	}
		
	
}
