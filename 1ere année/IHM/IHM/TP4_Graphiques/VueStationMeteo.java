import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Color;

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
import javax.swing.JTabbedPane;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class VueStationMeteo extends JFrame implements StationMeteoConstantes {

	private EnsValMeteo ensValTempPrec;

	// Partie sud
	private JButton btnCharger;
	private JButton btnSauver;
	private JButton btnSupprimer;

	// Partie nord
	private JComboBox<Integer> fieldSemaine; // ComboBox
	private JTextField fieldPlace;
	private JTextField fieldValTemp;
	private JTextField fieldValPrec;

	// Partie Centre
	private JTextArea jtext;

	// Partie ouest
	private JButton[] btnJours; // Tableau avec tous les jours de la semaine

	private PanelGraphique panGraph;

	public VueStationMeteo(String titre){
		super(titre);

		// Initializer les compsoants nord, sud, est ouest
		this.initialise();

		// Initialzer les EventHandlers sur les boutons
		this.initConnections();

		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Operation
		this.centreEcran(600,400); // Centrer la fenètre
		this.setVisible(true); // Rendre visible

		// Méthode charger: charger le fichier et le stocker dans la vue en
		// tant qu'un EnsValMeteo
 		this.charger();
 		// Méthode afficher: afficher le contenu (EnsValMeteo)
		this.afficheValeurs();
	}

	protected void centreEcran(int w,int h) {
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension dim=tk.getScreenSize();
		int x =(dim.width-w)/2;
		int y =(dim.height-h)/2;
		this.setBounds(x,y,w,h); //centre au milieu de la fenêtre
	}

	public void initialise() {
		this.ensValTempPrec = new EnsValMeteo();

		this.setLayout(new BorderLayout());
		this.add(this.getPanelNord(),BorderLayout.NORTH);
		this.add(this.getPanelCenter(), BorderLayout.CENTER);
		this.add(this.getPanelWest(), BorderLayout.WEST);
		this.add(this.getPanelSud(),BorderLayout.SOUTH);
	}

	private JPanel getPanelSud(){
		// Initalise le panel
		JPanel pan = new JPanel();

		// Ajouter les composants
		this.btnSauver = new JButton("sauver");
		this.btnCharger = new JButton("charger");
		this.btnSupprimer = new JButton("supprimer");

    this.btnCharger.setBackground(Color.BLUE);
		this.btnSauver.setBackground(Color.WHITE);
    this.btnSupprimer.setBackground(Color.RED);

		pan.add(this.btnCharger); // Ajouter qqch
		pan.add(this.btnSauver);
		pan.add(this.btnSupprimer);

		// Retourner le panel
		return pan;
	}

	private JPanel getPanelNord(){

		// Initalise le panel
		JPanel pan = new JPanel();

		// Place: on utilise direcements les constantes de l'interface
		// Comme JLabel ne va pas être modifié, il n'appartient pas à la classe
		JLabel lblPlace = new JLabel(StationMeteoConstantes.PLACE);
		pan.add(lblPlace);

		this.fieldPlace = new JTextField(5);
		pan.add(this.fieldPlace);


 		// Label semaine
 		JLabel lbSemaine = new JLabel(StationMeteoConstantes.SEMAINE);
		pan.add(lbSemaine);
		// Semaine
		// On initialise avec 52 entiers
		Integer[] numSem = new Integer[52];
		for(int i=0; i<52;i++)
			numSem[i]= i+1;
		this.fieldSemaine = new JComboBox<Integer>(numSem);
		pan.add(this.fieldSemaine);


		// Tempéraure
		JLabel lblValTemp= new JLabel(StationMeteoConstantes.TEMPERATURE);
		pan.add(lblValTemp);

		fieldValTemp = new JTextField(5);
		pan.add(fieldValTemp);


		// Précipitation
		JLabel lblValPrec= new JLabel(StationMeteoConstantes.PRECIPITATION);
		pan.add(lblValPrec);

		fieldValPrec = new JTextField(5);
		pan.add(fieldValPrec);

		return pan;
	}

	/*
	 * Le JPanel du centre retourne une pane de type JTabbedPane.
	 * Cette pane accepte des tabulations, qui sont chacune des JPanel.
	 */
	private JTabbedPane getPanelCenter() {
		// Inialisation du panel
		JPanel pan = new JPanel();
		pan.setLayout(new BorderLayout());
		JTabbedPane jTabPane = new JTabbedPane();

		/*
		 * Panel de bienvenue
		 */
		JPanel panAccueil = new JPanel();
		panAccueil.setLayout(new BorderLayout());

		JLabel etiq = new JLabel("Bienvenue dans le logiciel de saisie de données météorologiques");
		panAccueil.add(etiq,BorderLayout.NORTH);
		PanelImage panImage = new PanelImage("Terre.jpeg");
		panAccueil.add(panImage,BorderLayout.CENTER);
		jTabPane.add(panAccueil,"Accueil");

		/*
		 * Panel de texte
		 */
		this.jtext = new JTextArea(9,25);
		JScrollPane jsc = new JScrollPane(jtext);
		pan.add(jsc,BorderLayout.CENTER);

		this.jtext.setText(""); // Initialiser le texte a vide
		jTabPane.add(jsc,"Texte");

		/*
		 * Panel graphique
		 */
		float[]tempSemaineVal = new float[7];
		for(int i=0; i<tempSemaineVal.length; i++){
			tempSemaineVal[i]=-1;
		}
		float[] precSemaineVal = new float[7];
		for(int i=0; i<precSemaineVal.length; i++){
			precSemaineVal[i]=-1;
		}
		this.panGraph = new PanelGraphique(tempSemaineVal, precSemaineVal);
		jTabPane.add(panGraph, "Graphique");

		return jTabPane;
	}

	private JPanel getPanelWest() {
		// Initalise le panel
		JPanel pan = new JPanel();
		this.btnJours = new JButton[this.joursSemaine.length];

		// Initalise le layout:
		// layout en grille, avec 7 lignes et 1 colonnes
		//                   avec un espace de 2 horizontal et 10 vertical
		// La longeur est faite dynamiquement avec la longeur de joursSemaine[]
		pan.setLayout(new GridLayout(this.joursSemaine.length,1, 2, 10));

		// Pour chacun des boutons, les ajouter
		for (int i = 0; i < this.joursSemaine.length; i++) {
			this.btnJours[i] = new JButton( this.joursSemaine[i]);
			pan.add(this.btnJours[i]);
		}

		return pan;
	}


	/*
	 * L'affichage est double:
	 *  sous forme graphique.
	 *  sous forme textuelle.
	 */
	public void afficheValeurs(){
		this.jtext.setText(this.ensValTempPrec.toString());

		for(int i=0; i< this.ensValTempPrec.size();i++){
			ValMeteoJour aJour =this.ensValTempPrec.get(i);
			this.panGraph.getTempSemaineVal()[i]= aJour.getTemp();
			this.panGraph.getPrecSemaineVal()[i]= aJour.getPrec();

		}
		this.panGraph.repaint();
	}

 	// Partie affichage
	public boolean charger(){
		String fichier = "";
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

		this.ensValTempPrec.lire(fichier);

		return true;
	}

	public boolean sauver(){
		// Initialiser un JFileChooser...
		JFileChooser jfc = new JFileChooser(System.getProperty("user.dir"));
		jfc.setDialogTitle("Definir un fichier");

		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		jfc.showSaveDialog(this);

		// Obtenir le fichier..
		String fichier = jfc.getSelectedFile().getName();
		if(fichier.trim().equals(""))
			// Non du fichier incorrect
			return false;
		this.ensValTempPrec.ecrire(fichier);
		return true;
	}

	public boolean supprimer(){
		String selection = this.jtext.getSelectedText();
		//System.out.println(selection);

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
		ValMeteoJour unAutreValJ =this.ensValTempPrec.get(0);

		/*
		System.out.println(unValJ);
		System.out.println(unAutreValJ);
		System.out.println(unValJ.equals(unAutreValJ)); */

		this.ensValTempPrec.remove(unValJ);
		return true;
	}

	public void initConnections(){
		// Pour chaque bouton jour, ajouter l'EventListener
		for(int i=0; i< this.joursSemaine.length;i++)
			btnJours[i].addActionListener(new GestBoutonsJours(i));
		// Ajouter pour le bouton charger, sauver, supprimer
		this.btnCharger.addActionListener(new GestBoutonsJours(StationMeteoConstantes.charger));
		this.btnSauver.addActionListener(new GestBoutonsJours(StationMeteoConstantes.sauver));
		this.btnSupprimer.addActionListener(new GestBoutonsJours(StationMeteoConstantes.supprimer));
	}

	public void saisieValeurs(String jour){
		// getText permet d'obtenir un String d'un field
	    //String numSemaine = fieldSemaine.getText();

 		String numSemaine = fieldSemaine.getSelectedItem().toString();

		String lieu = fieldPlace.getText();
		String temp = fieldValTemp.getText();
		String prec = fieldValTemp.getText();

		ValMeteoJour valMeteo = verifSaisies(lieu,jour,temp,prec);
		if (valMeteo==null) return;

		this.ensValTempPrec.setLieu(lieu);
		this.ensValTempPrec.setNumSemaine( Integer.parseInt(numSemaine) );
		this.ensValTempPrec.add(valMeteo);
	}

	public ValMeteoJour verifSaisies(String place, String jour, String temp, String prec) {
		if(place.trim().equals("")
				|| temp.trim().equals("")
				|| prec.trim().equals("")){
			JOptionPane.showMessageDialog(this,"Veuillez remplir tous les champs!");
			return null;
		}
		// Saisie de virgule au lieu de point
		NumberFormat nf = NumberFormat.getInstance(Locale.FRENCH);

		ValMeteoJour aValJour = new ValMeteoJour();
		try{
			float numberTemp = nf.parse(temp).floatValue();
			if ( numberTemp < -88 || numberTemp > 58) {
				JOptionPane.showMessageDialog(this,"Valeur de la temperature incorrecte - comprise entre -88 et +58");
				return null;
			}
			aValJour.setTemp(numberTemp); // setTemp


			String precipitations = this.fieldValPrec.getText();
			// Parsage de virgule
			float numberPrec = nf.parse(precipitations).floatValue();
			if ( numberPrec < 0 || numberPrec > 1340 ) {
				JOptionPane.showMessageDialog(this,"Valeur de la precipitation est incorrecte - comprise entre 0 et 1340");
				return null;
			}
			aValJour.setPrec(numberPrec); // setPrec

			// Pas de verifications pour jour
			aValJour.setJour(jour); // setJour
		} catch(Exception e){
			JOptionPane.showMessageDialog(this,"Nombre réel obligatoire!");
			return null;
		}
		return aValJour;
	}

	/* GestBoutonsJours est un handler pour tous les boutons.
	 * Il gère à la fois les boutons de jours, charger, sauver et supprimer.
	*/
	class GestBoutonsJours implements ActionListener {
		private int id;
		public GestBoutonsJours(int i){
			this.id = i;
		}

		public void actionPerformed(ActionEvent e) {
		switch (id) {
			// On utilise les constantes de l'interface.
			// id: 11
			case StationMeteoConstantes.charger:
				if(VueStationMeteo.this.charger()){
					VueStationMeteo.this.afficheValeurs();
				}
				break;

			// id: 12
			case StationMeteoConstantes.sauver:
				VueStationMeteo.this.sauver();
				break;

			// id: 13
			case StationMeteoConstantes.supprimer:
				VueStationMeteo.this.supprimer();
				VueStationMeteo.this.afficheValeurs();
				break;

 			// id: 0, 1, 2, 3, 4, 5, 6
			default:
				VueStationMeteo.this.saisieValeurs(StationMeteoConstantes.joursSemaine[id]);
				VueStationMeteo.this.afficheValeurs();
				break;
			}
		}
	}

	public static void main(String[] args) {
		VueStationMeteo v = new VueStationMeteo("Station Météo");
	}
}
