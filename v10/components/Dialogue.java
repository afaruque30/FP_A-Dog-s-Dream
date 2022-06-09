package components;

import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Graphics;

public class Dialogue extends JComponent {
    // pass in message content
    String message;
    JComponent child;

    public Dialogue(String message) {
        this.message = message;
    }

    @Override
    public void paintComponent(Graphics g) {
        // draw a topbar to the top of the dialogue to allow for dragging and closing
        g.setColor(new Color(192, 192, 192));
        g.fillRect(60, 500, 80, 40);

        // draw the message
        g.setColor(new Color(0, 0, 0));
        g.drawString(message, 10, 20);

        // draw a box shadow around the message
        g.setColor(new Color(0, 0, 0, 100));
        g.fillRect(0, 0, 1280, 40);

        // add two buttons to the topbar
        // close button
        g.setColor(new Color(192, 0, 0));
        g.fillRect(1280 - 40, 0, 40, 40);
        // minimize button
        g.setColor(new Color(192, 192, 192));
        g.fillRect(1280 - 80, 0, 40, 40);

        // add on hover effect
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setBackground(new Color(0, 0, 0, 100));
            }
        });

        // listen for closure event
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                setVisible(false);
            }
        });

    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setChild(JComponent child) {
        this.child = child;
    }
}
