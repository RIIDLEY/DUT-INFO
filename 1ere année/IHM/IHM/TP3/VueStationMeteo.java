import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import javax.swing.border.Border;
import java.io.*;

public class VueStationMeteo extends JFrame implements StationMeteoConstantes  {

	private EnsValMeteo ensValTempPrec;

	// Q 1.2
	private JComboBox<Integer> fieldSemaine;

	private JTextField fieldPlace;
	private JTextField fieldValTemp;
	private JTextField fieldValPrec;
	private JTextArea jText;
	private JButton btnCharger;
	private JButton btnSauver;
	private JButton btnJours[];
	private String nomFich;
	//Q 2.1
	private JButton btnSupprimer;

	public VueStationMeteo(String titre){
		super(titre);
		this.initialise();
		this.initConnections();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.centreEcran(600,400);
		this.setVisible(true);

		this.charger();
		this.afficheValeurs();
	}

	protected void centreEcran(int w, int h){
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension dim=tk.getScreenSize();
		int X=(dim.width-w)/2;
		int Y=(dim.height-h)/2;
		this.setBounds(X,Y,w,h); //centre au milieu de la fenêtre
	}

	public void initialise(){
		this.ensValTempPrec = new EnsValMeteo();
		this.setLayout(new BorderLayout());
		this.add(this.getPanelNord(),BorderLayout.NORTH);
		this.add(this.getPanelCentre(), BorderLayout.CENTER);
		this.add(this.getPanelWest(), BorderLayout.WEST);
		this.add(this.getPanelSud(),BorderLayout.SOUTH);
	}

	public JPanel getPanelCentre(){
		JPanel pan = new JPanel();
		pan.setLayout(new BorderLayout());
		jText = new JTextArea(9,25);
		JScrollPane jsc = new JScrollPane(jText);
		pan.add(jsc,BorderLayout.CENTER);

		jText.setText("");
		return pan;
	}

	public JPanel getPanelNord(){

		//panel des boutons
		JPanel pan = new JPanel();

		//place
		JLabel lblPlace = new JLabel(StationMeteoConstantes.PLACE);
		pan.add(lblPlace);
		this.fieldPlace = new JTextField(5);
		pan.add(this.fieldPlace);

		//semaine
		JLabel lbSemaine = new JLabel(StationMeteoConstantes.SEMAINE);
		pan.add(lbSemaine);

		// Boucle tant que i < 36 
		Integer[] numSem = new Integer[52];
		for(int i=0; i<36;i++)
			numSem[i]= i+1;
		this.fieldSemaine = new JComboBox<Integer>(numSem);
		pan.add(this.fieldSemaine);

		//temp
		JLabel lblValTemp= new JLabel(StationMeteoConstantes.TEMPERATURE);
		pan.add(lblValTemp);
		fieldValTemp = new JTextField(5);
		pan.add(fieldValTemp);

		//precipitation
		JLabel lblValPrec= new JLabel(StationMeteoConstantes.PRECIPITATION);
		pan.add(lblValPrec);
		fieldValPrec = new JTextField(5);
		pan.add(fieldValPrec);

		return pan;
	}

	public JPanel getPanelWest(){
		JPanel pan = new JPanel();
		btnJours = new JButton[7];
		pan.setLayout(new GridLayout(VueStationMeteo.joursSemaine.length,1,10,10));
		for(int i=0; i< VueStationMeteo.joursSemaine.length;i++){
			btnJours[i] = new JButton(VueStationMeteo.joursSemaine[i]);
			btnJours[i].setBackground(new Color(210, 218, 226));
			pan.add(btnJours[i]);
		}
		return pan;
	}

	public JPanel getPanelSud(){
		JPanel panBout = new JPanel();
		this.btnCharger = new JButton("Charger");
		btnCharger.setBackground(new Color(255, 94, 87));

		this.btnSauver = new JButton("Sauvegarder");
		btnSauver.setBackground(new Color(15, 188, 249));

		this.btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBackground(new Color(11, 232, 129));

		panBout.add(this.btnCharger);
		panBout.add(this.btnSauver);
		panBout.add(this.btnSupprimer);
		return panBout;

	}

	public void afficheValeurs(){
		this.jText.setText(this.ensValTempPrec.toString());
	}

	public boolean charger(){
		String fichier = "testEnsValMeteo.txt";

		JFileChooser jfc = new JFileChooser(System.getProperty("user.dir"));

		FileFilter filter = new FileNameExtensionFilter("texte", ".txt");
		jfc.addChoosableFileFilter(filter);
		int ret = jfc.showDialog(null, "Ouvrir un fichier");

		if (ret != JFileChooser.APPROVE_OPTION) {
			return false;
		}

		fichier = jfc.getSelectedFile().getName();
		if(fichier.trim().equals("")){
			//nom du fichier incorrect
			return false;
		}

		this.ensValTempPrec.charge(fichier);
		return true;
	}

