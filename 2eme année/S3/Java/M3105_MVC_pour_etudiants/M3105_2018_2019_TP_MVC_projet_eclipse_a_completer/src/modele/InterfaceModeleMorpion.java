package modele;

import classes_metiers.Coup;
import classes_metiers.Joueur;
import classes_metiers.Symbole;

/**
 * @author Dominique Bouthinon, révisé par B. LEMAIRE
 * 
 *
 */
public interface InterfaceModeleMorpion
{

	/**
	 * Retourne la grille de jeu
	 * @return : (Symbole[][]) grille de jeu de morpion
	 */
	public Symbole[][] getGrille() ;

	
	/**
	 * Joue le Coup proposé par le dernier joueur
	 * @param ligne : (int) ligne du dernier du coup joué
	 * @param colonne : (int) colonne du dernier coup joué 
	 * @throws Exception: coup non valide
	 */
	public void joueCoup(int ligne, int colonne) throws Exception ;


	
	/**
	 * Retourne le Coup qui vient d'etre joue 
	 * @return : (Coup) dernier coup qui a été joué
	 */
	public abstract Coup getCoupPropose();

	/**
	 * Retourne le joueur en cours (ROND ou CROIX)
	 * @return : (Joueur) Joueur actif
	 */
	public abstract Joueur getJoueurActif() ;


	/**
	 * Retourne si la partie est finie ou pas
	 * @return : (boolean) true si la partie est finie, false sinon
	 */
	public abstract boolean partieFinie() ;


	/**
	 *  Change de joueur actif
	 */
	public void changeJoueurActif();

	/**
	 * En tant qu'Observable
	 */

	/**
	 * Permet à un sujet de s'enregistrer auprès du modèle
	 */
	public abstract void enregistrerObservateur(Observateur o) ;

	/**
	 * Permet à un sujet de se désincrire auprès du modèle
	 */
	public abstract void notifierObservateurs() ;

	/**
	 * Notification d'un changement du modèle à tous ses sujets
	 */
	public abstract void supprimerObservateur(Observateur o)   ;


}
