package core;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Taskbar extends JPanel implements ActionListener {
    private JButton startButton;

    public Taskbar() {
        super();

        this.setBackground(new Color(0xc3c7cb));
        this.setPreferredSize(new Dimension(100, 50));
        this.setLayout(new FlowLayout(FlowLayout.LEADING));
        this.setBorder(new EmptyBorder(2, 2, 2, 2));

        this.startButton = new JButton("Start");
        this.startButton.setBackground(new Color(0xc3c7cb));
        this.startButton.setIcon(new ImageIcon(new ImageIcon("./assets/windows.png").getImage()
                .getScaledInstance(30, 30, Image.SCALE_SMOOTH)));

        JPanel clock = new JPanel();
        clock.setBackground(new Color(0xc3c7cb));
        clock.setPreferredSize(new Dimension(100, 50));
        clock.setLayout(new FlowLayout(FlowLayout.LEADING));
        clock.setBorder(new EmptyBorder(2, 2, 2, 2));
        // dynamically update the clock

        this.add(this.startButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // document why this method is empty
    }
}
