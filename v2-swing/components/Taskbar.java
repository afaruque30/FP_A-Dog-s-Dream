package components;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import java.awt.Graphics;
import java.awt.Image;
import components.Rectangle;

public class Taskbar extends Component {
    private final int y = 650;
    private final int x = 0;

    protected void paintComponent(Graphics g) {
        g.setColor(new Color(192, 192, 192));
        g.fillRect(0, 650, 1280, 40);

        // LOAD WINDOWS 95 ICON
        ImageIcon windows95 = new ImageIcon("./assets/windows95.png");
        Image image = windows95.getImage();
        Image newImage = image.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
        JLabel icon = new JLabel(new ImageIcon(newImage));
        icon.setBounds(0, 640, 50, 50);
        // write the word start
        JLabel start = new JLabel("Start");
        start.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setBackground(new Color(192, 0, 0, 100));
                System.out.println("Mouse entered");
            }
        });
        start.setBounds(50, 640, 50, 50);

        // a box shadow around the icon and the word start
        g.setColor(new Color(0, 0, 0, 100));
        g.fillRect(0, 650, 50, 40);
        g.fillRect(50, 650, 50, 40);

        add(icon);
        add(start);
    }

}
