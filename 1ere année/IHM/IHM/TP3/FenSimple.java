// Exercice 1 :
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Cursor;



public class FenSimple extends JFrame{
  public  FenSimple(String titre, int x , int y,int w , int h ){
    super(titre);
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setBounds(x,y,w,h);
    this.setVisible(true);
  }

  public void CentreEcran(int w , int h ){
    int x;
    int y;
    Toolkit aTK = Toolkit.getDefaultToolkit();
    Dimension dim = aTK.getScreenSize();
    x = (int)((dim.getWidth()-w)/2);
    y = (int)((dim.getHeight()-h)/2);
    this.setBounds(x,y,w,h);
  }
/*
  public static void main (String  [] args){
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    int a = dim.height/n;
    for (int i =1 ;  i<=3 ; i++){
    new FenSimple("fenetre"+i,0,a*i,dim.width,a);
}
*/


}
