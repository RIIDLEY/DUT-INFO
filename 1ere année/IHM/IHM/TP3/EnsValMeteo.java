import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.StringTokenizer;

public class EnsValMeteo extends java.util.ArrayList<ValMeteoJour> {

	private String lieu;
	private int numSemaine;
	public EnsValMeteo() {

	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public int getSemaine() {
		return numSemaine;
	}
	public void setSemaine(int semaine) {
		this.numSemaine = semaine;
	}
	public void charge(String nomFic){
		try
		{
			//on supprime tous les éléments si il y en a
			while(this.size()!=0){
				this.remove(0);
			}
			FileReader fr = new FileReader(nomFic);
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
	public void sauve(String nomFic){
		try
		{
			FileWriter fw = new FileWriter(nomFic);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(this.lieu+"\n");
			bw.write(""+this.numSemaine+"\n");
			for(ValMeteoJour aVal:this){
				bw.write(aVal.getJour()+"\t"+aVal.getTemp()+"\t"+aVal.getPrec()+"\n");
			}

			bw.close();
			fw.close();
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	public String toString(){
	String retour = "";

	retour += "lieu = "+this.lieu+"\n";
	retour += "semaine = "+this.numSemaine+"\n";

	for(ValMeteoJour aVal:this)
		retour += "jour = "+aVal.getJour()+", "
				+ "temp = "+aVal.getTemp()+", "
				+ "prec = "+aVal.getPrec()+"\n";

	return retour ;
}

	public static void main(String[] args) {
		EnsValMeteo ens = new EnsValMeteo();
		ens.charge("lameteo.txt");
		ens.setSemaine(ens.getSemaine()+1);
		ens.sauve("lameteo.txt");
	}
}
