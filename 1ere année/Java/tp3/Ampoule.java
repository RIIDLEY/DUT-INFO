public class Ampoule{
  private int couleur;
  private int puissance;

  public String toString(){
    return "couleur :" + this.couleur + " puissance :" + this.puissance;
  }

  public Ampoule(){
  }

  public Ampoule(int couleur, int puissance){
    this.couleur=couleur;
    this.puissance=puissance;
  }

  public void allumer(){
    System.out.println("Allumer +"+this.couleur+" à "+this.puissance);

  }

  public void eteindre(){
    System.out.println("Eteindre -"+this.couleur+" à "+this.puissance);
  }

}
