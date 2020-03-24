/**
 * Canevas de classe de gestion d'un compte bancaire
 * @version de base donnée aux étudiants
 * @author Françoise Gayral
 */
public class CompteBancaire {

	/**
	 * Le nom du propriétaire du compte
	 */
	private String nom;
	/**
	 * Le solde du compte
	 */
	private float solde;
	/**
	 * Le numero du compte
	 */
	private String numero;

	/**
	 * Construit une instance de CompteBancaire avec les valeurs données en
	 * paramètre.
	 *
	 * @param nom
	 *            le nom du propriétaire
	 * @param solde
	 *            le solde du compte
	 * @param numero
	 *            le numero du compte
	 */
	public CompteBancaire(String nom, float solde, String numero) {
		this.nom = nom;
		this.solde = solde;
		this.numero = numero;
	}

	/**
	 * Construit une instance de CompteBancaire, le solde sera à 0.
	 *
	 * @param nom
	 *            le nom du propriétaire
	 * @param numero
	 *            le numero du compte
	 */
	public CompteBancaire(String nom, String numero) {
		this.nom = nom;
		this.solde = 0; // le solde sera affecté apres
		this.numero = numero;
	}

	public String toString() {
		return new String("Compte de nom : " + nom + " de solde : " + solde
				+ "  de numero : " + numero);
	}

	/**
	 * Retourne le nom du propriétaire
	 *
	 * @return le nom du propriétaire
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Retourne le numéro du compte
	 *
	 * @return le numéro du compte
	 */
	public String getNumero() {
		return this.numero;
	}

	/**
	 * Retourne le solde du compte
	 *
	 * @return le solde du compte
	 */
	public float getSolde() {
		return this.solde;
	}

	/**
	 * Remplace le nom du propriétaire du compte par n
	 *
	 * @param n
	 *            le nouveau nom du propriétaire
	 */
	public void setNom(String n) {
		this.nom = n;
	}

	/**
	 * Remplace le solde du compte par s
	 *
	 * @param s
	 *            le nouveau solde du compte
	 */
	public void setSolde(float s) {
		this.solde = s;
	}

	/**
	 * ajoute une somme au solde du compte courant si la somme est positive,
	 * sinon affiche un message d'erreur
	 *
	 * @param la somme à ajouter
	 * @return false si la somme est négative, true sinon
	 */
	public boolean ajouteSolde(float ajout) {
		if (ajout >= 0) {
			this.solde += ajout;
			return true;
		} else {
			System.out.println("votre ajout est negatif !!");
			return false;
		}
	}

	/**
	 * retire 'retrait' au solde si retrait est positif et si le compte a un solde suffisant, sinon affiche un
	 * message d'erreur
	 *
	 * @param retrait	la somme à retirer false sinon
	 */
	public boolean retireSolde(float retrait) {
		if (retrait >= 0 ) {
			if (this.solde >= retrait)	{
				this.solde = this.solde - retrait;
				return true;
				}
			else {	System.out.println("Pas assez d'argent sur le compte "+ this.solde+" pour retirer "+retrait);
				return false;
				}
		} else {
			System.out.println("votre retrait est negatif !");
			return false;
		}
	}
} // fin de la classe
