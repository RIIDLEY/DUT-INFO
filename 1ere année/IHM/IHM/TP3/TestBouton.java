import java.io.*;
import java.awt.*;
import javax.swing.*;

public class TestBouton extends JFrame {
  class BoutonOkListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      private JLabel labNbFois; //étiquette pour l'affichage
      private int nb; //compteur
      public TestBouton(String titre,int w, int h) {
        super(titre);
        nb =0;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(400, 400, w,h);
        this.initialise();
        this.setVisible(true);
      }
      private void initialise() {
        JButton boutRouge = new JButton("Clique et tu verras... ");
        boutRouge.setBackground(Color.red);
        labNbFois= new JLabel();
        this.setLayout(new FlowLayout());
        this.add(boutRouge);
        this.add(labNbFois);
        BoutonListener blis = new BoutonListener();
        boutRouge.addActionListener(blis);
      }
    }
  }
