public class Test{
  public static void main(String[] args) {
    boolean [] t1 = new boolean [5];
    boolean valeur = true;
      for (int i = 0;  i < t1.length  ; i++ ) {
        t1[i]=valeur;
        valeur=!valeur;
      }
      boolean [] t3 = new boolean [5];
      boolean valeur1 = false;
        for (int i = 0;  i < t3.length  ; i++ ) {
          t3[i]=valeur1;
          valeur1=!valeur1;
        }
TableauBooleans tb1 = new TableauBooleans(t1);

System.out.println(tb1);
System.out.println(tb1.taille());
TableauBooleans tb2 = new TableauBooleans(tb1);

TableauBooleans tb3 = new TableauBooleans(t3);
System.out.println(tb3);
System.out.println(tb3.et(tb1));









  }
}
