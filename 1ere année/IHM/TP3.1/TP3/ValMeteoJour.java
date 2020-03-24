public class ValMeteoJour {
	private String jour;
	private float temp;
	private float prec;

	public ValMeteoJour(){
	}

	public ValMeteoJour(String jour, float temp, float prec) {
		this.jour = jour;
		this.temp = temp;
		this.prec = prec;
	}

	public ValMeteoJour(ValMeteoJour v) {
		this.jour = new String(v.getJour());
		this.temp = v.getTemp();
		this.prec = v.getPrec();
	}

	public String getJour() {
		return jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}

	public float getTemp() {
		return temp;
	}
	public void setTemp(float temp) {
		this.temp = temp;
	}
	public float getPrec() {
		return prec;
	}
	public void setPrec(float prec) {
		this.prec = prec;
	}

	public boolean equals(Object o) {
    ValMeteoJour v = (ValMeteoJour)o;
		if (this.jour.equals(v.getJour())) {
			if (this.temp == v.getTemp()) {
				if (this.prec == v.getPrec()) {
					return true;
				}
			}
		}
		return false;
  }

	public String toString() {
		return "[jour = " + jour + ",temp = " + temp + ",prec = " + prec + "]";
	}
}
