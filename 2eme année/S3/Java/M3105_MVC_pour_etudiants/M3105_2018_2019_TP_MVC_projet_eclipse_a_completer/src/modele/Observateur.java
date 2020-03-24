package modele;


/**
 * Interface que doivent implémentées les sujets de ModeleMorpion
 * @author B. LEMAIRE
 * @version  2019-2020
 */
public interface Observateur 
{
	/**
	 * Opération de notification Modèle vers Observateur
	 */
	public abstract void actualiser() ;

}
