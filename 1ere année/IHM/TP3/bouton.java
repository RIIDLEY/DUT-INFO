import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class bouton extends FenSimple{
  private JButton b1;
  private JLabel labNbFois;
  JButton boutRouge=new JButton("+1");
  JButton boutRose=new JButton("-1");

  public bouton(String titre, int w, int h){
    super(titre,w,h);
    this.setLayout(new FlowLayout());
    this.initialise();
    this.setVisible(true);
  }

  private void initialise() {

    labNbFois= new JLabel();
     this.setLayout(new FlowLayout());
     this.add(boutRouge);
     this.add(labNbFois);
     this.add(boutRose);
     labNbFois.setOpaque(true);

     BoutonListener blis=new BoutonListener();
     boutRose.addActionListener(blis);
     boutRouge.addActionListener(blis);
  }

  public class BoutonListener implements ActionListener{
    private int nb;

    public void actionPerformed(ActionEvent e){
      if (e.getSource() == boutRouge) {
        nb = nb +1;
        labNbFois.setBackground(Color.pink);
      }
      else{
        nb = nb - 1;
        labNbFois.setBackground(Color.red);
      }
      labNbFois.setText(nb + "clics");
    }


}
}
