public class Test{
  public static void main(String[] args) {
    AgenceBancaire a = new AgenceBancaire("lcl","paris");
    System.out.println(a);
    CompteBancaire b = new CompteBancaire("robert",100f,"12456H");
    a.add(b);
    System.out.println(a);
  }
}
