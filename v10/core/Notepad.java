package core;

import java.awt.BorderLayout;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import components.Application;

public class Notepad extends Application {
    public Notepad(JPanel desktop, Taskbar taskbar, JLayeredPane appsPane) {
        super("Notepad", "./assets/notepad.png", desktop, taskbar, appsPane);
    }

    @Override
    protected void setupWindow() {
        super.setupWindow();

        this.window.setSize(500, 500);

        this.content.setBackground(GREY);
        this.content.setLayout(new BorderLayout());
        this.content.setBorder(new EmptyBorder(4, 4, 4, 4));

        this.content.add(new JTextArea());
    }
}
