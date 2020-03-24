import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;


public class VueStationMeteo extends JFrame
{
    private static final long serialVersionUID = 1928933093147963906L;
    private JFileChooser choixFichier= new JFileChooser();  // creation de l'objet choix d'un fichier
    private JButton bcharger = new JButton ("Charger");
    private JButton bsauver = new JButton ("Sauver");
    private JButton bsupprimer = new JButton ("Supprimer");
    private JButton[] jours = new JButton[7] ;
    private JLabel place = new JLabel(PLACE);
    private JLabel semaine = new JLabel(SEMAINE);
    private JLabel temperature = new JLabel(TEMPERATURE);
    private JLabel precipitation = new JLabel(PRECIPITATION);
    private JTextField txt_place = new JTextField(5);
    private JComboBox<Integer> numeroDeSemaine;
    private JTextField txt_temperature = new JTextField(5);
    private JTextField txt_precipitation = new JTextField(5);
    private File fichier;
    private String[] donnee;
    private EnsValMeteo evm = null;
    private DefaultTableModel model = new DefaultTableModel()
    {
        private static final long serialVersionUID = 1L;

        @Override
        public boolean isCellEditable(int row, int column)
        {
           //all cells false
           return false;
        }
    };
    private JTable texte = new JTable(model);
    private JTabbedPane jTabPane = new JTabbedPane();

    public VueStationMeteo( String titre , int w, int h)
    {
        super(titre);
        this.initialise();
        this.setSize(w,h);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.charger();
        this.initconnections();
    }

    public void initialise()
    {
        this.setLayout(new BorderLayout());
        this.add(this.getPanelNord(),BorderLayout.NORTH);
        this.add(this.getPanelCentre(), BorderLayout.CENTER);
        this.add(this.getPanelWest(), BorderLayout.WEST);
        this.add(this.getPanelSud(),BorderLayout.SOUTH);
        File dossier_courant = new File(".");
        choixFichier.setFileFilter(new FileNameExtensionFilter("Fichier txt", "txt")); // filtrer la selection avec des fichier txt
        choixFichier.setCurrentDirectory(dossier_courant);   // selectionner le dossier courant
    }

    public JPanel getPanelSud()
    {
        JPanel panelSud = new JPanel();
        panelSud.add(this.bcharger);
        panelSud.add(this.bsauver);
        panelSud.add(this.bsupprimer);
        return panelSud;
    }

    public JTabbedPane getPanelCentre()
    {
        JPanel onglet1 = new JPanel();
        JPanel onglet2 = new JPanel();
        JPanel onglet3 = new JPanel();
        onglet1.setLayout(new BorderLayout());
        onglet1.add(new JLabel("Bienvenue sur le site de saisie de données météorologiques"),BorderLayout.NORTH);
        onglet1.add(new PanelImage("Terre.jpg"),BorderLayout.CENTER);
        onglet2.setLayout(new GridLayout(1,1));
        onglet2.add(texte);
        jTabPane.addTab("Accueil", onglet1);
        jTabPane.addTab("Texte", onglet2);
        jTabPane.addTab("Graphique", onglet3);
        return jTabPane;
    }

    public JPanel getPanelNord()
    {
        JPanel panelNord = new JPanel();
        panelNord.add(this.place);
        panelNord.add(this.txt_place);
        panelNord.add(this.semaine);
        Integer[] tableau = new Integer[52];
        for (int i = 0; i < 52; i++)
        {
            tableau[i] = i+1;
        }
        this.numeroDeSemaine = new JComboBox<Integer>(tableau);
        panelNord.add(this.numeroDeSemaine);
        panelNord.add(this.temperature);
        panelNord.add(this.txt_temperature);
        panelNord.add(this.precipitation);
        panelNord.add(this.txt_precipitation);
        return panelNord;
    }

    public JPanel getPanelWest()
    {
        JPanel panelWest = new JPanel();
        panelWest.setLayout(new GridLayout(7,1));
        for (int i = 0; i<7; i++)
        {
            JButton jb = new JButton(joursSemaine[i]);
            this.jours[i] = jb;
            panelWest.add(jb);
        }
        return panelWest;
    }

    private void initconnections()
    {
        bsauver.addActionListener(new GestBoutons(sauver));
        bcharger.addActionListener(new GestBoutons(charger));
        bsupprimer.addActionListener(new GestBoutons(supprimer));
        for (int i = 0; i < 7; i++)
        {
            this.jours[i].addActionListener(new GestBoutons(i));
        }
    }

