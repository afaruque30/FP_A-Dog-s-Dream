package core;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import components.Application;

public class NotAVirus extends Application {
    public NotAVirus(JPanel desktop, Taskbar taskbar, JLayeredPane appsPane) {
        super("NotAVirus.exe", "./assets/disk.png", desktop, taskbar, appsPane);
    }
}