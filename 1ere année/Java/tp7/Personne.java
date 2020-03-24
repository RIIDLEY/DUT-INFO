public class Personne{

  private String nom;
  private int age;

  public Personne(String unNom, int unAge){
    this.nom = unNom;
    this.age = unAge;
  }

  public  boolean equals(Personne p){
    return (this.nom.equals(p.nom) && this.age==p.age);
  }
}
