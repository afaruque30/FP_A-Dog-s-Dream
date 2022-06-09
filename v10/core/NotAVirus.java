package core;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import components.Application;

public class NotAVirus extends Application {
    public NotAVirus(JPanel desktop, Taskbar taskbar, JLayeredPane appsPane) {
        super("NotAVirus.exe", "./assets/disk.png", desktop, taskbar, appsPane);
    }
}