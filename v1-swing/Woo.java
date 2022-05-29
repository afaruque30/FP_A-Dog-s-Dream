import java.awt.Color;
import javax.swing.*;

public class Woo extends JFrame {
    private static JFrame frame;
    private static JPanel panel;

    private static void createAndShowGUI() {
        frame = new JFrame("Windows 95");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(new ImageIcon("./assets/windows95.png").getImage());
        frame.setSize(1280, 720);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(1, 130, 129));
        Taskbar taskbar = new Taskbar();
        frame.add(taskbar);
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