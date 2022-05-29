import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.Graphics;
import components.*;
import java.util.Stack;

public class Desktop extends JPanel implements Runnable {

    public Thread thread;
    public Taskbar taskbar;
    public Stack<Component> screens;

    public Desktop() {
        taskbar = new Taskbar();
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, 1280, 720);
        if (screens != null) {
            for (Component c : screens) {
                c.paint(g2d);
            }
        }
        taskbar.paint(g2d);
    }

}