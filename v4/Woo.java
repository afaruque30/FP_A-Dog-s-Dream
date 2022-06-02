import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Stack;

import javax.swing.*;
import core.*;

public class Woo extends JFrame {
    static JFrame loadingFrame;
    static Stack<JFrame> screensStack = new Stack<JFrame>();

    private static void createAndShowGUI() {
        JFrame frame = new JFrame();

        // LOADING SCREEN
        loadingFrame = new Loading();

        frame.setTitle("Windows 95");
        frame.setIconImage(new ImageIcon("./assets/windows95.png").getImage());
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        // frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(0x55aaaa));
        // make the background image to be windows 95 image
        // @TODO refactor this too LOL
        JLabel background = new JLabel(new ImageIcon(new ImageIcon("./assets/windows95.png").getImage().getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH)));
        frame.getContentPane().add(background, BorderLayout.CENTER);
        
        Taskbar taskbar = new Taskbar();
        Desktop desktop = new Desktop();
        
        frame.getContentPane().add(desktop, BorderLayout.NORTH);
        // frame.add(desktop, BorderLayout.CENTER);
        frame.add(taskbar, BorderLayout.SOUTH);
        // frame.add(desktop, BorderLayout.NORTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}