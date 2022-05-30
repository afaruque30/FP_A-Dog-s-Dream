import java.awt.Color;
import javax.swing.*;

// 0xc3c7cb - default grey
// 0x868a8e - default dark grey
// 0x0000aa - default blue

public class Woo extends JFrame {
    private static void createAndShowGUI() {
        JFrame frame = new JFrame();
        frame.setTitle("Windows 95");
        frame.setIconImage(new ImageIcon("./assets/windows95.png").getImage());
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(0x55aaaa));
        
        Taskbar taskbar = new Taskbar();
        
        frame.add(taskbar);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
                new Calculator();
            }
        });
    }
}