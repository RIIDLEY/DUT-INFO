import javax.swing.*;
import java.io.*;

public class FenDeuxBoutons extends JFrame {
  private JButton bRouge = null;
  private JButton bBleu = null;
  public FenDeuxBoutons(String titre,int w, int h) {
    super(titre);
    this.setBounds(400, 400, w,h);
    this.initialise();
    this.initconnections();
    this.setVisible(true);
  }
  private void initialise() {
    this.setLayout(new FlowLayout());
    bRouge=new JButton("Fond rouge");
    bRouge.setForeground(Color.red);
    this.add(bRouge);
    bBleu=new JButton("Fond bleu");
    bBleu.setForeground(Color.blue);
    this.add(bBleu);
  }
  private void initconnections(){
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    BoutonListener list=new BoutonListener(); //une instance
    bRouge.addActionListener(list);
    bBleu.addActionListener(list);
  }
}
