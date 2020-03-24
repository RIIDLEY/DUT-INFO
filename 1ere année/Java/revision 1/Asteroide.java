public class Asteroide{
  private String nom;
  private double masse;
  private double distance;

    public String toString(){
      return "nom : " + this.nom + " masse : " + this.masse + " distance : " + this.distance;
    }

    public Asteroide(){
    }

    public Asteroide(String nom, double masse, double distance){
      this.nom=nom;
      this.masse=masse;
      this.distance=distance;
    }

      public void setNom(String nouvNom){
        this.nom=nouvNom;
      }

      public String getNom(){
        return this.nom;
      }

      public void setMasse(double nouvMasse){
        this.masse=nouvMasse;
      }

      public double getMasse(){
        return this.masse;
      }

      public void setDistance(double nouvDistance){
        this.distance=nouvDistance;
      }

      public double getDistance(){
        return this.distance;
      }

      public void recopie(Asteroide a){
        a.nom= new String(a.nom);
        a.masse=this.masse;
        a.distance=this.distance;
      }

      public void replique(Asteroide a){
        a.nom=new String(this.nom);
        a.masse=this.masse;
        a.distance=this.distance;
      }

      public Asteroide exploser(){
        double masse;
        Asteroide a1 = new Asteroide();
        a1.nom =  "_E_" + this.nom;
        masse=this.masse;
        this.masse = masse * 3/4;
        a1.masse = masse / 4;
        a1.distance = this.distance;
        return a1;
      }

      public void deplace(float d){
        this.distance= this.distance + d;
      }








}
