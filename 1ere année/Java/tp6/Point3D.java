public class Point3D extends PointPlan
{
    private float azimut  ;

    public Point3D() {
        super() ;
    }


 public Point3D(float x, float y, float z) {
        super(x,y);
        this.azimut   = z ;
    }


 public Point3D(Point3D p) {
        super(p);
        this.azimut = p.azimut ;
    }



    public float getAzimut() {
        return this.azimut ;
    }
}
