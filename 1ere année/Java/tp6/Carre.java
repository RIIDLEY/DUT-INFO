public class Carre extends Polygone {


	int nbSommets ;
	private PointPlan centre;
	private float cote;

	public Carre(PointPlan centre, float cote, int niveau, int nbSommets) {
		super.setNiveauGris(niveau);
		super.setNbSommets(nbSommets);
		super.setCentre(centre);
		this.cote = cote ;
	}

	public void translater(float dx, float dy) {
		PointPlan c1 = super.getCentre();
		c1.translater(dx,dy);

	}

	public String toString() {
		PointPlan c1 = super.getCentre();
		PointPlan p1 = new PointPlan(c1.getAbscisse()-this.cote/2,
				c1.getOrdonnee()-this.cote/2) ;
		PointPlan p2 = new PointPlan(c1.getAbscisse()+this.cote/2,
				c1.getOrdonnee()+this.cote/2) ;
		return "Carre [s1=" + p1.toString()
				+ ", s2=" + p2.toString()
				+ ", niveauGris=" + super.getNiveauGris() + "]";
	}
}
