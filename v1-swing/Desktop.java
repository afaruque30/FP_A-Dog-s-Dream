import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import java.awt.Graphics2D;
import java.awt.Graphics;
// create a turquoise background

public class Desktop extends JComponent {
    public void draw(Graphics g) {
        // place windows 95 icon in the center of the frame

        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(new ImageIcon("./assets/windows95.png").getImage(), 640, 0, null);
    }
}