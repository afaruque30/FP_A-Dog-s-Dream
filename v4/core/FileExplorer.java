package core;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class FileExplorer extends JFrame implements ActionListener {
    // implement sidebar
    JMenuBar menuBar;
    JMenu fileMenu, editMenu, viewMenu, toolMenu, helpMenu;
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
        this.fileMenu = new JMenu("File");
        this.editMenu = new JMenu("Edit");
        this.viewMenu = new JMenu("View");
        this.toolMenu = new JMenu("Tools");
        this.helpMenu = new JMenu("Help");
        this.menuBar.add(fileMenu);
        this.menuBar.add(editMenu);
        this.menuBar.add(viewMenu);
        this.menuBar.add(toolMenu);
        this.menuBar.add(helpMenu);


        panel = new JPanel();
        panel.setSize(800,600);
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.white);
        panel.add(new JLabel("File Explorer"), BorderLayout.NORTH);
        this.add(panel);
        splitPane = new JSplitPane();

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
