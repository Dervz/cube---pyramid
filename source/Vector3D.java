package computerdesignlab1;

public class Vector3D implements Cloneable {

    public double x, y, z, norm, dot, a, b, c;
    public String anotherMessage;

    public Vector3D(double X, double Y, double Z) {
        x = X;
        y = Y;
        z = Z;
    }

    public double L2norm(Vector3D pav) {

        norm = Math.sqrt(pav.x * pav.x + pav.y * pav.y + pav.z * pav.z);
        return norm;
    }

    public double dotProduct(Vector3D v) {

        dot = v.x * x + v.y * y + v.z * z;
        return dot;
    }

    public Vector3D crossProduct(Vector3D v2) {

        a = y * v2.z - z * v2.y;
        b = z * v2.x - x * v2.z;
        c = x * v2.y - y * v2.x;

        Vector3D v3 = new Vector3D(a, b, c);
        return v3;
    }

    public void normalize(Vector3D normalVector, String name) {

        normalVector.x = normalVector.x / L2norm(normalVector);
        normalVector.y = normalVector.y / L2norm(normalVector);
        normalVector.z = normalVector.y / L2norm(normalVector);

        System.out.println("The normalized vector " + name + " is " + normalVector.x + " ," + normalVector.y + " ," + normalVector.z + ".");
    }
    
    
     public Vector3D transform(Matrix matrix) {
          
        double d = x * matrix.m[0][0] + y * matrix.m[0][1] + z * matrix.m[0][2] + matrix.m[0][3];
        
        double d2 = x * matrix.m[1][0] + y * matrix.m[1][1] + z * matrix.m[1][2] + matrix.m[1][3];
        
        double d3 = x * matrix.m[2][0] + y * matrix.m[2][1] + z * matrix.m[2][2] + matrix.m[2][3];
        
        double d4 = x * matrix.m[3][0] + y * matrix.m[3][1] + z * matrix.m[3][2] + matrix.m[3][3];
        
        this.x = d / d4;
        this.y = d2 / d4;
        this.z = d3 / d4;
        
        Vector3D vvv = new Vector3D (x,y,z);
        return vvv;
    }
    
    

    public String toString(String name) {

        anotherMessage = "The norm of the vector " + name + " is " + norm + ".";

        if (name != "v") {
            anotherMessage += ("\nThe dot product of the vectors is " + dot + ".");
            anotherMessage += ("\nThe cross product of vectors v and v2 is vector v3(" + a + ", " + b + " ," + c + ").");

        }

        return anotherMessage;

    }

}
