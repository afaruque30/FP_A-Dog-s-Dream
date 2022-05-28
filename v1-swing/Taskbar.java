import java.awt.Color;

import javax.swing.JComponent;
import javax.swing.JLabel;
import java.awt.Graphics;

public class Taskbar extends JComponent {
    public Taskbar() {
    }

    protected void paintComponent(Graphics g) {
        g.setColor(new Color(192, 192, 192));
        g.fillRect(0, 640, 1280, 50);
    }
}
