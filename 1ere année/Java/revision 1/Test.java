public class Test{
  public static void main(String[] args) {
    Asteroide a1 = new Asteroide("Mathis",5,10);
    Asteroide a2 = new Asteroide();
    Asteroide a3 = new Asteroide();
    System.out.println(a1);
    //a1.recopie(a2);
    //System.out.println(a2);
    //a1.replique(a3);
    //System.out.println(a3);

    System.out.println(a1.exploser());
    System.out.println(a1);

  }

}
