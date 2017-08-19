package computerdesignlab1;

import javax.swing.JOptionPane;

/**
 *
 * @author Pavel Nevmovenko
 */
public class ComputerDesignLab1 {

    String Question;
    Double answer;

    public static void main(String[] args) {

        double x = Coordinates("A", "point", "X");
        double y = Coordinates("A", "point", "Y");
        double z = Coordinates("A", "point", "Z");

        double x2 = Coordinates("B", "point", "X");
        double y2 = Coordinates("B", "point", "Y");
        double z2 = Coordinates("B", "point", "Z");

        double a = Coordinates("v", "vector", "X");
        double b = Coordinates("v", "vector", "Y");
        double c = Coordinates("v", "vector", "Z");

        double a2 = Coordinates("v2", "vector", "X");
        double b2 = Coordinates("v2", "vector", "Y");
        double c2 = Coordinates("v2", "vector", "Z");

        Point3D p1 = new Point3D(x, y, z);
        Point3D p2 = new Point3D(x2, y2, z2);

        p1.distance(p2);
        
        System.out.println(p1.toString());

        Vector3D v = new Vector3D(a, b, c);
        Vector3D v2 = new Vector3D(a2, b2, c2);

        v2.dotProduct(v);

        v.L2norm(v);
        v2.L2norm(v2);

        v2.crossProduct(v);

        System.out.println(v.toString("v"));
        System.out.println(v2.toString("v2"));

        v.normalize(v, "v");
        v2.normalize(v2, "v2");
        
        
        
        
        GObject cube = new GObject("cube.dat.txt");
        GObject pyramid = new GObject("pyramid.dat.txt");
    }
    
    public static double Coordinates(String name, String type, String Coordinate) {
        String Question;
        double answer;

        if (type == "vector") {

            Question = JOptionPane.showInputDialog("Enter " + Coordinate + " coordinate of the vector " + name + ".");
        } else {
            Question = JOptionPane.showInputDialog("Enter " + Coordinate + " coordinate of the point " + name + ".");
        }

        answer = Double.parseDouble(Question);

        return answer;
    }

}
