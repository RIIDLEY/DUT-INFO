public class Figure{
  private int niveauGris;
	private PointPlan centre ;
  
  public boolean estGris(){
    return (this.niveauGris<32 && (niveauGris>=224)) ;
  }

  public int getNiveauGris() {
    return niveauGris;
  }

  public void setNiveauGris(int niveauGris) {
		this.niveauGris = niveauGris;
	}

  public PointPlan getCentre() {
		return centre;
	}

	public void setCentre(PointPlan centre) {
		this.centre = centre;
	}




}
