import java.util.*;

public class Polygone
{
	private ArrayList<PointPlan> points;
	private String nom;
	
	public Polygone () {
		nom = "" ;
		this.points  = new ArrayList<PointPlan>() ;	
	}
	
	public Polygone (String nom) {
		this.nom = nom;
		this.points  = new ArrayList<PointPlan>() ;	
	}
	
	protected Polygone(String nom, PointPlan[] tab){
		this.points  = new ArrayList<PointPlan>(Arrays.asList(tab)) ;	
		this.nom = nom;
	}
	
	protected Polygone(String nom, ArrayList<PointPlan> al){
		this.points  = al ;	
		this.nom = nom;		
	}

	public Polygone (Polygone p)
	{ 
		this.points = new ArrayList<PointPlan>();
		this.nom = p.nom;
		for (int i = 0; i <p.nbPoints(); i++)
			this.points.add(new PointPlan(p.getPoint(i)));
	}
	
	public PointPlan getPoint (int i) {
		return this.points.get(i);
	}
	
	public int nbPoints() {
		return this.points.size();
	}

	public String getNom(){
		return this.nom;
	}
	
	public void setNom(String nom)	{
		this.nom = nom;
	} 

	public void setPoint(int pos, PointPlan p)	{
		this.points.set(pos, p); 
	}
	
	// à redéfinir
	public void ajouter(PointPlan p) {
		this.points.add(p);
	}
	
	// à redéfinir
	public void inserer(PointPlan p, int pos) {
		if (pos<=points.size())
			this.points.add(pos,p);
		else
			System.out.println("Erreur dans this.inserer()");
	}
	
	// SERVICES
	
	// avec un iterateur
	public void translater (float dx, float dy) {
		ListIterator<PointPlan> i = points.listIterator();
		while (i.hasNext()) {
			i.next().translater(dx,dy);
		}
	}
	
	public Polygone creerTranslater(float dx, float dy) {
		Polygone p = new Polygone(this) ;
		p.translater(dx,dy);
		return p;
	}

	public String toString () {
		String s = nom + " ; " + this.nbPoints()+" ; ";
		for (int i = 0; i < this.nbPoints(); i++)
			s = s + getPoint(i).toString();
		return s;
	}
	
	public void ajouterRandom (int n) {
		for (int i=0 ; i<n ; i++) {
			PointPlan nouveau = new PointPlan();
			nouveau.initRandom();
			this.ajouter(nouveau);
		}
	}

	public static void main (String args [])	{
		Polygone poly = new Polygone("poly");
		
		poly.ajouterRandom(8);
		System.out.println(poly.toString());
		
		poly.inserer(new PointPlan(20,20),3);
		System.out.println(poly.toString());
		
		poly.inserer(new PointPlan(30,30),12);	// ne fonctionne pas
		System.out.println(poly.toString());
		
		poly.inserer(new PointPlan(30,30),9);
		System.out.println(poly.toString());
		
		poly.ajouter(new PointPlan(40,40));
		System.out.println(poly.toString());
		
		poly.inserer(new PointPlan(50,50),3);
		System.out.println(poly.toString());
		
		/* doit donner quelque chose comme :
		
		poly ; 8 ; (1.7,1.4)(7.1,7.7)(8.4,0.9)(0.9,8.7)(4.8,5.3)(2.1,7.1)(4.9,1.9)(6.5,2.1)
		poly ; 9 ; (1.7,1.4)(7.1,7.7)(8.4,0.9)(20.0,20.0)(0.9,8.7)(4.8,5.3)(2.1,7.1)(4.9,1.9)(6.5,2.1)
		Erreur dans this.inserer()
		poly ; 9 ; (1.7,1.4)(7.1,7.7)(8.4,0.9)(20.0,20.0)(0.9,8.7)(4.8,5.3)(2.1,7.1)(4.9,1.9)(6.5,2.1)
		poly ; 10 ; (1.7,1.4)(7.1,7.7)(8.4,0.9)(20.0,20.0)(0.9,8.7)(4.8,5.3)(2.1,7.1)(4.9,1.9)(6.5,2.1)(30.0,30.0)
		poly ; 11 ; (1.7,1.4)(7.1,7.7)(8.4,0.9)(20.0,20.0)(0.9,8.7)(4.8,5.3)(2.1,7.1)(4.9,1.9)(6.5,2.1)(30.0,30.0)(40.0,40.0)
		poly ; 12 ; (1.7,1.4)(7.1,7.7)(8.4,0.9)(50.0,50.0)(20.0,20.0)(0.9,8.7)(4.8,5.3)(2.1,7.1)(4.9,1.9)(6.5,2.1)(30.0,30.0)(40.0,40.0)
			 
		*/
	}
}