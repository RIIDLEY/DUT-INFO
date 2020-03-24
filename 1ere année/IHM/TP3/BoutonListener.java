import java.awt.event.*;


public class BoutonListener implements ActionListener{

    public void actionPerformed(ActionEvent e){
      int nb;
      nb = nb + 1;
      labNbFois.setText(nb + "clics");
    }

}
