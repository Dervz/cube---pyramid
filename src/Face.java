package computerdesignlab1;

import java.awt.Color;

public class Face {

    public int[] index;
    public Color color;
    public String message;

    public Face(int[] i, Color c) {
        index = new int[i.length];
        index = i;
        color = c;
       
    }
    

   
    public String toString() {

        return message;
        /* Make it look nice to save your debugging time! */
    }
}
