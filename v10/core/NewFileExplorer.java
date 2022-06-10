package core;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.JComponent;

import components.Application;

public class NewFileExplorer extends Application {
    private DefaultMutableTreeNode root;
    private DefaultTreeModel treeModel;
    private JTree tree;
    private static final ImageIcon FOLDER = new ImageIcon("./assets/folder.png");
    private static final ImageIcon FILE = new ImageIcon("./assets/file.png");
    private static final ImageIcon DISK = new ImageIcon("./assets/diskFileExplorer.png");
    JPanel desktop;

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
        // show host file system
        File[] files = fileRoot.listFiles();
        root = new DefaultMutableTreeNode(files[0]);
        for (File file : files) {
            root.add(new DefaultMutableTreeNode(file));
        }

        treeModel = new DefaultTreeModel(root);
        tree = new JTree(treeModel);
        tree.setShowsRootHandles(true);
        tree.setCellRenderer(new FileTreeCellRenderer());

        // add listener for tree selection
        // tree.addTreeSelectionListener(e -> {
        // DefaultMutableTreeNode node = (DefaultMutableTreeNode)
        // tree.getLastSelectedPathComponent();
        // if (node.isLeaf()) {
        // File file = (File) node.getUserObject();
        // if (file.isDirectory()) {
        // File[] files2 = file.listFiles();
        // root = new DefaultMutableTreeNode(files2[0]);
        // for (File file2 : files2) {
        // root.add(new DefaultMutableTreeNode(file2));
        // }
        // treeModel.setRoot(root);
        // }
        // }
        // });

        // add selection listeners and open file if its not a directory
        tree.addTreeSelectionListener(e -> {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
            try {
                if (node.isLeaf()) {
                    File file = (File) node.getUserObject();
                    if (file.isDirectory()) {
                        File[] files2 = file.listFiles();
                        root = new DefaultMutableTreeNode(files2[0]);
                        for (File file2 : files2) {
                            root.add(new DefaultMutableTreeNode(file2));
                        }
                        treeModel.setRoot(root);
                    } else {
                        openFile(file);
                    }
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        tree.addTreeExpansionListener(
                new TreeExpansionListener() {
                    @Override
                    public void treeExpanded(TreeExpansionEvent event) {
                        // expand and add to root node
                        DefaultMutableTreeNode node = (DefaultMutableTreeNode) event.getPath().getLastPathComponent();
                        if (node.isLeaf()) {
                            File file = (File) node.getUserObject();
                            if (file.isDirectory()) {
                                File[] files2 = file.listFiles();
                                for (File file2 : files2) {
                                    root.add(new DefaultMutableTreeNode(file2));
                                }
                            }
                        }
                        treeModel.setRoot(root);
                        treeModel.reload(root);
                    }

                    @Override
                    public void treeCollapsed(TreeExpansionEvent event) {
                    }
                });

        JScrollPane scrollPane = new JScrollPane(tree);

        splitPane.add(scrollPane);
        splitPane.setSize(640, 480);
        splitPane.setVisible(true);

        // create a desktop view
        desktop = new JPanel(new BorderLayout());
        desktop.setBackground(Application.GREY);
        desktop.setPreferredSize(new Dimension(200, 200));
        // add text area to desktop
        JTextArea textArea = new JTextArea();
        textArea.setBackground(Application.GREY);
        textArea.setFont(new Font("Arial", Font.PLAIN, 12));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        desktop.add(textArea);
        splitPane.add(desktop);

        this.content.add(splitPane, BorderLayout.CENTER);
    }

    // open file function
    public void openFile(File file) {
        System.out.println("Opening file: " + file.getName());
        if (file.exists()) {
            desktop.removeAll();
            // display image if file is an image
            if (file.getName().endsWith(".png") || file.getName().endsWith(".jpg")
                    || file.getName().endsWith(".jpeg")) {
                JLabel label = new JLabel(new ImageIcon(file.getAbsolutePath()));
                desktop.add(label);
                return;
            }

            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = reader.readLine()) != null) {
                    desktop.add(new JLabel(line));
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    class FileTreeCellRenderer extends DefaultTreeCellRenderer {

        private FileSystemView fileSystemView;

        private JLabel label;

        FileTreeCellRenderer() {
            label = new JLabel();
            label.setOpaque(true);
            fileSystemView = FileSystemView.getFileSystemView();
        }

        @Override
        public JComponent getTreeCellRendererComponent(
                JTree tree,
                Object value,
                boolean selected,
                boolean expanded,
                boolean leaf,
                int row,
                boolean hasFocus) {

            DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
            File file = (File) node.getUserObject();
            label.setIcon(fileSystemView.getSystemIcon(file));
            label.setText(fileSystemView.getSystemDisplayName(file));
            label.setToolTipText(file.getPath());

            if (selected) {
                label.setBackground(backgroundSelectionColor);
            } else {
                label.setBackground(backgroundNonSelectionColor);
            }

            return label;
        }
    }

}
