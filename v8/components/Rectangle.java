package components;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class Rectangle extends JComponent {
    // create a rectangle class with an option for a child
    // class that will be used to draw the rectangle
    JComponent child;

    public Rectangle(int x, int y, int width, int height) {
        this(x, y, width, height, null);
    }

    public Rectangle(int x, int y, int width, int height, JComponent child) {
        this.setLocation(x, y);
        this.setSize(width, height);
        this.child = child;
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(new Color(192, 192, 192));
        g.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        if (child != null) {
            child.setBounds(this.getX(), this.getY(), this.getWidth(), this.getHeight());
            add(child);
        }
        // add on hover effect
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setBackground(new Color(0, 0, 0, 100));
            }
        });

        this.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                setBackground(new Color(192, 192, 192));
            }
        });
    }
}