import java.io.*;
import java.util.*;

public class EnsValMeteo extends java.util.ArrayList<ValMeteoJour>{

  private String lieu;
  private String numSemaine;

  public EnsValMeteo(){
  }

  public void charger(String nomF) throws IOException
  		{
  			BufferedReader f = new BufferedReader(new FileReader(nomF)); //memoire temp
  			String r = f.readLine(); //lire la memoire temp
  			this.lieu = r;
  			r = f.readLine();
  			this.numSemaine = r;
  			r = f.readLine();
  			while(r!=null)
  			{
  			  StringTokenizer st = new StringTokenizer(r,"\t"); //divise une phrase en jeton
  				String jour = st.nextToken(); //next jeton
  				float temp = Float.parseFloat(st.nextToken()); //concertit en float en string et passe au prochain jeton
  				float prec = Float.parseFloat(st.nextToken());
  				ValMeteoJour vmj = new ValMeteoJour(jour, temp, prec);
  				this.add(vmj);
  				r = f.readLine();
  			}
  			f.close();
  		}

  

      public void sauver(String nomF) throws IOException {
              BufferedWriter f = new BufferedWriter(new FileWriter(nomF));
              f.write(this.lieu);
              f.newLine();
              f.write(this.numSemaine);
              for (int i = 0; i<this.size() ;i++ ) {
                f.write(this.get(i).getJour() + "\t" + this.get(i).getTemp() + "\t" + this.get(i).getPrec());
                f.newLine();
              }
            f.close();
          }

  public String toString(){
      	  String s = this.lieu+"\n" + this.numSemaine +"\n";
      		Iterator<ValMeteoJour> ite = this.iterator();
      			while(ite.hasNext()){
      				s += ite.next() + "\n";
      			}
      			return s;
      		}
}
