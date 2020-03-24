import java.util.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EnsValMeteo extends java.util.ArrayList<ValMeteoJour> {
	private String lieu;
	private int numSemaine;
	private static final String[] joursSemaine = {"lundi", "mardi", "mercredi", "jeudi", "vendredi", "samedi", "dimanche"};
	
	public EnsValMeteo() {
		super();
	}

	public void setLieu(String newLieu) {
		this.lieu = newLieu;
	}
	public void setNumSemaine(int newSemaine) {
		this.numSemaine = newSemaine;
	}
	public String getLieu() {
		return this.lieu;
	}
	public int getNumSemaine() {
		return this.numSemaine;
    }

	public void lire(String fichier) {
		this.lieu = "";
		this.numSemaine = 0;
		int size = super.size();
		for (int i = 0; i < size-1; i++) {
			super.remove(0);
		}
	
		try
		{
			//on supprime tous les éléments si il y en a
			while(this.size()!=0){
				this.remove(0);
			}
			FileReader fr = new FileReader(fichier);
			BufferedReader br = new BufferedReader(fr);
			String line;
 
			//lecture de l'endroit
			line = br.readLine();
			this.lieu = line;
 
			//lecture de la semaine
			line = br.readLine();
			this.numSemaine = Integer.parseInt(line) ;
 
			//lecture des valeurs
			line = br.readLine();			
			while(line!=null){
				StringTokenizer st = new StringTokenizer(line,"\t");
				ValMeteoJour aVal = new ValMeteoJour();
				aVal.setJour(st.nextToken());
				aVal.setTemp(Float.parseFloat(st.nextToken()));
				aVal.setPrec(Float.parseFloat(st.nextToken()));
				this.add(aVal);
				line = br.readLine();
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			System.err.println(e);
		}
	}	

	public String toString(){
		String retour = "";
 
		retour += "lieu="+this.lieu+"\n";
		retour += "semaine="+this.numSemaine+"\n";
 
		for(ValMeteoJour aVal:this)
			retour += "[jour="+aVal.getJour()+","
					+ "temp="+aVal.getTemp()+","
					+ "prec="+aVal.getPrec()+"]\n";
 
		return retour ;
	}

	public void ecrire(String fichier) {
		try {
			BufferedWriter sortie = new BufferedWriter (new FileWriter (fichier));
			// 1e ligne: le lieu
			sortie.write(this.getLieu());
			sortie.newLine();
	
			// 2e ligne: le numéro de semaine
			sortie.write( Integer.toString(this.getNumSemaine()) );
			sortie.newLine();

			// Chacune des lignes restantes: ecrire chaque ligne
			for (int i = 0; i < super.size(); i++) {
				ValMeteoJour val = super.get(i); // Une ValMeteoJour
				sortie.write( val.getJour() );
				sortie.write("\t");
				sortie.write( Float.toString(val.getTemp()) );
				sortie.write("\t");
				sortie.write( Float.toString(val.getPrec()) );
				sortie.newLine();
			}
			sortie.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	
}
