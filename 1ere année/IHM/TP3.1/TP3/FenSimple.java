import javax.swing.*;
import java.awt.*;

public class FenSimple extends JFrame {

  public FenSimple (String titre, int x, int y, int w, int h){
    super(titre);
    //Toolkit aTK = Toolkit.getDefaultToolkit();
    //Dimension dim = aTK.getScreenSize();
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setBounds(x,y,w,h);
    this.setVisible(true);
  }

  public FenSimple (String titre, int w, int h){
    super(titre);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.centreEcran(w,h);
    this.setVisible(true);
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
}
