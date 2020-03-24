public class TestRobot {
  public static void main(String[] args) {
    Perceuse p1 = new Perceuse(52679, "Bosh", 22);
    Perceuse p2 = new Perceuse(82145, "Makita", 50);
    Marteau m1 = new Marteau(2145, "Facom", 2);
    Marteau m2 = new Marteau(4503, "MOB", 3);
    Marteau m3 = new Marteau(4503, "MOB", 4);

    Outil[] i = {p1,p2,m1,null};
    Robot r1 = new Robot(2,i);
    Robot r2 = new Robot(r1);
    //System.out.println(r2);
    //r2.ajoute(m2);
    //System.out.println(r2);
    //System.out.println(r2.caseCouranteVide());
    try{
      r2.ajoute(m3);

    }
    catch(CaseException e){
      System.out.println(e.toString());
    }
    //System.out.println(r2);


}
}
