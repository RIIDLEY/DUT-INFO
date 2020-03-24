public class Losange extends Polygone {

	int nbSommets ;
	private PointPlan p1;
	private PointPlan p2;

	public Losange(PointPlan centre, float diagonale, int niveau,int nbSommets) {
		super.setNiveauGris(niveau);
		super.setNbSommets(nbSommets);
		this.p1 = new PointPlan(centre.getAbscisse()-diagonale/2,
								centre.getOrdonnee()) ;
		this.p2 = new PointPlan(centre.getAbscisse()+diagonale/2,
								centre.getOrdonnee()) ;
	}

	public void translater(float dx, float dy) {
		p1.translater(dx,dy);
		p2.translater(dx,dy);
	}

	public String toString() {
		return "Losange [s1=" + p1 + ", s2=" + p2
				+ ", niveauGris=" + super.getNiveauGris() + "]";
	}
}
