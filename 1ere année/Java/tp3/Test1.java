public class Test1{
  public static void main(String[] args) {
    Ampoule  a1 = new Ampoule(500,3500);
    Timer a2 = new Timer(500);
    Spot a3= new Spot(a1,a2);
    a3.allumer1();
  }

}
