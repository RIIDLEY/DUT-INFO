import java.io.*;
import java.util.*;

public class EnsValMeteo extends java.util.ArrayList<ValMeteoJour>{

  private String lieu;
  private String numSemaine;

  public EnsValMeteo(){
  }

  public void charger(String nomFichier) throws IOException {
			BufferedReader f = new BufferedReader(new FileReader(nomFichier));
			String r = f.readLine();
			this.lieu = r;
			r = f.readLine();
			this.numSemaine = r;
			r = f.readLine();
			while(r!=null) //tant qu'il y a encore des lignes de texte
			{
			  StringTokenizer st = new StringTokenizer(r,"\t");
				String jour = st.nextToken();
				float temp = Float.parseFloat(st.nextToken());
				float prec = Float.parseFloat(st.nextToken());
				ValMeteoJour vmj = new ValMeteoJour(jour, temp, prec);
				this.add(vmj);
				r = f.readLine();
			}
			f.close();
		}

    public void sauver(String nomF) throws IOException {
      BufferedWriter f = new BufferedWriter(new FileWriter(nomF, true));
      f.write(this.lieu);
      f.newLine();
      f.write(this.numSemaine);
      Iterator<ValMeteoJour> ite = this.iterator();
      while(ite.hasNext()) {
        f.newLine();
        ValMeteoJour v = new ValMeteoJour(ite.next());
        f.write(v.getJour() + "\t" + v.getTemp() + "\t" + v.getPrec());
      }
      f.close();
  }

    public String toString() {
      String textMeteo = "Lieu : " + this.lieu + "\nSemaine : " + this.numSemaine + "\n";
      Iterator<ValMeteoJour> ite = this.iterator();
      while(ite.hasNext()) {
        textMeteo += ite.next() + "\n";
      }
      return textMeteo;
    }
  }
