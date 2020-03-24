package Test;

import classes_metiers.Coup;
import classes_metiers.Symbole;

/**
 * @author bouchaib.lemaire
 * version 2019-20120
 * Pour tester le modèle
 */


public abstract class TestModeleMorpion
{

	/**
	 * Affiche le coup qui vient d'être joué
	 */
	public static void afficherCoupJoue(Coup c)
	{

		System.out.println("Coup joue : ") ;
		System.out.println("ligne    = " + c.getLigne())   ;
		System.out.println("colonne  = " + c.getColonne()) ;
		System.out.println("valeur   = " + c.getSymbole()) ;
	}


	private static void afficherNumeroColonnes(Symbole grille[][])
	{
		System.out.print("   ") ;
		for(int colonne = 0 ; colonne <grille.length ; colonne++)
		{
			System.out.print(colonne + " ") ;
		}

		System.out.println("") ;
	}

	/**
	 * affiche la grille actuelle
	 */
	public static void afficherGrille(Symbole grille[][])
	{


		System.out.println("Grille courante : \n") ;

		TestModeleMorpion.afficherNumeroColonnes(grille) ;


		for (int ligne = 0 ; ligne < grille.length ; ligne++)
		{
			System.out.print(ligne + " ") ;

			for (int colonne = 0 ; colonne < grille[ligne].length ; colonne++)
			{
				System.out.print("|" + grille[ligne][colonne].getLibelle()) ;
			}

			System.out.println("|") ;
		}
	}

	public static void main(String[] args) 
	{
		

		
	}	

}
