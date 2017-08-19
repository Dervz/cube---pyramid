package computerdesignlab1;

public class Camera {

    private double xmin, xmax, ymin, ymax;
    private double fcp, bcp;  //NOT USED: front & back clippling planes
    private double ax, bx, ay, by;

    public Camera(double xmin_, double xmax_, double ymin_, double ymax_) {
        xmin = xmin_;
        xmax = xmax_;
        ymin = ymin_;
        ymax = ymax_;
    }

    //*calculate ax, bx, ay, by*
    //if (x,y) is a point on the view plane, and (x',y') the corresponding point on the screen
    //then x' = aX + bX*x, and y' = aY + bY*y
    public void setViewport(int width, int height) {

        //setting dWx and dWy
        double dWx = this.xmax - this.xmin;
        double dWy = this.ymax - this.ymin;

        //ax, ay, bx, by are used in viewport transformation
        this.bx = ((double) width) / dWx;
        this.by = ((double) height) / dWy;
        this.ax = -(bx * xmin);
        this.ay = -(by * ymin);

    }

    /*return a vector that points towards the viewer. Used for face orientation*/
    public Vector3D getVPN() {
        //the vector that points towards the user 
        return new Vector3D(0, 0, 1);
    }

    protected Point3D cameraTransform(final Point3D p) {

        return p;
    }

    protected Point3D projectionTransform(final Point3D p) {

        return p;
    }

    private final Point3D viewportTransform(final Point3D p) {
        double x_ = ax + bx * p.x;
        double y_ = ay + by * p.y;
        return new Point3D(x_, y_, 0);

    }

    public final Point3D project(final Point3D p) {
        Point3D projectionPoint = cameraTransform(p);
        projectionPoint = projectionTransform(projectionPoint);
        return viewportTransform(projectionPoint);
    }

    public String toString() {
        return "OMG THIS IS HARD COURSEWORK TBH";
        /* Make it look nice to save your debugging time! */
    }

}
