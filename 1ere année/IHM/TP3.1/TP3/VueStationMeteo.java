import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class VueStationMeteo extends FenSimple implements StationMeteoConstantes {

  private JButton charger = new JButton("Charger");
  private JButton sauver = new JButton("Sauver");
  private JButton supprimer = new JButton("Supprimer");
  private JFileChooser choixFichier = new JFileChooser();
  private JLabel semaine = new JLabel(SEMAINE);
  private JLabel temperature = new JLabel(TEMPERATURE);
  private JLabel precipitation = new JLabel(PRECIPITATION);
  private String fichier;
  private EnsValMeteo evm = null;
  private JButton[] jours;
  private JLabel place = new JLabel(PLACE);
  private JTextArea texte;
  private Object[] chiffres = new Object[52];
  private JComboBox<Object> deroulent;

  public VueStationMeteo(String titre, int w, int h){
    super(titre,w,h);
    this.initialise();
    this.setVisible(true);
    charger();
  }

  public void initialise(){
  	this.setLayout(new BorderLayout());
  	this.add(this.getPanelNord(),BorderLayout.NORTH);
  	this.add(this.getPanelCentre(), BorderLayout.CENTER);
  	this.add(this.getPanelWest(), BorderLayout.WEST);
  	this.add(this.getPanelSud(),BorderLayout.SOUTH);
    BoutonListener blis1 = new BoutonListener();
    charger.addActionListener(blis1);
    BoutonListener blis2 = new BoutonListener();
    sauver.addActionListener(blis2);
    BoutonListener blis3 = new BoutonListener();
    supprimer.addActionListener(blis3);
  }

public JPanel getPanelSud(){
  JPanel panelSud = new JPanel();
  panelSud.add(this.charger);
  panelSud.add(this.sauver);
  return panelSud;

}

public JPanel getPanelWest()
{
	JPanel panelWest = new JPanel();
  panelWest.setLayout(new GridLayout(7,1,10,10));
  for (int i=0;i<7 ;i++ ) {
    JButton a = new JButton(joursSemaine[i]);
    panelWest.add(a);
  }
return panelWest;
}

public JPanel getPanelCentre()
  {
    JPanel panelCentre = new JPanel();
    panelCentre.setLayout(new GridLayout(1,1));
    EnsValMeteo evm = new EnsValMeteo();
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


  public JPanel getPanelNord()
    {
      for (int i = 0; i<52 ; i++ ) {
        chiffres[i]= new String(""+(i+1));
      }
        deroulent = new JComboBox<Object>(chiffres);
        JPanel panelNord = new JPanel();
        panelNord.add(this.place);
        panelNord.add(new JTextField(10));
        panelNord.add(this.semaine);
        panelNord.add(deroulent);
        panelNord.add(this.temperature);
        panelNord.add(new JTextField(10));
        panelNord.add(this.precipitation);
        panelNord.add(new JTextField(10));
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



  class BoutonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      if (e.getSource() == charger) {
        charger();
      }

      if (e.getSource() == sauver) {
        sauver();
      }

    }
  }
}
