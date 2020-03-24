import java.io.*;
import java.util.*;



public class Test{
  public static void main(String[] args) {
    VueStationMeteo a = new VueStationMeteo("test",600,600);
    EnsValMeteo e = new EnsValMeteo();
    try{
      e.charger("nomF.txt");
      e.sauver("nomF1.txt");
    }
    catch (IOException o) {
      o.printStackTrace();
    }
  }

}
