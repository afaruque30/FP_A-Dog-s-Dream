import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

public class Loading extends JPanel {
    JPanel content;

    public Loading() {
        // function as loading screen for the os
        content = new JPanel();
        content.setLayout(new BorderLayout());
        content.setBackground(Color.BLACK);
        content.setPreferredSize(new Dimension(300, 300));
        content.setBorder(new EmptyBorder(4, 40, 4, 40));

        JLabel label = new JLabel("Loading...", SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        content.add(label, BorderLayout.CENTER);

    }

}