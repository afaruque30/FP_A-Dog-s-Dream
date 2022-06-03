import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import components.Application;
import core.Calculator;
import core.Taskbar;

public class Main extends JFrame {
    private Main() {
        super();

        Dimension size = new Dimension(800, 600);

        this.setSize(size);
        this.setTitle("Windows94");
        this.setIconImage(new ImageIcon("./assets/windows95.png").getImage());

        JLayeredPane mainWindow = new JLayeredPane();

        JPanel homescreen = new JPanel();
        homescreen.setSize(800, 560);
        homescreen.setBackground(new Color(0x55aaaa));
        homescreen.setLayout(new BorderLayout());

        JPanel desktop = new JPanel();
        desktop.setLayout(new FlowLayout(FlowLayout.LEADING));
        desktop.setOpaque(false);

        Taskbar taskbar = new Taskbar();

        homescreen.add(desktop, BorderLayout.WEST);
        homescreen.add(taskbar, BorderLayout.SOUTH);

        JLayeredPane appsPane = new JLayeredPane();
        appsPane.setSize(size);
        appsPane.setOpaque(false);

        mainWindow.add(homescreen, Integer.valueOf(0));
        mainWindow.add(appsPane, Integer.valueOf(1));

        this.add(mainWindow, BorderLayout.CENTER);

        new Application("File Explorer", "./assets/explorer.png", desktop, taskbar, appsPane);
        new Application("Paint", "./assets/paint.png", desktop, taskbar, appsPane);
        new Application("Notepad", "./assets/notepad.png", desktop, taskbar, appsPane);
        new Calculator(desktop, taskbar, appsPane);
        new Application("TicTacToe", "./assets/game.png", desktop, taskbar, appsPane);
        new Application("test", "./assets/windows.png", desktop, taskbar, appsPane);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}