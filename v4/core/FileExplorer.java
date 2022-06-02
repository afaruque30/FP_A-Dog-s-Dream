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
    JSplitPane splitPane;
    JScrollPane listScrollPanel, fileScrollPanel;

    public FileExplorer() {
        this.setTitle("File Explorer");
        this.setSize(800, 600);
        this.setIconImage(new ImageIcon("../assets/windows95.png").getImage());
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        this.setVisible(true);

        this.menuBar = new JMenuBar();
        this.menu = new JMenu("File");
        // this.submenu = new JMenu("Edit");
        this.menuBar.add(menu);
        // this.menuBar.add(submenu);

        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.white);
        panel.add(new JLabel("File Explorer"), BorderLayout.NORTH);
        this.add(panel);
        splitPane = new JSplitPane();

        // sidebar implementation
        this.pack();
        this.setLocationRelativeTo(null);

        listScrollPanel = new JScrollPane();
        fileScrollPanel = new JScrollPane();
        // Create a split pane with the two scroll panes in it.
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
        listScrollPanel, fileScrollPanel);
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(150);

        // Provide minimum sizes for the two components in the split pane
        Dimension minimumSize = new Dimension(100, 50);
        listScrollPanel.setMinimumSize(minimumSize);
        fileScrollPanel.setMinimumSize(minimumSize);

        this.setJMenuBar(this.menuBar);
        // this.add(splitPane);
    }

    public void actionPerformed(ActionEvent e) {
        // implement sidebar
        if (e.getSource() == menuItem) {
            // implement sidebar
            System.out.println("menu triggered");
        }
    }
}
