import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame {

    public static void bootProcess() {
        JFrame loadingWindow = new JFrame();
        // black terminal-esque screen
        loadingWindow.setTitle("Windows 95");
        loadingWindow.setIconImage(new ImageIcon("./assets/windows95.png").getImage());
        loadingWindow.setBackground(Color.black);
        loadingWindow.setExtendedState(MAXIMIZED_BOTH); 
        loadingWindow.getContentPane().setBackground(new Color(0x55aaaa));
        // load terminal font
        Font font = new Font("Terminal", Font.PLAIN, 20);
        loadingWindow.setFont(font);

        JPanel panel = new JPanel();
        panel.setBackground(Color.black);
        panel.setLayout(new BorderLayout());

        JLabel start = new JLabel("Loading");
        panel.add(start);

        // incremental loading bar
        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        progressBar.setForeground(Color.white);
        progressBar.setBackground(Color.black);
        progressBar.setBorderPainted(false);
        progressBar.setString("Loading...");
        panel.add(progressBar, BorderLayout.CENTER);

        loadingWindow.getContentPane().add(panel);
        loadingWindow.setVisible(true);
    }

    public Loading() {
        javax.swing.SwingUtilities.invokeLater(Loading::bootProcess);
    }
}