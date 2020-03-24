

import java.awt.Color;
import java.awt.Graphics;
 
import javax.swing.JPanel;
 
@SuppressWarnings("serial")
public class PanelGraphique extends JPanel {
	/*
	 * Pour dessiner, on aura besoin de deux tableaux:
	 *  un contient les précipitations.
	 *  un contient les températures.
	 */
	private float[] precSemaineVal;
	private float[] tempSemaineVal;
 
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
		
		// Tracage des axes.
		g.setColor(Color.BLACK);
		g.drawLine(0, 300, 400, 300);
		g.drawLine(10, 0, 10, 400);
		for (int i = 1; i <= 4; i++) {
			g.drawLine(10, i*100, 15, i*100);
		}
 
		// Affichage des précipitations: rectangles colorés.
		g.setColor(Color.BLUE);
		for (int i = 0; i < StationMeteoConstantes.joursSemaine.length; i++) {
			//décalé de 10 (axe) puis de 50 par valeur précédente.
			int x1 = 10+(i*65);
			int h  = (int)(precSemaineVal[i]*10);
			//largeur de 50 px
			int w  = 65;
			int y1 = 300-h;
			
			g.fillRect(x1, y1, w, h);
		}
 
		// Affichage de la température: courbe segmentée.
		g.setColor(Color.RED);
		for (int i = 0; i < StationMeteoConstantes.joursSemaine.length; i++) {
			if((i+1)<StationMeteoConstantes.joursSemaine.length){
				//décalé de 10 (axe) puis de 25 pour être au milieu du jour
				//puis de 50 par valeur précédente.
				int x1= 10+25+(i*65);
				int y1= 300-(int)(tempSemaineVal[i]*10);
				int x2= 10+25+((i+1)*65);
				int y2= 300-(int)(tempSemaineVal[i+1]*10);
				//System.out.println("x1 "+x1+" y1 "+y1+" x2 "+x2+" y2 "+y2);
				g.drawLine(x1,y1,x2,y2);
			}
		}
	}
}


