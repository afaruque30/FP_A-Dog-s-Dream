package components;

import javax.swing.*;

public class DesktopIcons extends JButton {
    public DesktopIcons(String iconpath, String appName, String command) {
        // this.setIcon(new ImageIcon(iconpath));
        // small image icon
        this.setIcon(new ImageIcon(new ImageIcon(iconpath).getImage().getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH)));
        this.setToolTipText(appName);
        this.setBorderPainted(false);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
        this.setOpaque(false);
        this.setActionCommand(command);
    }
}