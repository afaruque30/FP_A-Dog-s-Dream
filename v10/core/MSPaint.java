package core;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Color;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import components.Application;

public class MSPaint extends Application {
    String currentColor;
    double strokeWidth = 20;
    JPanel display;
    boolean isDrawing = false;

    protected static final Color yellow = new Color(255, 255, 0);
    protected static final Color green = new Color(0, 128, 0);
    protected static final Color cyan = new Color(0, 255, 255);
    protected static final Color blue = new Color(0, 0, 255);
    protected static final Color magenta = new Color(255, 0, 255);
    protected static final Color pink = new Color(255, 20, 147);
    protected static final Color red = new Color(255, 0, 0);

    public MSPaint(JPanel desktop, Taskbar taskbar, JLayeredPane appsPane) {
        super("MS Paint", "./assets/paint.png", desktop, taskbar, appsPane);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void setupWindow() {
        super.setupWindow();

        this.window.setSize(1200, 800);

        this.content.setLayout(new BorderLayout());
        this.content.setBorder(new EmptyBorder(4, 4, 4, 4));
        this.content.setBackground(Application.GREY);

        display = new JPanel();
        display.setPreferredSize(new Dimension(1100, 692));
        display.setBorder(new EmptyBorder(4, 4, 4, 4));

        JPanel keyPad = new JPanel(new GridLayout(2, 4, 4, 4));
        keyPad.setOpaque(false);
        Color[] colorArray = new Color[] { yellow, green, cyan, blue, magenta, pink, red, Color.white };
        int i = 0;
        for (String buttonColor : new String[] {
                "yellow", "green", "cyan", "blue",
                "magenta", "pink", "red", "eraser"
        }) {
            JButton key = new JButton(buttonColor);
            key.setOpaque(true);
            key.setBackground(colorArray[i]);
            keyPad.add(key);
            i++;
            this.content.add(display, BorderLayout.NORTH);
            this.content.add(keyPad, BorderLayout.SOUTH);
        }

        // add mouse listener to the jpanel display
        display.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                isDrawing = true;
                paint(evt.getX(), evt.getY());
                System.out.println("Mouse pressed at: " + evt.getX() + ", " + evt.getY());
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                System.out.println("mouse released");
                isDrawing = false;
            }
        });

        display.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                System.out.println("mouse dragged");
                paint(evt.getX(), evt.getY());
                isDrawing = true;
            }

            @Override
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                System.out.println("mouse moved, at: " + evt.getX() + ", " + evt.getY());
                if (isDrawing) {
                    paint(evt.getX(), evt.getY());
                }
            }
        });
    }

    protected void paint(int x, int y) {
        System.out.println(x + " " + y);
        Graphics g = this.display.getGraphics();
        g.setColor(Color.BLACK);
        g.fillOval(x, y, (int) this.strokeWidth, (int) this.strokeWidth);

    }

    // @TODO add event listeners for mousedown; mouseadapters
    // we might also need to override the default ones
}
