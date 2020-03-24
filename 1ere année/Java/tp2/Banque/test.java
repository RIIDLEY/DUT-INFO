
public class test{
  public static void main(String[] args) {//Main(code qui s'exucute)
      CompteBancaire c1 = new CompteBancaire("toto","123456F",100f);
      CompteBancaire c2 = new CompteBancaire("Gayral","564320G");
      float solde1 = c1.vider();
      float solde2 = c2.vider();
      //System.out.println("Solde de c1 était "+solde1+", de c2 "+solde2);
      System.out.println(c1.toString());
  }
}
