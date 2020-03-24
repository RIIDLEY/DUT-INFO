public class TestFigure{
  public static void main(String[] args) {
    PointPlan p1 = new PointPlan(2,1);
    Cercle c1 = new Cercle(p1,5,9);
    System.out.println(c1.getNiveauGris());
    System.out.println(c1.estGris());
    System.out.println(c1.getRayon());
    c1.setRayon(6);
    System.out.println(c1);
    c1.translater(1,1);
    System.out.println(c1);

    //Carre c2 = new Carre(p1,4,6,4);
    //System.out.println(c2);
    //c2.translater(1,1);
    //System.out.println(c2);

    //Losange l1 = new Losange(p1,4,5,4);
    //System.out.println(l1);
    //l1.translater(1,1);
    //System.out.println(l1);
  }
}
