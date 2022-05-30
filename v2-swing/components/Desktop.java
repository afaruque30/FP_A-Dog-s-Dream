package components;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Desktop extends JPanel implements Runnable {
    public Thread thread;
    public Taskbar taskbar;
    public Stack<Component> screens;

    public Desktop() {
        this.setFocusable(true);
        taskbar = new Taskbar();
        screens = new Stack<Component>();
        screens.push(taskbar);

    }

    public void paint(Graphics g) {
        Toolkit.getDefaultToolkit().sync();
        draw(g);
    }

    public void draw(Graphics g) {
        screens.peek().draw(g, this);
    }

    public void run() {
        // continously repaint the screen
        long lastTime = System.nanoTime();
        double delta = 0;
        double frames = 0;
        long timer = System.currentTimeMillis();
        while (true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            repaint();
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                frames = 0;
            }
        }
    }
}