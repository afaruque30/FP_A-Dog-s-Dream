package core;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import components.Application;

public class MSPaint extends Application {
    String currentColor;
    double strokeWidth;
    private final int blue = 255;
    

    public MSPaint(String appName, String iconPath, JPanel desktop, Taskbar taskbar, JLayeredPane appsPane) {
        super(appName, iconPath, desktop, taskbar, appsPane);
        //TODO Auto-generated constructor stub
    }
    

    // @TODO add event listeners for mousedown; mouseadapters
    // we might also need to override the default ones
}
