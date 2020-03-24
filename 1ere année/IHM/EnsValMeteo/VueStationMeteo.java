import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.ArrayList;

public class VueStationMeteo extends FenSimple implements StationMeteoConstante {

  private JButton charger = new JButton("Charger");
  private JButton sauver = new JButton("Sauver");
  private JButton supprimer = new JButton("Supprimer");
  private JLabel place = new JLabel(PLACE);
  private JLabel semaine = new JLabel(SEMAINE);
  private JLabel temperature = new JLabel(TEMPERATURE);
  private JLabel precipitation = new JLabel(PRECIPITATION);
  private JTextField placeF = new JTextField(10);
  private JTextField tempF = new JTextField(10);
  private JTextField precF = new JTextField(10);
  private String fichier;
  private String[] semaineJours = joursSemaine;
  private Object[] chiffres = new Object[52];
  private JComboBox<Object> box;
  private JTextArea texte;
  private EnsValMeteo evm = null;
  private JFileChooser choixFichier = new JFileChooser();
  private JTabbedPane onglet;
  private PanelGraphique pg;
  private float[] precT = {0f,0f,0f,0f,0f,0f,0f};
  private float[] tempT = {0f,0f,0f,0f,0f,0f,0f};

  public VueStationMeteo(String titre, int w, int h){
    super(titre,w,h);
    this.initialise();
    this.initConnections();
    this.initMenu();
    this.setVisible(true);
  }

  public void initialise(){
  	this.setLayout(new BorderLayout());
  	this.add(this.getPanelNord(),BorderLayout.NORTH);
  	this.add(this.getPanelCentre(), BorderLayout.CENTER);
  	this.add(this.getPanelWest(), BorderLayout.WEST);
  	this.add(this.getPanelSud(),BorderLayout.SOUTH);
  }

  public void initConnections() {
    GestBoutonJours blis1 = new GestBoutonJours();
    charger.addActionListener(blis1);
    GestBoutonJours blis2 = new GestBoutonJours();
    sauver.addActionListener(blis2);
    GestBoutonJours blis3 = new GestBoutonJours();
    supprimer.addActionListener(blis3);
  }

  public void initMenu() {
    Iterator<ValMeteoJour> ite = evm.iterator();
    int i = 0;
    while(ite.hasNext()) {
      ValMeteoJour v = new ValMeteoJour(ite.next());
      System.out.println(v);
      this.tempT[i] = v.getTemp();
      System.out.println(tempT[i]);
      this.precT[i] = v.getPrec();
      System.out.println(precT[i]);
      i = i + 1;
    }
    pg = new PanelGraphique(tempT,precT);
    ImageIcon icon = new ImageIcon("terre.jpg");
    JLabel accueil = new JLabel(icon);

    onglet = new JTabbedPane();

    onglet.add("Accueil", accueil);
    onglet.add("Texte", this.getPanelCentre());
    onglet.add("Graphique", pg);
    this.getContentPane().add(onglet);
  }

  public JPanel getPanelSud(){
    JPanel panelSud = new JPanel();
    panelSud.add(this.charger);
    panelSud.add(this.sauver);
    panelSud.add(this.supprimer);
    return panelSud;
  }

  public JPanel getPanelWest()
  {
	   JPanel panelWest = new JPanel();
     panelWest.setLayout(new GridLayout(7,1,10,10));
     for (int i=0; i<semaineJours.length; i++) {
       JButton a = new JButton(semaineJours[i]);
       GestBoutonJours blis3 = new GestBoutonJours();
       a.addActionListener(blis3);
       panelWest.add(a);
     }
     return panelWest;
   }

   public JPanel getPanelCentre() {
     JPanel panelCentre = new JPanel();
     panelCentre.setLayout(new GridLayout(1,1));
     evm = new EnsValMeteo();
     try {
       evm.charger(this.choixFichier());
     }
     catch (Exception e1)   {
       System.out.println(e1);
     }
     String s = evm.toString();
     this.texte = new JTextArea(s);
     panelCentre.add(texte);
     return panelCentre;
   }


   public JPanel getPanelNord() {
        for (int i = 0;i < 52; i++) {
          chiffres[i] = new String(""+(i+1));
        }
        box = new JComboBox<Object>(chiffres);
        JPanel panelNord = new JPanel();
        panelNord.add(this.place);
        panelNord.add(placeF);
        panelNord.add(this.semaine);
        panelNord.add(box);
        panelNord.add(this.temperature);
        panelNord.add(tempF);
        panelNord.add(this.precipitation);
        panelNord.add(precF);
        return panelNord;
    }

