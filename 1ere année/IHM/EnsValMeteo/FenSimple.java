import javax.swing.*;
import java.awt.*;

public class FenSimple extends JFrame {
  
  public FenSimple (String titre, int x, int y, int w, int h){
    super(titre);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setBounds(x,y,w,h);
    this.setVisible(true);
  }

  public FenSimple (String titre, int w, int h){
    super(titre);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.centreEcran(w,h);
    //this.setVisible(true);
  }

  public FenSimple (String titre, int w, int h, Cursor c){
    //FenSimple f1 = new FenSimple(titre, w, h);
    //f1.setCursor(c);
    this(titre, w, h);
    this.setCursor(c);
  }

  public void centreEcran(int w, int h){
    Toolkit aTK = Toolkit.getDefaultToolkit();
    Dimension dim = aTK.getScreenSize();
    int a= dim.width/2-w/2;
    int b= dim.height/2-h/2;
    this.setBounds(a,b,w,h);
  }
  public static void main(String[] args) {
    Toolkit aTK = Toolkit.getDefaultToolkit();
    Dimension dim = aTK.getScreenSize();
    int n = 8;
    int hauteur = dim.height/n;
    int largeur = dim.width;
    int positionY=0;
    //int positionX=0;
    FenSimple f = null;
    for (int i=1;i<=n ;i++) {
      f = new FenSimple("Fenetre " + i, 0, positionY, largeur, hauteur);
      positionY += hauteur;
      if (i == 4) {
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
      }
    }


  }
}
