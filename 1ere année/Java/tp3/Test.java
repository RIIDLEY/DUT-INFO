public class Test{

  public static void main(String[] args){
    Ampoule  a1 = new Ampoule(500,3500);
    Ampoule  a2 = new Ampoule(1000,5000);
    System.out.println(a1);
    System.out.println(a2);
    //a1.allumer();
    //a2.eteindre();
    int i=0;
    while (i<10){
      a1.allumer();
      i++;
    }
  }

}
