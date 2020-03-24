public class CaseException extends Exception{

  private int position;
  private Outil outil;

  public CaseException(String message, int unePosition, Outil unOutil){
    super(message);
    this.position=unePosition;
    this.outil=unOutil;
  }
  public String toString(){
    return super.toString();
  }
}
