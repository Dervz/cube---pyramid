package computerdesignlab1;

import java.util.Scanner;
import java.io.*;
import java.awt.Color;

public class GObject {

    public String output;
    public Point3D[] vertex;
    public Face[] face;

    public GObject(Point3D[] v, Face[] f) {
        face = f;
        vertex = v;
   
    }

    public GObject(String fileName) {

        Scanner scan;

        try {
            scan = new Scanner(new File(fileName));

            double verteces = Double.parseDouble(scan.nextLine());

            int a = 0;

            vertex = new Point3D[(int) (verteces)];

            while (scan.hasNextLine() && a < verteces) {

                double first = Double.parseDouble(scan.next());
                double second = Double.parseDouble(scan.next());
                double third = Double.parseDouble(scan.next());

                vertex[a] = new Point3D(first, second, third);

                a++;
            }

            int numberOfFaces = scan.nextInt();
            face = new Face[numberOfFaces];
            int k = 0;
            System.out.println("here1");
            while (scan.hasNextLine() && k < numberOfFaces) {

                int numberOfVertices = scan.nextInt();

                int[] myFaces = new int[numberOfVertices];

                for (int x = 0; x < numberOfVertices; x++) {
                    myFaces[x] = Integer.parseInt(scan.next());

                }
                
                double r = Double.parseDouble(scan.next());
                double g = Double.parseDouble(scan.next());
                double b = Double.parseDouble(scan.next());
                
                //Constructor is color(int,int,int). However parsing to float is essential
                Color color = new Color((float) r, (float) g, (float) b); 

                face[k] = new Face(myFaces, color);

               
                k++;
            }

        } catch (FileNotFoundException e) {
            System.out.println("File with name " + fileName + " doesnt exist");

        }

    }
    
    
    //OBJECT TRANSFORMATION (LAB 3)
    public void transform(Matrix mat){
    
        
       for (int a = 0; a < vertex.length; a++){
           
       
        double d = vertex[a].x * mat.m[0][0] + vertex[a].y * mat.m[0][1] + vertex[a].z * mat.m[0][2] + mat.m[0][3];
        
        double d2 = vertex[a].x * mat.m[1][0] + vertex[a].y * mat.m[1][1] + vertex[a].z * mat.m[1][2] + mat.m[1][3];
        
        double d3 = vertex[a].x * mat.m[2][0] + vertex[a].y * mat.m[2][1] + vertex[a].z * mat.m[2][2] + mat.m[2][3];
        
        double d4 = vertex[a].x * mat.m[3][0] + vertex[a].y * mat.m[3][1] + vertex[a].z * mat.m[3][2] + mat.m[3][3];
        
        vertex[a].x = d / d4;
        vertex[a].y = d2 / d4;
        vertex[a].z = d3 / d4;
        
        }
       
    
    }

    public String toString() {
        return output;
        /* Make it look nice to save your debugging time! */
    }
}
