package components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import core.Taskbar;

public class Application implements ActionListener {
    protected static final Color GREY = new Color(0xc3c7cb);

    private String appName;
    private JButton desktopIcon;
    private JButton taskbarIcon;
    private Point prevPt;
    private JMenuBar appMenu;

    protected JPanel window;
    protected JPanel content;

    public Application(String appName, String iconPath, JPanel desktop, Taskbar taskbar, JLayeredPane appsPane) {
        Image icon = new ImageIcon(iconPath).getImage();

        this.appName = appName;

        this.desktopIcon = new JButton(this.appName);
        this.desktopIcon.setToolTipText(this.appName);
        this.desktopIcon.setOpaque(false);
        this.desktopIcon.setContentAreaFilled(false);
        this.desktopIcon.setIcon(new ImageIcon(icon.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
        this.desktopIcon.setHorizontalTextPosition(SwingConstants.CENTER);
        this.desktopIcon.setVerticalTextPosition(SwingConstants.BOTTOM);
        this.desktopIcon.setPreferredSize(new Dimension(100, 120));
        this.desktopIcon.addActionListener(e -> {
            this.taskbarIcon.setVisible(true);
            this.window.setVisible(true);
        });

        this.taskbarIcon = new JButton(this.appName);
        this.taskbarIcon.setBackground(Application.GREY);
        this.taskbarIcon.setIcon(new ImageIcon(icon.getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
        this.taskbarIcon.setHorizontalAlignment(SwingConstants.LEFT);
        this.taskbarIcon.setPreferredSize(new Dimension(150, 40));
        this.taskbarIcon.setToolTipText(this.appName);
        this.taskbarIcon.setVisible(false);
        this.taskbarIcon.addActionListener(e -> this.window.setVisible(!this.window.isShowing()));

        setupWindow();

        desktop.add(this.desktopIcon);
        taskbar.add(this.taskbarIcon);
        appsPane.add(this.window);
    }

    public void MenuApplication(String appName, String iconPath, JPanel desktop, Taskbar taskbar, JLayeredPane appsPane,
            JMenuBar menu) {
        Image icon = new ImageIcon(iconPath).getImage();

        this.appName = appName;

        this.desktopIcon = new JButton(this.appName);
        this.desktopIcon.setToolTipText(this.appName);
        this.desktopIcon.setOpaque(false);
        this.desktopIcon.setContentAreaFilled(false);
        this.desktopIcon.setIcon(new ImageIcon(icon.getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
        this.desktopIcon.setHorizontalTextPosition(SwingConstants.CENTER);
        this.desktopIcon.setVerticalTextPosition(SwingConstants.BOTTOM);
        this.desktopIcon.setPreferredSize(new Dimension(100, 120));
        this.desktopIcon.addActionListener(e -> {
            this.taskbarIcon.setVisible(true);
            this.window.setVisible(true);
        });

        this.taskbarIcon = new JButton(this.appName);
        this.taskbarIcon.setBackground(Application.GREY);
        this.taskbarIcon.setIcon(new ImageIcon(icon.getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
        this.taskbarIcon.setHorizontalAlignment(SwingConstants.LEFT);
        this.taskbarIcon.setPreferredSize(new Dimension(150, 40));
        this.taskbarIcon.setToolTipText(this.appName);
        this.taskbarIcon.setVisible(false);
        this.taskbarIcon.addActionListener(e -> this.window.setVisible(!this.window.isShowing()));
        appMenu = menu;
        setupWindow();
        desktop.add(this.desktopIcon);
        taskbar.add(this.taskbarIcon);
        appsPane.add(this.window);
    }

    protected void setupWindow() {
        this.window = new JPanel(new BorderLayout());
        this.window.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        this.window.setFocusable(true);

        JPanel titleBar = new JPanel(new BorderLayout());
        titleBar.setBorder(new EmptyBorder(0, 0, 0, 0));
        titleBar.setPreferredSize(new Dimension(200, appMenu == null ? 30 : 50));
        titleBar.setBackground(new Color(0x0000aa));

        JLabel title = new JLabel(this.appName);
        title.setForeground(Color.WHITE);

        JButton minimize = new JButton("--");
        minimize.setBackground(Application.GREY);
        minimize.setPreferredSize(new Dimension(50, 20));
        minimize.addActionListener(e -> this.window.setVisible(!this.window.isShowing()));

        JButton close = new JButton("X");
        close.setBackground(Application.GREY);
        close.setPreferredSize(new Dimension(50, 20));
        close.addActionListener(e -> {
            this.taskbarIcon.setVisible(false);
            this.window.setVisible(false);
        });

        JPanel buttonTray = new JPanel();
        buttonTray.setOpaque(false);
        buttonTray.add(minimize);
        buttonTray.add(close);

        titleBar.add(title, BorderLayout.WEST);
        titleBar.add(buttonTray, BorderLayout.EAST);
        if (appMenu != null) {
            this.window.add(appMenu);
        }

        titleBar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                prevPt = e.getPoint();
            }
        });
        titleBar.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Point currentPt = e.getPoint();
                window.setLocation(
                        window.getX() + (int) (currentPt.getX() - prevPt.getX()),
                        window.getY() + (int) (currentPt.getY() - prevPt.getY()));
            }
        });

        this.content = new JPanel();

        this.window.setVisible(false);
        this.window.add(titleBar, BorderLayout.NORTH);
        this.window.add(this.content, BorderLayout.CENTER);
        this.window.setLocation(50, 50);
        this.window.setSize(200, 200);
    }

    protected void setupWindow(JMenuBar menu) {
        this.window = new JPanel(new BorderLayout());
        this.window.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        JPanel titleBar = new JPanel(new BorderLayout());
        titleBar.setBorder(new EmptyBorder(0, 0, 0, 0));
        titleBar.setPreferredSize(new Dimension(200, 50));
        titleBar.setBackground(new Color(0x0000aa));

        JLabel title = new JLabel(this.appName);
        title.setForeground(Color.WHITE);

        JButton minimize = new JButton("--");
        minimize.setBackground(Application.GREY);
        minimize.setPreferredSize(new Dimension(50, 20));
        minimize.addActionListener(e -> this.window.setVisible(!this.window.isShowing()));

        JButton close = new JButton("X");
        close.setBackground(Application.GREY);
        close.setPreferredSize(new Dimension(50, 20));
        close.addActionListener(e -> {
            this.taskbarIcon.setVisible(false);
            this.window.setVisible(false);
        });

        JPanel buttonTray = new JPanel();
        buttonTray.setOpaque(false);
        buttonTray.add(minimize);
        buttonTray.add(close);

        titleBar.add(title, BorderLayout.WEST);
        titleBar.add(buttonTray, BorderLayout.EAST);
        titleBar.add(menu, BorderLayout.SOUTH);

        titleBar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                prevPt = e.getPoint();
            }
        });
        titleBar.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Point currentPt = e.getPoint();
                window.setLocation(
                        window.getX() + (int) (currentPt.getX() - prevPt.getX()),
                        window.getY() + (int) (currentPt.getY() - prevPt.getY()));
            }
        });

        this.content = new JPanel();

        this.window.setVisible(false);
        this.window.add(titleBar, BorderLayout.NORTH);
        this.window.add(this.content, BorderLayout.CENTER);
        this.window.setLocation(50, 50);
        this.window.setSize(200, 200);
    }

    public JPanel getWindow() {
        return window;
    }

    public JButton getDesktopIcon() {
        return desktopIcon;
    }

    public JButton getTaskbarIcon() {
        return taskbarIcon;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO document why this method is empty
    }
}