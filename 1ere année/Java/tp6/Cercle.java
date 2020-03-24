public class Cercle extends Figure {


	private float rayon ;

	public Cercle (PointPlan centre, float rayon, int niveau) {
		super.setNiveauGris(niveau);
		this.rayon = rayon ;
		super.setCentre(centre);
	}

	public float getRayon() {
		return rayon;
	}

	public void setRayon(float rayon) {
		this.rayon = rayon;
	}

	public String toString() {
		return "Cercle [rayon=" + this.rayon
				+ ", centre=" + super.getCentre()
				+ ", niveauGris=" + super.getNiveauGris() + "]";
	}

	public void translater(float dx, float dy) {
		PointPlan c1 = super.getCentre();
		c1.translater(dx,dy);
	}
}
