import java.util.* ;

/**
 * gestion d'un paquet de cartes
 *
 */

public class PaquetCartesListe implements PaquetCartes
{

	private ArrayList<Carte> cartes;

	/**
	 * initialise un paquet de cartes vide
	 */
	 public PaquetCartesListe()
	 {
     this.cartes = new ArrayList<Carte>();      // A COMPLETER
	 }
	 // fin constructeur PaquetCartesListe

   public boolean estVide(){
     return this.cartes.isEmpty();
   }

   public int nbCartes(){
     return this.cartes.size();
   }

   public ArrayList<Carte> getArraylist(){
     return this.cartes;
   }

   public void insererCarteDessous(Carte c){
     this.cartes.add(0,c);
   }

   public void insererCarteDessus(Carte c){
     this.cartes.add(c);
   }

   public Carte regarderCarteDessous() throws Exception{
     if (this.cartes.isEmpty()) {
       throw new Exception("pas de carte");
     }
     return this.cartes.get(this.cartes.size());
   }

	public String toString()
	{
		String a ="";
    for (int i=0;i<this.cartes.size() ;i++ ) {
      a=a+this.cartes.get(i);
    }
    return a;
	}
   // fin methode toString


	/**
	 * version toString avec for
	 */
	public String toString2()
	{

	 	return "" ; // A CHANGER
	}
   // fin methode toString



	/**
	 * melange le paquet de carte au hasard
	 */
 	public void melangerCartes()
 	{
 		int n = this.cartes.size() ;

 								 // cree generateur de nombres aleatoires
 		Random r = new Random() ;


		for (int i = 0 ; i < n ; i++)
	 	{
	 							// n-i places de i a n-1 sont a traiter
	 		int j = i + r.nextInt(n-i) ;

								// permute elements de positions i et j
			Carte c = this.cartes.set(i, this.cartes.get(j)) ;
			this.cartes.set(j,c) ;
	 	}

 	}
   // fin methode battre

	// Completer en implementant les methodes abstraites de PaquetCartes


} // fin class PaquetCartesListe
