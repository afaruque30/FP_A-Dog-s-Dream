import javax.swing.JButton;

public class AppIcons extends JButton {
    AppIcons(String iconPath) {
        this.setIcon(new ImageIcon(
                new ImageIcon(iconPath).getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
        this.setBackground(new Color(0xc3c7cb));
        this.setPreferredSize(new Dimension(90, 45));
        this.setBorder(BorderFactory.createLineBorder(Color.black, 2));
    }

    AppIcons(String iconPath, String tooltip) {
        this(iconPath);
        this.setToolTipText(tooltip);
    }

    AppIcons(String iconPath, String tooltip, String actionCommand) {
        this(iconPath, tooltip);
        this.setActionCommand(actionCommand);
    }
}