   public void saisieValeur(String jour)
    {
        boolean estvide = this.texte.getRowCount() == 0 && this.txt_place.getText().trim().length() != 0;
        if (estvide) // si le panel centre est vide et que le champ lieu n'est pas vide
        {
            String lieu = this.txt_place.getText(); // recuperer le lieu saisie
            String numSemaine = this.numeroDeSemaine.getSelectedItem().toString(); // recuperer le numéro de semaine selectionner
            evm = new EnsValMeteo(lieu, numSemaine); // creation nouvelle arraylist EnsValMeteo
        }
        if(this.txt_temperature.getText().trim().length()!= 0 && this.txt_precipitation.getText().trim().length() != 0 &&  evm != null)
        {
            try
            {
                float temp = Integer.parseInt(this.txt_temperature.getText()); // recuperer la temperature saisie
                float prec = Integer.parseInt(this.txt_precipitation.getText()); // recuperer la precipitation saisie
                if (temp<=-88 || temp>=58 || prec<0 || prec>1340) JOptionPane.showMessageDialog(null, "Erreur : La saisie est erronée", "Erreur", JOptionPane.ERROR_MESSAGE);
                else
                {
                    ValMeteoJour val = new ValMeteoJour(jour, temp, prec);
                    evm.add(val);
                    this.rafraichir();
                }
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, "Erreur : La saisie de température ou de précipitation est erronée", "Pas un nombre", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public boolean sauver()
    {
        int siFichierChoisi = choixFichier.showSaveDialog(null);  // afficher le popup pour choisir et enregistrer si on a choisi
        if(siFichierChoisi == JFileChooser.APPROVE_OPTION) // si seulement un fichier est choisi on creer la fenetre
        {
            this.fichier = choixFichier.getSelectedFile(); //avoir le fichier
            try
            {
                evm.sauver(this.fichier);
            }
            catch (Exception e)
            {
//TestEnValMeteo

import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class TestEnsValMeteo{
	  public static void main (String args[]){
		      EnsValMeteo e = new EnsValMeteo();
		      try {
			         e.charger("testEnsValMeteo.txt");
							 e.sauver("Texte.txt");
		           }
          catch (IOException e1) {
			         e1.printStackTrace();
		}
	}
}
                JOptionPane.showMessageDialog(null, "Erreur : fichier non sauvegardé", "Erreur de sauvegarde", JOptionPane.ERROR_MESSAGE);
            }
        }
		return true;
    }
    public boolean charger()
    {
        int siFichierChoisi = choixFichier.showOpenDialog(null);  // afficher le popup pour sauver et enregistrer si on a choisi
        if(siFichierChoisi == JFileChooser.APPROVE_OPTION) // si seulement un fichier est choisi on creer la fenetre
        {
            this.fichier = choixFichier.getSelectedFile(); //avoir le fichier
            this.evm = new EnsValMeteo(); // creation nouvelle arraylist EnsValMeteo
            try
            {
                evm.charger(this.fichier);
                this.rafraichir();
            }
            catch (Exception e1)
            {
                JOptionPane.showMessageDialog(null, "Erreur : fichier erroné ou corrompu", "Erreur", JOptionPane.ERROR_MESSAGE);
                this.evm = null;
                this.model.setColumnCount(0);
                this.model.setRowCount(0);
            }
        }
        else this.fichier = null;
        return true;
    }

    public boolean supprimer()
    {
        int index = this.texte.getSelectedRow();
        if(index > 0 && index < this.texte.getRowCount() )evm.remove(index-1);
        this.rafraichir();
        return true;
    }

    public void rafraichir()
    {
        StringTokenizer st = new StringTokenizer(evm.toString(),"\n");
        donnee = new String[st.countTokens()];
        int i = 0;
        while(st.hasMoreTokens())
        {
            donnee[i]=st.nextToken();
            i++;
        }
        model.setColumnCount(0);
        model.setRowCount(0);
        model.addColumn(donnee[0], donnee);
        model.fireTableDataChanged();
    }

    class GestBoutons implements ActionListener
    {
        private int id;

        public GestBoutons(int id)
        {
            this.id = id;
        }

        public void actionPerformed(ActionEvent e)
        {
            switch (id)
            {
                case sauver :
                    sauver();
                    break;

                case charger :
                    charger();
                    break;

                case supprimer :
                    supprimer();
                    break;

                default :
                    saisieValeur(joursSemaine[id]);
                    break;
            }
        }
    }

}
