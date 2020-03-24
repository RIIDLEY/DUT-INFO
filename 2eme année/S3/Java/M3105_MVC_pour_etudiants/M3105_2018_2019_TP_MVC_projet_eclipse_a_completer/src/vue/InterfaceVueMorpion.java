package vue;

/**
 * Interface que doivent implémentées les vues de l'application Morpion
 * @version  2019-2020
 */
public interface InterfaceVueMorpion
{
	
	/**
	 * Active la vue
	 */
	public abstract void activerVue() ;
	

	/**
	 * Affiche le joueur actif
	 */
	public void afficherJoueurActif();
	

	/**
	 * Affiche le coup qui vient d'être joué
	 */
	public abstract void afficherCoupJoue() ;
	
	/**
	 * affiche la grille actuelle 
	 */
	public abstract void afficherGrille() ;
	
	/**
	 * Intéraction pour la saisie de la ligne
	 */
	public abstract int saisirLigne()  ;
	
	/**
	 * Intéraction pour la saisie de la colonne
	 */
	public abstract int saisirColonne() ;
	

	/**
	 * La vue demande au contrôleur de gerer la saisie d'un coup
	 */
	public void saisirCoup();
	
	/**
	 * Affiche les informations concernant le coup erroné
	 */
	public abstract void afficherErreurCoupPropose() ;
	
	/**
	 * Affiche les inforamtion de fin de partie
	 */
	public abstract void afficherFinPartie() ;
	
	
}