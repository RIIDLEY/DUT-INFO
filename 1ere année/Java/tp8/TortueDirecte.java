public class TortueDirecte extends TortueGeniale{

    private double x;
    private double y;
    private double angle;


    public TortueDirecte(){
    }

    public TortueDirecte(double x, double y, double angle){
      this.x = x;
      this.y = y;
      this.angle = angle;
    }

  public void AllerEn(double x2, double y2){
    double x1 = this.getX();
    double y1 = this.getY();
    double distance = Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
    double angle = Math.toDegrees(Math.atan2(y2-y1,x2-x1))-this.getAngle();
    
    if( y1 < y2){
      this.tournerDroite(angle);
    }
    else{
      this.tournerGauche(angle);
    }

    this.avancer(distance);
  }
}
