
// java swing project
import java.awt.Component;
import java.awt.Color;
import javax.swing.*;

public class Woo extends JFrame {
    private static JFrame frame;
    

    private static void createAndShowGUI() {
        frame = new JFrame("Windows 95");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(new ImageIcon("./assets/windows95.png").getImage());
        frame.setSize(1280, 720);
        frame.getContentPane().setBackground(new Color(1, 130, 129));

        Taskbar taskbar = new Taskbar();
        Desktop desktop = new Desktop();
        frame.add(taskbar);
        // frame.add(desktop);

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