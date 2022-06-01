package core; 

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Taskbar extends JPanel implements ActionListener {
    public JButton startButton;
    private JButton calcButton;
    private Calculator calc;
    private FileExplorer fileExplorer;
    private JButton fileExplorerButton;

    public Taskbar() {
        this.setBackground(new Color(0xc3c7cb));
        this.setPreferredSize(new Dimension(50, 50));
        this.setLayout(new BorderLayout(10, 10));
        this.setBorder(new EmptyBorder(5, 5, 5, 5));

        // TODO Refactor this into appIcons.
        this.startButton = new JButton("Start");
        this.startButton
                .setIcon(new ImageIcon(new ImageIcon("./assets/windows95.png").getImage().getScaledInstance(30, 30,
                        java.awt.Image.SCALE_SMOOTH)));
        this.startButton.setBackground(new Color(0xc3c7cb));
        this.startButton.setPreferredSize(new Dimension(90, 45));
        this.startButton.setBorder(BorderFactory.createLineBorder(Color.black, 2));

        this.calcButton = new JButton("Calculator");
        this.calcButton.addActionListener(this);
        this.calcButton.setBackground(new Color(0xc3c7cb));

        this.fileExplorerButton = new JButton("File Explorer");
        this.fileExplorerButton.addActionListener(this);
        this.fileExplorerButton.setBackground(new Color(0xc3c7cb));

        JPanel appsPanel = new JPanel();
        // appsPanel.setLayout(new BorderLayout(10, 0));
        appsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
        appsPanel.setOpaque(false);
        appsPanel.add(this.calcButton);
        appsPanel.add(this.fileExplorerButton);
        this.add(this.startButton, BorderLayout.WEST);
        this.add(appsPanel);

        this.calc = new Calculator();
        this.fileExplorer = new FileExplorer();
        this.calc.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.calcButton) {
            this.calc.setVisible(!this.calc.isShowing());
        } else if (e.getSource() == this.fileExplorerButton) {
            this.fileExplorer.setVisible(!this.fileExplorer.isShowing());
        }
    }
}
