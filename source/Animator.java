package computerdesignlab1;

import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;

public class Animator extends JFrame {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private static final int INTERVAL = 100;
    private BufferedImage image;

    public Animator() {
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private int R;

    protected void animate(Graphics g) {
        // SETS the color of polygon
        g.setColor(Color.GREEN);
        R = R > 20 ? 0 : R + 1;
        g.fillPolygon(new int[]{100, WIDTH / 2, R * 3}, new int[]{100, HEIGHT / 2, R * 3}, 3);
    }

    protected final void loop() {
        while (true) {
            image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D g2 = image.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            // SETS the color of frame 
            g2.setColor(Color.WHITE);
            g2.fillRect(0, 0, getWidth(), getHeight());

            animate(g2);

            ((Graphics2D) getGraphics()).drawImage(image, 0, 0, null);
            paint(getGraphics());
            try {
                Thread.sleep(INTERVAL);
            } //Sleeps, and then repeats the animation
            catch (InterruptedException e) {
            }
        }
    }

    public final void paint(Graphics g) {
    }

    public static void main(String[] args) {
        new Animator().loop();
    }
}