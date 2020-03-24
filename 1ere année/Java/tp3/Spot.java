public class Spot{
  private Ampoule ampoule;
  private Timer timer;

    public Spot(){
    }

    public Spot(Ampoule ampoule, Timer timer){
      this.ampoule=ampoule;
      this.timer=timer;
    }
    public void allumer1(){
      this.ampoule.allumer();
    }


}
