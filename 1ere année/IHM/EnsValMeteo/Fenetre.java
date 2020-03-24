import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class Fenetre extends JFrame {
  private JTabbedPane onglet;

  public Fenetre(){
    this.setLocationRelativeTo(null);
    this.setTitle("Gérer vos conteneurs");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(400, 200);

    //Création de plusieurs Panneau
    float[] a = {52f,12f,13f,25f,45f,7f,32f};
    float[] b = {965f,152f,632f,452f,145f,265f,421f};
    PanelGraphique pg = new PanelGraphique(a,b);
    PanelGraphique pg2 = new PanelGraphique(a,b);
    PanelGraphique pg3 = new PanelGraphique(a,b);
    //Création de notre conteneur d'onglets
    onglet = new JTabbedPane();
    int i = 0;
    //for(Panneau pan : tPan){
      //Méthode d'ajout d'onglet
      onglet.add("Onglet "+(++i), pg);
      onglet.add("Onglet "+(++i), pg2);
      onglet.add("Onglet "+(++i), pg3);
      //Vous pouvez aussi utiliser la méthode addTab
      //onglet.addTab("Onglet n° "+(++i), pan);

    //}
    //On passe ensuite les onglets au content pane
    this.getContentPane().add(onglet);
    this.setVisible(true);
  }

  public static void main(String[] args){
    Fenetre fen = new Fenetre();
  }
}
