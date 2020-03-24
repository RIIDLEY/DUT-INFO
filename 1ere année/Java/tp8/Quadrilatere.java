import java.util.ArrayList;

public class Quadrilatere extends Polygone {
	public Quadrilatere () {
		super();
	}
	
	public Quadrilatere (String nom) {
		this(nom, new ArrayList<PointPlan>(4));
	}
	
	public Quadrilatere(String nom, PointPlan[] tab){
		this(nom, new ArrayList<PointPlan>(3));
		for (int i=0 ; i<3 ; i++)
			if (i<tab.length)
				this.ajouter(tab[i]);
	}
	
	public Quadrilatere(String nom, ArrayList<PointPlan> al){
		super(nom, new ArrayList<PointPlan>(3));	
	}
	
	public void ajouter(PointPlan p){
		if (this.nbPoints()<4)
			super.ajouter(p);
		else
			System.out.println("Erreur");
	}
	
	public String toString () {
		String s = "Quadrilatere " + getNom() + " ; " + this.nbPoints()+" ; ";
		for (int i = 0; i < this.nbPoints(); i++)
			s = s + getPoint(i).toString();
		return s;
	}
}
