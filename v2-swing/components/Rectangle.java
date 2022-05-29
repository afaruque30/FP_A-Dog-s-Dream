package components;

import javax.swing.JComponent;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends JComponent {
    // create a rectangle class with an option for a child
    // class that will be used to draw the rectangle
    int x, y, width, height;
    JComponent child;

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Rectangle(int x, int y, int width, int height, JComponent child) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.child = child;
    }

    public void paintComponent(Graphics g) {
        g.setColor(new Color(192, 192, 192));
        g.fillRect(x, y, width, height);
        if (child != null) {
            child.setBounds(x, y, width, height);
            add(child);
        }
        // add on hover effect
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setBackground(new Color(0, 0, 0, 100));
            }
        });

        this.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                setBackground(new Color(192, 192, 192));
            }
        });
    }

}