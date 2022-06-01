package core;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class FileExplorer extends JFrame implements ActionListener {
    // implement sidebar
    JMenuBar menuBar; 
    JMenu menu, submenu;
    JMenuItem menuItem;
    JPanel panel;

    public FileExplorer(){
        this.setTitle("File Explorer");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        this.menuBar = new JMenuBar();
        this.menu = new JMenu("File");
        this.submenu = new JMenu("Edit");
        this.menuBar.add(menu);
        this.menuBar.add(submenu);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.white);
        panel.add(new JLabel("File Explorer"), BorderLayout.NORTH);
        this.add(panel);


        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // implement sidebar
        if (e.getSource() == menuItem) {
            // implement sidebar
        }
    }
}
