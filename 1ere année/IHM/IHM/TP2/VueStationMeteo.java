import javax.swing.*;
import java.awt.*;

public class VueStationMeteo extends JFrame implements StationMeteoConstantes  {

private EnsValMeteo ensValTempPrec;
private JTextField fieldSemaine;

private JTextField fieldPlace;
private JTextField fieldValTemp;
private JTextField fieldValPrec;
private JTextArea jText;
private JButton btnCharger;
private JButton btnSauver;
private JButton btnJours[];
private String nomFich;



public VueStationMeteo(String titre){
	super(titre);
	this.initialise();
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.centreEcran(800,600);
	this.setVisible(true);

}

protected void centreEcran(int w, int h){
	Toolkit tk=Toolkit.getDefaultToolkit();
	Dimension dim=tk.getScreenSize();
	int X=(dim.width-w)/2;
	int Y=(dim.height-h)/2;
	this.setBounds(X,Y,w,h);
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

	JPanel pan = new JPanel();

	JLabel lblPlace = new JLabel(StationMeteoConstantes.PLACE);
	pan.add(lblPlace);
	this.fieldPlace = new JTextField(6);
	pan.add(this.fieldPlace);

	JLabel lbSemaine = new JLabel(StationMeteoConstantes.SEMAINE);
	pan.add(lbSemaine);
	this.fieldSemaine = new JTextField(6);

	pan.add(this.fieldSemaine);

	JLabel lblValTemp= new JLabel(StationMeteoConstantes.TEMPERATURE);
	pan.add(lblValTemp);
	fieldValTemp = new JTextField(6);
	pan.add(fieldValTemp);

	JLabel lblValPrec= new JLabel(StationMeteoConstantes.PRECIPITATION);
	pan.add(lblValPrec);
	fieldValPrec = new JTextField(6);
	pan.add(fieldValPrec);

	return pan;
}

public JPanel getPanelWest(){
	JPanel pan = new JPanel();
	btnJours = new JButton[7];
	pan.setLayout(new GridLayout(VueStationMeteo.joursSemaine.length,1,12,12));
	for(int i=0; i< VueStationMeteo.joursSemaine.length;i++){
		btnJours[i] = new JButton(VueStationMeteo.joursSemaine[i]);
		btnJours[i].setBackground(new Color(165, 177, 194));

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


	panBout.add(this.btnCharger);
	panBout.add(this.btnSauver);

	return panBout;

}

public static void main(String[] args) {
	VueStationMeteo v = new VueStationMeteo("La station météo");

}
}
