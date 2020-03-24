import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelGraphique extends JPanel implements StationMeteoConstante {
	private float[] precSemaineVal ; //précipitation de la semaine
	private float[] tempSemaineVal;  //température de la semaine

	public PanelGraphique (float[]tempSemaineVal, float[] precSemaineVal ){
		this.tempSemaineVal = tempSemaineVal;
		this.precSemaineVal = precSemaineVal;
	}

	public float[] getPrecSemaineVal() {
		return precSemaineVal;
	}

	public void setPrecSemaineVal(float[] precSemaineVal) {
		this.precSemaineVal = precSemaineVal;
	}

	public float[] getTempSemaineVal() {
		return tempSemaineVal;
	}

	public void setTempSemaineVal(float[] tempSemaineVal) {
		this.tempSemaineVal = tempSemaineVal;
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//trace les axes
		g.setColor(Color.BLACK);
		g.drawLine(0, 300, 400, 300);
		g.drawLine(10, 0, 10, 400);
		g.drawLine(10, 100, 15, 100);
		g.drawLine(10, 200, 15, 200);
		g.drawLine(10, 300, 15, 300);
		g.drawLine(10, 400, 15, 400);

		//affichage des précipitations sous forme d'histogramme
		g.setColor(Color.BLUE);
		for (int i = 0; i < joursSemaine.length; i++) {
			//décalé de 10 (axe) puis de 50 par valeur précédente.
			int x1= 10+(i*50);
			int h= (int)(precSemaineVal[i]*10);
			//largeur de 50 px
			int w= 50;
			int y1= 300-h;
			//System.out.println("x1 "+x1+" y1 "+y1+" w "+w+" h "+h);
			g.fillRect(x1, y1, w, h);
		}

		//affichage de la température sous forme de courbe segmentée
		g.setColor(Color.RED);
		for (int i = 0; i < joursSemaine.length; i++) {
			if((i+1)<joursSemaine.length){
				//décalé de 10 (axe) puis de 25 pour être au milieu du jour
				//puis de 50 par valeur précédente.
				int x1= 10+25+(i*50);
				int y1= 300-(int)(tempSemaineVal[i]*10);
				int x2= 10+25+((i+1)*50);
				int y2= 300-(int)(tempSemaineVal[i+1]*10);
				//System.out.println("x1 "+x1+" y1 "+y1+" x2 "+x2+" y2 "+y2);
				g.drawLine(x1,y1,x2,y2);
			}
		}
	}
}
