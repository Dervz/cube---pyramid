package computerdesignlab1;

import java.awt.*;

public class Scene {

    private GObject[] obj;
    private String stringToReturn;

    public Scene(String[] fileName) {
        //set size of GObject array
        obj = new GObject[fileName.length];

        //write 2 objects cube and pyramid to the array obj[]
        for (int a = 0; a < fileName.length; a++) {
            obj[a] = new GObject(fileName[a]);

        }

    }

    public void transform(Matrix m) {
        //loop through obj[] and transform them by matrix m
        for (GObject obj1 : obj) {
            obj1.transform(m);
        }

    }
    // in order to draw the polygon method fillPolygon is used:
    //Graphics: fillPolygon(int[] xPoints, int[] yPoints, int nPoints)
    //thus, we need to pass to this method 3 arguments : transformed xPoints, transformed yPoints and total number of points.

    public void draw(Camera c, Graphics g) {

        //determine & store points of Object in array
        for (GObject obj1 : obj) {
            Point3D[] verteces = obj1.vertex;
            //determine & store faces of Object in array
            for (Face face1 : obj1.face) { 
                //enhanced for loop is used to iterate over array
                int[] indeces = face1.index;
                int numOfVer = indeces.length;
                int[] yTransformed = new int[numOfVer];
                int[] xTransformed = new int[numOfVer];
                //project points
                for (int z = 0; z < numOfVer; z++) {

                    //map through each point
                    Point3D point = verteces[indeces[z]];

                    //project the point
                    point = c.project(point);

                    //store x and y coordinates for each transformed point
                    xTransformed[z] = (int) point.x;
                    yTransformed[z] = (int) point.y;
                }
                //set color
                g.setColor(face1.color);
                //projectionTransform
                Point3D transW1 = c.projectionTransform(verteces[indeces[0]]);
                Point3D transW2 = c.projectionTransform(verteces[indeces[1]]);
                Point3D transW3 = c.projectionTransform(verteces[indeces[2]]);
                boolean isFrontFace = Point3D.isFrontFace(transW1, transW2, transW3, c.getVPN());
                if (isFrontFace) {
                    g.fillPolygon(xTransformed, yTransformed, numOfVer);
                }
            }
        }

    }

    public String toString() {


        /* Make it look nice to save your debugging time! */
        return stringToReturn;
    }
}
