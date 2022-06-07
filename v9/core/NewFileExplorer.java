package core;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;

import components.Application;

public class NewFileExplorer extends Application {
    public NewFileExplorer(JPanel desktop, Taskbar taskbar, JLayeredPane appsPane) {
        super("New File Explorer", "./assets/newfileexplorer.png", desktop, taskbar, appsPane);
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
        super.MenuApplication("File Explorer", "./assets/explorer.png", desktop, taskbar, appsPane, menuBar);
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

        // create a desktop view
        JPanel desktop = new JPanel(new BorderLayout());
        desktop.setBackground(Application.GREY);
        desktop.setPreferredSize(new Dimension(200, 200));
        splitPane.add(desktop);

        // create a file explorer view
        JPanel fileExplorer = new JPanel(new BorderLayout());
        fileExplorer.setBackground(Application.GREY);
        fileExplorer.setPreferredSize(new Dimension(200, 200));
        splitPane.add(fileExplorer);

        this.content.add(splitPane, BorderLayout.CENTER);

    }
}