	public boolean sauver(){
		// Q 1.0
		//JOptionPane.showMessageDialog(this,"Sauvegarde");
		//return true;

		// Q 1.4
		JFileChooser jfc = new JFileChooser(System.getProperty("user.dir"));
		jfc.setDialogTitle("Definir un fichier");
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		jfc.showSaveDialog(this);
		String fichier = jfc.getSelectedFile().getName();
		if(fichier.trim().equals(""))
			//nom du fichier incorrect
			return false;
		this.ensValTempPrec.sauve(fichier);
		return true;
	}

	// Q 2.2
	public boolean supprimer(){
		String selection = this.jText.getSelectedText();

		StringTokenizer stn = new StringTokenizer(selection,"=,]");
		stn.nextToken("=");
		String jour = stn.nextToken(",").substring(1).trim(); //il y a = au début
		stn.nextToken("=");
		String temp =stn.nextToken(",").substring(1).trim();
		stn.nextToken("=");
		String prec = stn.nextToken("]").substring(1).trim();
		//System.out.println("VueStationMeteo.supprimer() : "+jour+" "+prec+" "+temp);
		float precF = Float.parseFloat(prec);
		float tempF = Float.parseFloat(temp);
		ValMeteoJour unValJ = new ValMeteoJour(jour, tempF, precF);
		return this.ensValTempPrec.remove(unValJ);
	}

	public static void main(String[] args) {
		VueStationMeteo v = new VueStationMeteo("La Station Météo");
	}

	// Q 1.0
	public void initConnections(){
		//gestion des boutons jour
		for(int i=0; i< VueStationMeteo.joursSemaine.length;i++)
			btnJours[i].addActionListener(new GestBoutonsJours(i));
		//gestion des boutons sauver et charger
		this.btnCharger.addActionListener(new GestBoutonsJours(StationMeteoConstantes.charger));
		this.btnSauver.addActionListener(new GestBoutonsJours(StationMeteoConstantes.sauver));
		//Q 2.1
		this.btnSupprimer.addActionListener(new GestBoutonsJours(StationMeteoConstantes.supprimer));
	}

	// Q 1.3
	public ValMeteoJour verifSaisies(String place, String jour, String temp, String prec) {
		if(place.trim().equals("")
				|| temp.trim().equals("")
				|| prec.trim().equals("")){
			JOptionPane.showMessageDialog(this,"Remplissez tous les champs!");
			return null;
		}
		//pour saisir une virgule au lieu d'un point
		NumberFormat nf = NumberFormat.getInstance(Locale.FRENCH);

		ValMeteoJour aValJour = new ValMeteoJour();
		try{
			float numberTemp = nf.parse(temp).floatValue();
			if(numberTemp < -88 || numberTemp >58){
				JOptionPane.showMessageDialog(this,"La temperature doit être comprise entre -88 et +58");
				return null;
			}
			aValJour.setTemp(numberTemp);
			String precipitations = this.fieldValPrec.getText();
			float numberPrec = nf.parse(precipitations).floatValue();
			if(numberPrec<0 || numberPrec> 1340 ){
				JOptionPane.showMessageDialog(this,"La precipitation doit être comprise entre 0 et 1340");
				return null;
			}
			aValJour.setPrec(numberPrec);
		} catch(Exception e){
			JOptionPane.showMessageDialog(this,"Nombre réel obligatoire!");
			return null;
		}
		return aValJour;
	}

	// Q 1.1
	public void saisieValeurs(String jour){
		// Q 1.2
	    //String numSemaine = fieldSemaine.getText();
		String numSemaine = fieldSemaine.getSelectedItem().toString();

		String lieu = fieldPlace.getText();
		String temp = fieldValTemp.getText();
		String prec = fieldValTemp.getText();

		// ValMeteoJour aVaJour = new ValMeteoJour(jour,temp,prec);
		// Q 1.3
		ValMeteoJour aValJour = verifSaisies(lieu,jour,temp,prec);
		if (aValJour==null) return;

		String str = "lieu="+lieu+", numSemaine="+numSemaine+"\n"
				+ aValJour.toString();

		VueStationMeteo.this.jText.setText(str);
		//this.ensValTempPrec.add(aValJour);
	}

	// Q 1.0
	class GestBoutonsJours implements ActionListener{
		private int id;
		public GestBoutonsJours(int i){
			this.id = i;
		}

		public void actionPerformed(ActionEvent e) {
			switch (id) {
			case StationMeteoConstantes.charger:
				if(VueStationMeteo.this.charger()){
					VueStationMeteo.this.afficheValeurs();
				}
				break;
			case StationMeteoConstantes.sauver:
				VueStationMeteo.this.sauver();
				break;
			// Q 2.1
			case StationMeteoConstantes.supprimer:
				VueStationMeteo.this.supprimer();
				VueStationMeteo.this.afficheValeurs();
				break;

			default:
				// Q 1.1
				VueStationMeteo.this.saisieValeurs(StationMeteoConstantes.joursSemaine[id]);
				//VueStationMeteo.this.afficheValeurs();
				break;
			}
		}
	}
}
