public class Test{
  public static void main(String[] args) {
    Carte a = new Carte(12,"carreau");
    Carte b = new Carte(12,"trefle");
    PaquetCartesListe c = new PaquetCartesListe();

    c.getArraylist().add(a);
    c.getArraylist().add(b);
    System.out.println(a.compareTo(b));

    System.out.println(c.nbCartes());
    
    try{
      System.out.println(c.regarderCarteDessous());
    }
    catch (Exception e) {
      System.out.println(e.toString());
    }

  }
}