  public String choixFichier()
    {
    choixFichier.setFileFilter(new FileNameExtensionFilter("Fichier txt", "txt"));
    choixFichier.setCurrentDirectory(new File("."));
    int siFichierChoisi = choixFichier.showOpenDialog(null);
    if(siFichierChoisi == JFileChooser.APPROVE_OPTION)
      {
        fichier = choixFichier.getSelectedFile().getName();
      }
    else fichier = null;
    return fichier;
    }


  public void charger() {
    int siFichierChoisi = choixFichier.showOpenDialog(null);
    if (siFichierChoisi == JFileChooser.APPROVE_OPTION) {
      this.fichier = choixFichier.getSelectedFile().getName();
      this.evm = new EnsValMeteo();
      try {
        evm.charger(this.fichier);

      }
      catch (Exception e) {
        this.evm = null;
      }
      texte.setText(evm.toString());
      this.initMenu();
      pg.repaint();
      pg.revalidate();
    }
  }

  public void sauver() {
    int siFichierChoisi = choixFichier.showSaveDialog(null);
    if (siFichierChoisi == JFileChooser.APPROVE_OPTION) {
      this.fichier = choixFichier.getSelectedFile().getName();
      try {
        evm.sauver(this.fichier);
      }
      catch (Exception e) {
        JOptionPane.showMessageDialog(null, JOptionPane.ERROR_MESSAGE, "Erreur : fichier non sauvegarder", 1);
      }
    }
  }

  public void supprimer() {
    String selection = texte.getSelectedText();
    StringTokenizer st = new StringTokenizer(selection);
    st.nextToken("=");
    String jour = st.nextToken(",").substring(1).trim();
    st.nextToken("=");
    String temp = st.nextToken(",").substring(1).trim();
    st.nextToken("=");
    String prec = st.nextToken("]").substring(1).trim();
    float precF = Float.parseFloat(prec);
    float tempF = Float.parseFloat(temp);

    ValMeteoJour v = new ValMeteoJour(jour,tempF,precF);
    evm.remove(v);
    texte.setText(evm.toString());
  }


