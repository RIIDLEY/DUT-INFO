public class Test{
public static void main(String[] args) {

  Personne p1 = new Personne("Toto",30);
  Object p2 = new Personne("Toto",30);

  if(p1.equals(p2))
      System.out.println("EGALES");
    else
      System.out.println("DIFFERENTES");

}
}
