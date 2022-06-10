package core;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Taskbar extends JPanel implements ActionListener {
    private final class TimerActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            timeLabel.setText(new SimpleDateFormat("HH:mm:ss")
                    .format(new Date()));
        }
    }

    private JButton startButton;
    private final JLabel timeLabel = new JLabel(new SimpleDateFormat("HH:mm:ss")
            .format(new Date()));

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

        this.startButton.addActionListener(this);

        Timer timer = new Timer(1000, new TimerActionListener());
        timer.start();

        this.add(this.startButton);
        this.add(this.timeLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO document why this method is empty
    }
}
