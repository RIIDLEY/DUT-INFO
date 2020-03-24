import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
 
import javax.swing.JPanel;
 
/*
 * La pane PanelImage sert a afficher une image. On l'affiche sur toute la pane.
 */
 
@SuppressWarnings("serial")
class PanelImage extends JPanel	{
	private Image image;
 
	public PanelImage(String nom)	{
		image=Toolkit.getDefaultToolkit().getImage(nom); 
	}
 
	public void paintComponent(Graphics g) {
		super. paintComponent(g);
		g.drawImage(image, 0, 0, this);
 
	} 
}
