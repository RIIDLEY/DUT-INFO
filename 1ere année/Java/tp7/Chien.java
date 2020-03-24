public class Chien extends Animal{

  private boolean aboieFort;

  public Chien(boolean aboieFort){
    this.aboieFort=aboieFort;
  }
  public void crier(){
    System.out.println("J'aboie fort : " + this.aboieFort);
  }
  public void manger(){
    System.out.println("Je dévore");
  }


}