  class GestBoutonJours implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      String action = e.getActionCommand();
      switch(action) {

        case "Charger":
          charger();
          break;

        case "Sauver":
          sauver();
          break;

        case "Supprimer":
          supprimer();
          break;

        case "Lundi":
          if(placeF.getText().isEmpty() || tempF.getText().isEmpty() || precF.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Erreur : données manquante");
          }
          else if(Float.parseFloat(tempF.getText()) > 55f || Float.parseFloat(tempF.getText()) < -88f || Float.parseFloat(precF.getText()) > 1340f ){
            JOptionPane.showMessageDialog(null, "Erreur : données erronée");
          }
          else{
            float temperature = Float.parseFloat(tempF.getText());
            //System.out.println(tempT);
            //int ltT = tempT.length;
            //System.out.println("e");
            //tempT[ltT] = temperature;
            float precipitation = Float.parseFloat(precF.getText());
            //int lpT = precT.length;
            //precT[lpT] = precipitation;
            //System.out.println(tempT);
            //System.out.println(precT);
            evm = new EnsValMeteo(placeF.getText(),box.getSelectedItem().toString());
            evm.add(new ValMeteoJour("Lundi",temperature,precipitation));
            texte.setText(evm.toString());
          }
          break;

          case "Mardi":
            if(placeF.getText().isEmpty() || tempF.getText().isEmpty() || precF.getText().isEmpty()){
              JOptionPane.showMessageDialog(null, "Erreur : données manquante");
            }
            else if(Float.parseFloat(tempF.getText()) > 55f || Float.parseFloat(tempF.getText()) < -88f || Float.parseFloat(precF.getText()) > 1340f ){
              JOptionPane.showMessageDialog(null, "Erreur : données erronée");
            }
            else{
              float temperature = Float.parseFloat(tempF.getText());
              float precipitation = Float.parseFloat(precF.getText());
              evm = new EnsValMeteo(placeF.getText(),box.getSelectedItem().toString());
              evm.add(new ValMeteoJour("Mardi",temperature,precipitation));
              texte.setText(evm.toString());
            }
            break;

          case "Mercredi":
            if(placeF.getText().isEmpty() || tempF.getText().isEmpty() || precF.getText().isEmpty()){
              JOptionPane.showMessageDialog(null, "Erreur : données manquante");
            }
            else if(Float.parseFloat(tempF.getText()) > 55f || Float.parseFloat(tempF.getText()) < -88f || Float.parseFloat(precF.getText()) > 1340f ){
              JOptionPane.showMessageDialog(null, "Erreur : données erronée");
            }
            else{
              float temperature = Float.parseFloat(tempF.getText());
              float precipitation = Float.parseFloat(precF.getText());
              evm = new EnsValMeteo(placeF.getText(),box.getSelectedItem().toString());
              evm.add(new ValMeteoJour("Mercredi",temperature,precipitation));
              texte.setText(evm.toString());
            }
            break;

          case "Jeudi":
            if(placeF.getText().isEmpty() || tempF.getText().isEmpty() || precF.getText().isEmpty()){
              JOptionPane.showMessageDialog(null, "Erreur : données manquante");
            }
            else if(Float.parseFloat(tempF.getText()) > 55f || Float.parseFloat(tempF.getText()) < -88f || Float.parseFloat(precF.getText()) > 1340f ){
              JOptionPane.showMessageDialog(null, "Erreur : données erronée");
            }
            else{
              float temperature = Float.parseFloat(tempF.getText());
              float precipitation = Float.parseFloat(precF.getText());
              evm = new EnsValMeteo(placeF.getText(),box.getSelectedItem().toString());
              evm.add(new ValMeteoJour("Jeudi",temperature,precipitation));
              texte.setText(evm.toString());
            }
            break;

          case "Vendredi":
            if(placeF.getText().isEmpty() || tempF.getText().isEmpty() || precF.getText().isEmpty()){
              JOptionPane.showMessageDialog(null, "Erreur : données manquante");
            }
            else if(Float.parseFloat(tempF.getText()) > 55f || Float.parseFloat(tempF.getText()) < -88f || Float.parseFloat(precF.getText()) > 1340f ){
              JOptionPane.showMessageDialog(null, "Erreur : données erronée");
            }
            else{
              float temperature = Float.parseFloat(tempF.getText());
              float precipitation = Float.parseFloat(precF.getText());
              evm = new EnsValMeteo(placeF.getText(),box.getSelectedItem().toString());
              evm.add(new ValMeteoJour("Vendredi",temperature,precipitation));
              texte.setText(evm.toString());
            }
            break;

          case "Samedi":
            if(placeF.getText().isEmpty() || tempF.getText().isEmpty() || precF.getText().isEmpty()){
              JOptionPane.showMessageDialog(null, "Erreur : données manquante");
            }
            else if(Float.parseFloat(tempF.getText()) > 55f || Float.parseFloat(tempF.getText()) < -88f || Float.parseFloat(precF.getText()) > 1340f ){
              JOptionPane.showMessageDialog(null, "Erreur : données erronée");
            }
            else{
              float temperature = Float.parseFloat(tempF.getText());
              float precipitation = Float.parseFloat(precF.getText());
              evm = new EnsValMeteo(placeF.getText(),box.getSelectedItem().toString());
              evm.add(new ValMeteoJour("Samedi",temperature,precipitation));
              texte.setText(evm.toString());
            }
            break;

          case "Dimanche":
            if(placeF.getText().isEmpty() || tempF.getText().isEmpty() || precF.getText().isEmpty()){
              JOptionPane.showMessageDialog(null, "Erreur : données manquante");
            }
            else if(Float.parseFloat(tempF.getText()) > 55f || Float.parseFloat(tempF.getText()) < -88f || Float.parseFloat(precF.getText()) > 1340f ){
              JOptionPane.showMessageDialog(null, "Erreur : données erronée");
            }
            else{
              float temperature = Float.parseFloat(tempF.getText());
              float precipitation = Float.parseFloat(precF.getText());
              evm = new EnsValMeteo(placeF.getText(),box.getSelectedItem().toString());
              evm.add(new ValMeteoJour("Dimanche",temperature,precipitation));
              texte.setText(evm.toString());
            }
            break;
      }
    }
  }
}
