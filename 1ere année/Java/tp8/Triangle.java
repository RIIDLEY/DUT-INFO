import java.util.ArrayList;

public class Triangle extends Polygone {
	public Triangle () {
		super();
	}
	
	public Triangle (String nom) {
		this(nom, new ArrayList<PointPlan>(3));
	}
	
	public Triangle(String nom, PointPlan[] tab){
		this(nom, new ArrayList<PointPlan>(3));
		for (int i=0 ; i<3 ; i++)
			if (i<tab.length)
				this.ajouter(tab[i]);
	}
	
	public Triangle(String nom, ArrayList<PointPlan> al){
		super(nom, al);	
	}
	
	public void ajouter(PointPlan p){
		if (this.nbPoints()<3)
			super.ajouter(p);
		else
			System.out.println("Erreur");
	}
	
	public String toString () {
		String s = "Triangle " + getNom() + " ; " + this.nbPoints()+" ; ";
		for (int i = 0; i < this.nbPoints(); i++)
			s = s + getPoint(i).toString();
		return s;
	}
}
