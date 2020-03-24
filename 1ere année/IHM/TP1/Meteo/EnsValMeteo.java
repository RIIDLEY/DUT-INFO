import java.io.*;
import java.util.*;

public class EnsValMeteo extends java.util.ArrayList<ValMeteoJour>{

  private String lieu;
  private String numSemaine;

  public EnsValMeteo(){
  }

  public void charger(String nomF){
    BufferedReader entree;

    try{
    entree = new BufferedReader(new FileReader(nomF));

    String ligne = entree.readLine();
      while(ligne!=null) {
        if(!(ligne.trim().startsWith("//")))
          System.out.println(ligne);
          ligne=entree.readLine();

  }
}
    catch (IOException e) {
      System.out.println(e);}
  }
}
