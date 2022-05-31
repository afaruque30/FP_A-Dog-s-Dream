import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;

// 0x868a8e - default dark grey

public class Woo extends JFrame {
    static Calculator calc;

    private static void createAndShowGUI() {
        JFrame frame = new JFrame();
        frame.setTitle("Windows 95");
        frame.setIconImage(new ImageIcon("./assets/windows95.png").getImage());
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        // frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(0x55aaaa));
        
        Taskbar taskbar = new Taskbar();
        
        frame.add(taskbar, BorderLayout.SOUTH);

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