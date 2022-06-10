package core;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import java.awt.Color;
import components.Application;

public class NotAVirus extends Application {
    public NotAVirus(JPanel desktop, Taskbar taskbar, JLayeredPane appsPane) {
        super("NotAVirus.exe", "./assets/disk.png", desktop, taskbar, appsPane);
    }

    @Override
    protected void setupWindow() {
        super.setupWindow();

        // popup a lot of jpanels and troll the user
        for (int i = 0; i < 10; i++) {
            JPanel panel = new JPanel();
            panel.setSize(100, 100);
            panel.setLocation(
                    (int) (Math.random() * (this.window.getWidth() - 100)),
                    (int) (Math.random() * (this.window.getHeight() - 100)));
            panel.setBackground(Color.BLACK);
            panel.setVisible(true);
        }
    }

}