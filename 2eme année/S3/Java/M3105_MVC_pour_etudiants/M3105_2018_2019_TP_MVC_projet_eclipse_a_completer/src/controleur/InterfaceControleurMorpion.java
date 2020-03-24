package controleur;

import vue.InterfaceVueMorpion;

/**
 * @author B. LEMAIRE
 * @version 2019-2020
 * Contrôleur pour l'application Morpion
 */
public interface InterfaceControleurMorpion 
{
	/**
	 * Gère l'interaction pour jouer un coup
	 */
	public abstract void gererSaisirCoup() ;


	/**
	 * Lie le contrôleur avec la vue dont il doit gérer les intéractions
	 * @param uneVue : (InterfaceVueMorpion) référence de la vue qui doit
	 * <BR/> être gérée par le contrôleur
	 */
	public abstract void setVue(InterfaceVueMorpion uneVue) ;	
}
