public class Robot {
  private int position;
  private Outil [] cases;

  public Robot() {

  }

  public Robot(int caseCourante, Outil[] cases) {
    this.position = caseCourante;
    this.cases = cases;
  }

  public Robot(Robot r) {
    this.position = r.position;
    this.cases = new Outil[r.cases.length];
    for(int i = 0; i < this.cases.length; i++) {
      this.cases[i] = this.copieOutil(r.cases[i]);
    }
  }

  public Robot(int k) {
    this.position = 0;
    this.cases = new Outil[k];
  }

  public Outil copieOutil(Outil o) {
    if(o instanceof Perceuse) {
      return new Perceuse((Perceuse)o);
    }

    if(o instanceof Marteau) {
      return new Marteau((Marteau)o);
    }

    if(o instanceof Outil) {
      return new Outil(o);
    }

    return null;
  }

  public void ajoute(Outil e) throws CaseException {
    if(this.cases[this.position] != null){
      throw new CaseException("case non vide",this.position,e);
    }
    this.cases[this.position]=e;
  }

  public boolean caseCouranteVide() {
    if(this.cases[this.position] == null) {
      return true;
    }
    return false;
  }

  public void deplacebras(int i) throws Exception {
    if(i<0 || i>this.cases.length ){
      throw new Exception("position :" +this.position);
    }
    this.position = i;
  }

  public void retire()  throws Exception {
    if(caseCouranteVide()){
      throw new Exception("case de rang"+ this.position +"est vide");
    }
    this.cases[this.position]=null;

  }

  public String toString() {
    String s;
    int i = 0;
    s =  "position : " + this.position + " \ntableau :\n[";
    while(i<cases.length-1) {
      s = s + "\n" + this.cases[i];
      i++;
    }
    s = s + "\n" + this.cases[i] + "\n]";
    return s;
  }
}
