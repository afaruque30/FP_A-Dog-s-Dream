package core;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import components.Application;

public class Settings extends Application {

    public Settings(JPanel desktop, Taskbar taskbar, JLayeredPane appsPane) {
        super("Settings", "./assets/settings.png", desktop, taskbar, appsPane);
    }

}
