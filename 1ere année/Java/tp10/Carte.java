import java.util.Scanner ;

/**
 *  gestion d'une Carte
 *  @version 1.0
 *  @author Dominique BOUTHINON
 */

public class Carte implements DonneesCarte, Comparable
{

	// VARIABLES MEMBRES ========================================================

	private int    valeur  ;
	private String couleur ;


	// CONSTRUCTEUR =============================================================

	/**
	 *  Contructeur vide
	 */
	 public Carte()
	 {
	 }


	/**
	 *  Initialise la Carte courante
	 */
	 public Carte(int uneValeur, String uneCouleur)
	 {
	 	this.valeur  = uneValeur  ;
	 	this.couleur = uneCouleur ;
	 }


	/**
	 *  Constructeur par copie
	 */
	 public Carte(Carte c)
	 {
	 	this.valeur  = c.valeur   ;
	 	this.couleur = new String(c.couleur) ;
	 }


	// METHODES D'ACCES =========================================================


	/**
	 *  retourne la valeur de la carte courante
	 */
   public int getValeur()
	{
		return this.valeur;
	}
	// fin methode getValeur


	/**
	 *  retourne la couleur de la carte courante
	 */
   public String getCouleur()
	{
		return this.couleur;
	}
	// fin methode getCouleur



	// METHODES UTILITAIRES =====================================================


	/**
	 *  retourne la chaine de caracteres representant la carte courante
	 */
	public String toString()
	{
		return this.libelle() + " de " + this.couleur ;
	}
	// fin methode toSting


	/**
	 *  initialise la carte courante
	 */
	public void init()
	{
		Scanner sc = new Scanner(System.in) ;

		do
		{
			System.out.println("valeur ? ") ;
			this.valeur = sc.nextInt() ;
		}
		while (!Carte.valeurOk(this.valeur)) ;


		do
		{
			System.out.println("couleur ? ") ;
			this.couleur = sc.next() ;
		}
		while (!Carte.couleurOk(this.couleur)) ;

	}
	// fin methode init


	/**
	 *  retourne true si la Carte referencee par o est egale a la Carte courante
	 */
	public boolean equals(Object o)
	{
		if (o == null)
		   return false ;

		if (!(o instanceof Carte))
		   return false ;

		Carte c = (Carte) o ;

		return (
			     this.valeur == c.valeur &&
		         this.couleur.equals(c.couleur)
				 ) ;
	}
	// fin methode toSting


	/**
	 *  retourne -1, 0 ou 1 selon que la Carte courante est inferieur, egale,
	 *  ou superieure a la carte referencee par o
	 */
	public int compareTo(Object o)
	{
    Carte c = (Carte) o;
    if (this.getValeur()>c.getValeur()) {
        return 1;
    }
    if (this.getValeur()<c.getValeur()) {
        return -1;
    }

    if (this.indiceCouleur()<c.indiceCouleur()) {
      return -1;
    }
    if (this.indiceCouleur()>c.indiceCouleur()) {
      return 1;
    }
    return 0;
	}
	// fin methode toSting


	// METHODES PRIVEES =========================================================

	/**
	 *  retourne le libelle correspondant a chaque valeur
	 */
	private String libelle()
	{
	  return DonneesCarte.LIBELLES[this.indiceValeur()];
	}
	// fin methode libelle



	/**
	 *  retourne l'indice de la couleur de la Carte courante
	 *  dans le tableau COULEURS
	 */
	private int indiceCouleur()
	{
		int i = 0 ;

		while (!this.couleur.equals(DonneesCarte.COULEURS[i]))
		       i++ ;

		// couleur etant necessaire valide elle est toujours trouvee :

		return i ;
	}
	// fin methode indiceCouleur


	 /**
	 *  retourne l'indice de valeur de la Carte courante
	 *  dans le tableau VALEURES
	 */
	private int indiceValeur()
	{
		int i = 0 ;

		while (this.valeur != DonneesCarte.VALEURS[i])
		       i++ ;

		// valide etant necessaire valide elle est toujours trouvee :

		return i ;
	}
	// fin methode indiceValeur


	/**
	 *  retourne true si la valeur de la carte est valide
	 */
	private static boolean valeurOk(int uneValeur)
	{
		int n = DonneesCarte.NB_VALEURS ;

		return (DonneesCarte.VALEURS[0] <= uneValeur &&
		        uneValeur <= DonneesCarte.VALEURS[n-1]) ;
	}


	/**
	 *  retourne true si la couleur de la carte est valide
	 */
	private static boolean couleurOk(String uneCouleur)
	{
		int n = DonneesCarte.NB_COULEURS ;

		int i = 0 ;
		while (i < n && !uneCouleur.equals(DonneesCarte.COULEURS[i]))
		      i++ ;

		return (i < n) ;
	}

}
// fin classe Carte
