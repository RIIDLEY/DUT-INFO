import java.util.*;

public class PointPlan {
	
	private float abscisse;
	private float ordonnee;
	
	public PointPlan() {
		this.abscisse = 0 ;
		this.ordonnee = 0 ;
	}

	public PointPlan(float x, float y) {
		this.abscisse = x ;
		this.ordonnee = y ;
	}

	public PointPlan(PointPlan p) {
		this.abscisse = p.getAbscisse() ;
		this.ordonnee = p.getOrdonnee() ;
	}
	
	public float getAbscisse() {
		return this.abscisse;
	}

	public float getOrdonnee() {
		return this.ordonnee;
	}
	
	public PointPlan inverser() {
		PointPlan p = new PointPlan(this.getOrdonnee(),
									this.getAbscisse()) ;
		return p ;
	}

	public boolean egaleA (PointPlan p) {
		return (this.getAbscisse() == p.getAbscisse() 
				&& this.getOrdonnee() ==  p.getOrdonnee()) ;
	}
	
	public void translater(float dx, float dy) 
	{
		this.abscisse = this.getAbscisse() + dx ;
		this.ordonnee = this.getOrdonnee() + dy ;
	}
	
	public double distance() 
	{
		return Math.sqrt(this.getAbscisse() * this.getAbscisse() +
		                 this.getOrdonnee() * this.getOrdonnee()) ;
	}

	public String toString() {
		return "(" + this.getAbscisse() + "," + this.getOrdonnee() + ")";
	}
	
	public void initRandom() {
		Random rand = new Random() ;
		abscisse = rand.nextInt(100)/10f;
		ordonnee = rand.nextInt(100)/10f;
	}
	
	public void initScanner() {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Abscisse ? ") ;
		this.abscisse = input.nextInt();
		System.out.print("Ordonnée ? ") ;
		this.ordonnee = input.nextInt();
	}
}
