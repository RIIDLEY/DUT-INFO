/**Fichier AgenceBancaire.java
* utilisation de classe Java ArrayList
*/
   import java.util.*;

   public class AgenceBancaire {
      private String nomAgence; 	//nom de l'agence
      private String ville; //adresse de l'agence

      private ArrayList<CompteBancaire> ensComptesBancaires; // ensembles des comptes bancaires de l'agence


   /**
   * Constructeur
   */

      public AgenceBancaire(String nom,String adresse){
          this.nomAgence = nom;
          this.ville = adresse;
          this.ensComptesBancaires = new ArrayList<CompteBancaire>();
      }



   /* pour affichage ***************************************************/

       public String toString() {
         return "ville :" + this.ville + " nom Agence : " + this.nomAgence + " liste compte : " + this.ensComptesBancaires ;
	}

   /* Gestion des comptes *****************************************/
   public void add(CompteBancaire cb)  {
     if (!compteExiste(cb)) {
        this.ensComptesBancaires.add(cb);
     }

	}


      public boolean compteExiste(CompteBancaire cb)  {
        for (int i = 0; i<this.ensComptesBancaires.size() ; i++ ) {
          if (cb.equals(this.ensComptesBancaires.get(i))){

            return true;
          }
        }
        return false;
      }

      public ArrayList<CompteBancaire> lesComptesDe(String nom)  {
        return null ;

      }

public boolean comptePersonneExiste(String nom){
    for (int i = 0; i<this.ensComptesBancaires.size() ; i++ ){
      CompteBancaire Compte = this.ensComptesBancaires.get(i);
      if(nom.equals(Compte.getNom())){
        return true;
      }
    }
  return false;
}

   //test de la classe************


   }//fin classe
