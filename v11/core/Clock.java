package core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.Timer;

public class Clock {
    private final JLabel timeLabel = new JLabel("00:00:00");

    public Clock() {
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeLabel.setText(new Date().toString());
            }
        });
    }
}
