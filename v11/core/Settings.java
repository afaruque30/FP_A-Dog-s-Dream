package core;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import components.Application;
import driver.Woo;

public class Settings extends Application {
    private Woo project;

    public Settings(JPanel desktop, Taskbar taskbar, JLayeredPane appsPane, Woo project) {
        super("Settings", "./assets/settings.png", desktop, taskbar, appsPane);
        this.project = project;
    }

    @Override
    protected void setupWindow() {
        super.setupWindow();

        this.window.setSize(300, 70);

        JTextArea rTextArea = new JTextArea();
        rTextArea.setPreferredSize(new Dimension(30, 20));
        JTextArea gTextArea = new JTextArea();
        gTextArea.setPreferredSize(new Dimension(30, 20));
        JTextArea bTextArea = new JTextArea();
        bTextArea.setPreferredSize(new Dimension(30, 20));

        JButton setColour = new JButton("Set Background");
        setColour.addActionListener(e -> {
            try {
                this.project.getHomescreen().setBackground(new Color(
                        Integer.parseInt(rTextArea.getText()),
                        Integer.parseInt(gTextArea.getText()),
                        Integer.parseInt(bTextArea.getText())));
            } catch (Exception g) {

            }
        });

        this.content.add(rTextArea);
        this.content.add(gTextArea);
        this.content.add(bTextArea);
        this.content.add(setColour);
    }
}