import java.io.*;
public class TestEnsValMeteo {
  public static void main(String[] args) {

    EnsValMeteo evm = new EnsValMeteo();

    try {
    evm.charger("EnsValMeteo.txt");
    }
    catch(IOException e) {
      System.out.println(e);
    }


  }
}
