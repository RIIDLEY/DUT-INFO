public class Chat extends Animal{

  private int nbMoustache;

  public Chat(int nbMoustache){
    this.nbMoustache = nbMoustache;
  }

  public void crier(){
    System.out.println("Je miaule");
  }
  public void manger(){
    System.out.println("Je lappe");
  }

}
