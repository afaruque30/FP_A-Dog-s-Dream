package core;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;
import javax.swing.JTree;

import components.Application;

public class NewFileExplorer extends Application {
    private DefaultMutableTreeNode root;
    private DefaultTreeModel treeModel;
    private JTree tree;

    public NewFileExplorer(JPanel desktop, Taskbar taskbar, JLayeredPane appsPane) {
        super("File Explorer", "./assets/explorer.png", desktop, taskbar, appsPane);
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem menuItem = new JMenuItem("New");

        JMenu edit = new JMenu("Edit");
        JMenuItem editItem = new JMenuItem("Cut");
        JMenuItem editItem2 = new JMenuItem("Copy");

        edit.add(editItem);
        edit.add(editItem2);

        JMenu view = new JMenu("View");

        JMenu help = new JMenu("Help");

        menu.add(menuItem);
        menuBar.add(menu);
        menuBar.add(edit);
        menuBar.add(view);
        menuBar.add(help);
        // super.MenuApplication("File Explorer", "./assets/explorer.png", desktop,
        // taskbar, appsPane, menuBar);
    }

    @Override
    protected void setupWindow() {
        super.setupWindow();
        this.window.setSize(800, 600);

        this.content.setLayout(new BorderLayout());
        this.content.setBorder(new EmptyBorder(4, 4, 10, 4));
        this.content.setBackground(Application.GREY);

        // use split pane to create a split view of the desktop and the file explorer
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setDividerLocation(200);
        splitPane.setDividerSize(10);
        splitPane.setBackground(Application.GREY);

        // create a file explorer view
        File fileRoot = new File("C:/");
        root = new DefaultMutableTreeNode(new FileNode(fileRoot));
        treeModel = new DefaultTreeModel(root);

        tree = new JTree(treeModel);
        tree.setShowsRootHandles(true);
        JScrollPane scrollPane = new JScrollPane(tree);

        splitPane.add(scrollPane);
        splitPane.setSize(640, 480);
        splitPane.setVisible(true);

        // create a desktop view
        JPanel desktop = new JPanel(new BorderLayout());
        desktop.setBackground(Application.GREY);
        desktop.setPreferredSize(new Dimension(200, 200));
        splitPane.add(desktop);

        this.content.add(splitPane, BorderLayout.CENTER);
    }
}
