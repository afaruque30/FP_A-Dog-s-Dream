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

import components.Application;

public class MSPaint extends Application {
    String currentColor;
    double strokeWidth;
    private final int blue = 255;
    private double history;
    private String prevOp;

    public MSPaint(JPanel desktop, Taskbar taskbar, JLayeredPane appsPane) {
        super("MS Paint", "./assets/paint.png", desktop, taskbar, appsPane);
        //TODO Auto-generated constructor stub
        this.history = 0;
        this.prevOp = "";
    }

    @Override
    protected void setupWindow() {
        super.setupWindow();

        this.window.setSize(1200, 800);

        this.content.setLayout(new BorderLayout());
        this.content.setBorder(new EmptyBorder(4, 4, 10, 4));
        this.content.setBackground(Application.GREY);

        JLabel display = new JLabel("");
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setPreferredSize(new Dimension(100, 30));
        display.setBorder(new EmptyBorder(4, 4, 4, 4));

        JPanel keyPad = new JPanel(new GridLayout(5, 4, 4, 6));
        keyPad.setOpaque(false);
        for (String numString : new String[] {
                "C", "√", "x²", "*",
                "1", "2", "3", "/",
                "4", "5", "6", "+",
                "7", "8", "9", "_",
                "-", "0", ".", "="
        }) {
            JButton key = new JButton(numString);
            key.setBackground(Application.GREY);
            key.addActionListener(e -> {
                Double displayVal;
                if ("".equals(display.getText())) {
                    displayVal = 0.0;
                } else {
                    displayVal = Double.parseDouble(display.getText());
                }
                String text = ((JButton) e.getSource()).getText();
                String[] ops = { "*", "/", "+", "_", "=" };
                String[] specs = { "C", "√", "x²" };
                String[] nums = {
                        "1", "2", "3",
                        "4", "5", "6",
                        "7", "8", "9",
                        "-", "0", "."
                };
                if (Arrays.asList(ops).contains(text)) {
                    switch (this.prevOp) {
                        case "*":
                            this.history *= displayVal;
                            break;
                        case "/":
                            if (displayVal != 0) {
                                this.history /= displayVal;
                            }
                            break;
                        case "+":
                            this.history += displayVal;
                            break;
                        case "_":
                            this.history -= displayVal;
                            break;
                        default:
                            this.history = displayVal;
                    }
                    this.prevOp = text;
                    if (!"=".equals(text)) {
                        display.setText("");
                    } else {
                        display.setText(String.format("%.0f", this.history));
                    }
                } else if (Arrays.asList(specs).contains(text)) {
                    switch (text) {
                        case "C":
                            display.setText("");
                            this.history = 0;
                            this.prevOp = "";
                            break;
                        case "√":
                            display.setText(String.valueOf(Math.sqrt(displayVal)));
                            break;
                        case "x²":
                            display.setText(String.valueOf(Math.pow(displayVal, 2)));
                            break;
                        default:
                    }
                } else if (Arrays.asList(nums).contains(text)) {
                    switch (text) {
                        case "-":
                            if (!"".equals(display.getText())) {
                                if (display.getText().charAt(0) == '-') {
                                    display.setText(display.getText().substring(1));
                                } else {
                                    display.setText('-' + display.getText());
                                }
                            }
                            break;
                        case ".":
                            if (!"".equals(display.getText())
                                    && !display.getText().contains(".")) {
                                display.setText(display.getText() + '.');
                            }
                            break;
                        default:
                            display.setText(display.getText() + text);
                    }
                }
            });
            keyPad.add(key);
        }

        this.content.add(display, BorderLayout.NORTH);
        this.content.add(keyPad, BorderLayout.SOUTH);
    }


    // @TODO add event listeners for mousedown; mouseadapters
    // we might also need to override the default ones
}
