package driver;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import core.Calculator;
import core.MSPaint;
import core.NewFileExplorer;
import core.NotAVirus;
import core.Notepad;
import core.Settings;
import core.Taskbar;
import core.TicTacToe;

public class Woo extends JFrame {
    private Stack<JPanel> panels;
    private JPanel homescreen;

    private Woo() {
        super();

        Dimension size = new Dimension(
                (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 100),
                (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 71));

        this.setSize(size);
        this.setTitle("Windows 95");
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setIconImage(new ImageIcon("./assets/windows95.png").getImage());

        JLayeredPane mainWindow = new JLayeredPane();

        homescreen = new JPanel(new FlowLayout(FlowLayout.LEFT));
        homescreen.setSize(new Dimension(size));
        homescreen.setBackground(new Color(0x55aaaa));
        homescreen.setLayout(new BorderLayout());

        JPanel desktop = new JPanel();
        desktop.setLayout(new FlowLayout(FlowLayout.LEADING));
        desktop.setOpaque(false);

        Taskbar taskbar = new Taskbar();
        Taskbar fileExplorerBar = new Taskbar();

        homescreen.add(desktop, BorderLayout.WEST);
        homescreen.add(taskbar, BorderLayout.SOUTH);

        JLayeredPane appsPane = new JLayeredPane();
        appsPane.setSize(new Dimension(size));
        appsPane.setOpaque(false);

        mainWindow.add(homescreen, Integer.valueOf(0));
        mainWindow.add(appsPane, Integer.valueOf(1));

        this.add(mainWindow, BorderLayout.CENTER);

        new MSPaint(desktop, taskbar, appsPane);
        new Notepad(desktop, taskbar, appsPane);
        new Calculator(desktop, taskbar, appsPane);
        new TicTacToe(desktop, taskbar, appsPane);
        new NewFileExplorer(desktop, fileExplorerBar, appsPane);
        new NotAVirus(desktop, taskbar, appsPane);
        new Settings(desktop, taskbar, appsPane, this);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JPanel getHomescreen() {
        return homescreen;
    }

    public static void main(String[] args) {
        new Woo();
    }
}