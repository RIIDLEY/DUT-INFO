import java.util.ArrayList;

/**
 *  utilisation de classes existantes : pour le Tp sur les listes
 *  @author Françoise GAYRAL
 */

public class TestBanque
{
  public static void main(String[] args)	{
  AgenceBancaire ab = new AgenceBancaire("BNP","Villetaneuse");
	CompteBancaire cb1 = new CompteBancaire("titi",111f,"15478F");
  CompteBancaire cb2 = new CompteBancaire("toto",222f,"48641D");
  CompteBancaire cb3 = new CompteBancaire("tata",333f,"7846K");
  CompteBancaire cb4 = new CompteBancaire("tutu",444f,"784G");
  ab.add(cb1);
  ab.add(cb2);
  ab.add(cb3);
  ab.add(cb4);
  System.out.println(ab.comptePersonneExiste("titi"));
   }	// fin du main
}// fin de la classe TestBanque
