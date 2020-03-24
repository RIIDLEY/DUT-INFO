  import java.awt.Dimension;
  import java.awt.Toolkit;


  public class TestFenetre {
    public static void main(String[] args) {
      //1.1
      Toolkit aTK = Toolkit.getDefaultToolkit();
      Dimension dim = aTK.getScreenSize();
      System.out.prinln("largeur" + dim.width + "hauteur" + dim.heigth,);

      //1.2
      String dir = System.getProperty("user.dir");
      String classpath = System.getenv("CLASSPATH");
      String username = System.getProperty("user.name");
      String version = System.getProperty("java.version");

    }
  }
