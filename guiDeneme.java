import javax.swing.*;
import java.awt.*;

public class guiDeneme extends JFrame {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int DIAMETER = 50;

    private int x1 = 0, y1 = HEIGHT / 2;
    private int x2 = WIDTH - DIAMETER, y2 = HEIGHT / 2;
    private int speed1 = 1, speed2 = -1;
    private Color color1 = Color.RED, color2 = Color.BLUE;

    public guiDeneme() {
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(color1);
                g.fillOval(x1, y1, DIAMETER, DIAMETER);
                g.setColor(color2);
                g.fillOval(x2, y2, DIAMETER, DIAMETER);
            }
        };

        add(panel);
        setVisible(true);

        while (true) {
            if (Math.abs(x1 - x2) < DIAMETER) {
                speed1 = -speed1;
                speed2 = -speed2;
                speed1 += (speed1 > 0) ? 1 : -1; // Hızı artır
                speed2 += (speed2 > 0) ? 1 : -1; // Hızı artır
                color1 = new Color((int)(Math.random() * 0x1000000));
                color2 = new Color((int)(Math.random() * 0x1000000));
            }

            if (x1 <= 0 || x1 >= WIDTH - DIAMETER) {
                speed1 = Math.abs(speed1);
                speed1 += 1; // Hızı artır
            }

            if (x2 <= 0 || x2 >= WIDTH - DIAMETER) {
                speed2 = -Math.abs(speed2);
                speed2 -= 1; // Hızı artır
            }

            x1 += speed1;
            x2 += speed2;

            panel.repaint();

            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new guiDeneme();
    }
}
