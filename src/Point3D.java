package computerdesignlab1;

import java.awt.Color;

/**
 *
 * @author Pavel Nevmovenko
 */

public class Point3D {

    public double x, y, z, distance;
    String message;
     Color color;
    public Point3D(double X, double Y, double Z) {
 
        x = X;
        y = Y;
        z = Z;
    }
    
    public void setColor(Color c){
    
    color = c;
    }

    public double distance(Point3D p2) {

        distance = Math.sqrt((x - p2.x) * (x - p2.x) + (y - p2.y) * (y - p2.y) + (z - p2.z) * (z - p2.z));
        return distance;
    }
    
    
     public Point3D transform(Matrix matrix) {
         
        double d = x * matrix.m[0][0] + y * matrix.m[0][1] + z * matrix.m[0][2] + matrix.m[0][3];
        
        double d2 = x * matrix.m[1][0] + y * matrix.m[1][1] + z * matrix.m[1][2] + matrix.m[1][3];
        
        double d3 = x * matrix.m[2][0] + y * matrix.m[2][1] + z * matrix.m[2][2] + matrix.m[2][3];
        
        double d4 = x * matrix.m[3][0] + y * matrix.m[3][1] + z * matrix.m[3][2] + matrix.m[3][3];
        
        this.x = d / d4;
        this.y = d2 / d4;
        this.z = d3 / d4;
        
        Point3D ppp = new Point3D (x,y,z);
        return ppp;
    }
    
    public Vector3D vector(Point3D p){
        
        double vectorX = x - p.x;
        double vectorY = y - p.y;
        double vectorZ = z - p.z;
        
        Vector3D betweenTwoPoints = new Vector3D(vectorX,vectorY,vectorZ);
        
    return betweenTwoPoints;
    }
    
        // TESTING NEEDED
        // TESTING NEEDED
    public static Vector3D faceNormal(Point3D p1, Point3D p2, Point3D p3){
    
        
        
        Vector3D v1 ; // TEST THIS LATER
        Vector3D v2 ; // TEST THIS 
        
        v1 = p2.vector(p1);
        v2 = p3.vector(p1);
        
        //System.out.println(v2.x + ", " + v2.y + ", " + v2.z);
        
        
        Vector3D FaceNormal;
        FaceNormal = v1.crossProduct(v2);
        
    return FaceNormal;
    }
    
    
    public static boolean isFrontFace(Point3D p1, Point3D p2, Point3D p3, Vector3D vpn){
        
        Vector3D v1 ; // TEST THIS LATER
        Vector3D v2 ; // TEST THIS 
        
        v1 = p2.vector(p1);
        v2 = p3.vector(p1);
        
        
        
        
        Vector3D FaceNormal;
        FaceNormal = v1.crossProduct(v2);
    
        if (vpn.dotProduct(FaceNormal) > 0 ){
        return true;
        }
        
        else {
        return false;
        }
   
    
    }
    
    
    @Override
    public String toString() {

        message = "The distance between points A and B is " + distance + ".";

        return message;

    }
    
    public void checkCoordinates(Point3D hello){
    String coord = "The coordinates of this point are " + hello.x + " " + hello.y +" " +  hello.z + " ";
    
    System.out.println(coord);
    
    }
    
}
