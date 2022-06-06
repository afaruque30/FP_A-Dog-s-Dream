import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import java.util.Stack;

import components.Application;
import core.Calculator;
import core.Taskbar;
import core.TicTacToe;
import core.NewFileExplorer;

public class Woo extends JFrame {

    private Stack<JPanel> panels;

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

        JPanel homescreen = new JPanel(new FlowLayout(FlowLayout.LEFT));
        // default fullscreen yet allows for resizing
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

        new Application("File Explorer", "./assets/explorer.png", desktop, taskbar, appsPane);
        new Application("Paint", "./assets/paint.png", desktop, taskbar, appsPane);
        new Application("Notepad", "./assets/notepad.png", desktop, taskbar, appsPane);
        new Calculator(desktop, taskbar, appsPane);
        new TicTacToe(desktop, taskbar, appsPane);
        new NewFileExplorer(desktop, fileExplorerBar, appsPane);
        new Application("test", "./assets/windows.png", desktop, taskbar, appsPane);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Woo();
    }
}