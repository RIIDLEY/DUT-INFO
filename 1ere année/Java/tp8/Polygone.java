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
	
	public void ajouter(PointPlan p) {
		this.points.add(p);
	}
	
	public void inserer(PointPlan p, int pos) {
		if (pos<=points.size())
			this.points.add(pos,p);
		else
			System.out.println("Erreur dans this.inserer()");
	}
	
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
		String s = "Polygone " + nom + " ; " + this.nbPoints()+" ; ";
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
	
	public void afficher() {
		System.out.println(this.toString());
	}
}