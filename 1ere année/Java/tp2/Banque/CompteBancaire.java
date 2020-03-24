public class CompteBancaire{ //Variable d'instance
  private String nom;
  private String numero;
  private float solde;

  public CompteBancaire(String nomProprio, String noCompte, float depot) {//Constructeur
    this.nom=nomProprio;
    this.numero=noCompte;
    this.solde=depot;
  }

  public CompteBancaire(String nomProprio, String noCompte) {//Constructeur
    this.nom=nomProprio;
    this.numero=noCompte;
  }

  public void setNom(String nouvNom){
    this.nom=nouvNom;
  }

  public void setSolde(float nouvSolde){
    this.solde=nouvSolde;
  }

  public String getNom(){
    return this.nom;
  }

  public  String getNumero(){
    return this.numero;
  }

  public  float getSolde(){
    return this.solde;
  }

//public void afficher(){//Méthode(fonction)
//  System.out.println("proprio :"+this.nom+"numéro :"+this.numero+"solde :"+this.solde);
//}

  public float vider(){//Méthode(fonction)
    float montant = this.solde;
    this.solde=0;
    return montant;
  }

  public String toString(){
    return "proprio : " + this.nom + "\nnuméro :" + this.numero +
           "\nsolde :" + this.solde ;
  }
  public  boolean meme(CompteBancaire c){
    return this.nom.equals(c.nom);
}
  public float ajout(float montant){
    return this.solde += montant;
  }

  public float retire(float montant){
    return this.solde -= montant;
  }

  public void transfer(CompteBancaire c, float montant){
    if(this.meme(c)){
      c.ajout(montant);
      this.retire(montant);
    }
    else{
      System.out.println("Refuse");
    }

  }

  public float convertitSolde(float c){
    return this.solde*c;

  }


}
