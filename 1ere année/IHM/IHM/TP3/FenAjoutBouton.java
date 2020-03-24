import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class FenAjoutBouton extends JFrame {

  public FenAjoutBouton(String titre, int w, int h) {
    super(titre);
    this.initialise();
    this.setSize(w,h);
    this.setVisible(true);
  }

  public void initialise() {
    JButton butOk = new JButton("ok");
    this.add(butOk);
  }
  
  public static void main(String[] args) {
    new FenAjoutBouton("Ajout d'un bouton ", 200,100);
  }
}
