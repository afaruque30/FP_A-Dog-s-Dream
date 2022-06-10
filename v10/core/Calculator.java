package core;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import components.Application;

public class Calculator extends Application {
    private double history;
    private String prevOp;

    public Calculator(JPanel desktop, Taskbar taskbar, JLayeredPane appsPane) {
        super("Calculator", "./assets/calculator.png", desktop, taskbar, appsPane);
        this.history = 0;
        this.prevOp = "";
    }

    @Override
    protected void setupWindow() {
        super.setupWindow();

        this.window.setSize(200, 250);
        this.window.setFocusable(true);
        this.window.requestFocusInWindow();

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

        // add keyboard listeners for numbers and operators
        this.window.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent e) {
                System.out.println(e.getKeyChar());
                String text = String.valueOf(e.getKeyChar());
                String[] ops = { "*", "/", "+", "_", "=" };
                String[] specs = { "C", "√", "x²" };
                String[] nums = {
                        "1", "2", "3",
                        "4", "5", "6",
                        "7", "8", "9",
                        "-", "0", "."
                };
                if (Arrays.asList(ops).contains(text)) {
                    switch (prevOp) {
                        case "*":
                            history *= Double.parseDouble(display.getText());
                            break;
                        case "/":
                            if (Double.parseDouble(display.getText()) != 0) {
                                history /= Double.parseDouble(display.getText());
                            }
                            break;
                        case "+":
                            history += Double.parseDouble(display.getText());
                            break;
                        case "_":
                            history -= Double.parseDouble(display.getText());
                            break;
                        default:
                            history = Double.parseDouble(display.getText());
                    }
                    prevOp = text;
                    if (!"=".equals(text)) {
                        display.setText("");
                    } else {
                        display.setText(String.format("%.0f", history));
                    }
                } else if (Arrays.asList(specs).contains(text)) {
                    switch (text) {
                        case "C":
                            display.setText("");
                            history = 0;
                            prevOp = "";
                            break;
                        case "√":
                            display.setText(String.valueOf(Math.sqrt(Double.parseDouble(display.getText()))));
                            break;
                        case "x²":
                            display.setText(String.valueOf(Math.pow(Double.parseDouble(display.getText()), 2)));
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
            }

            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println(e.getKeyChar());
                // TODO Auto-generated method stub

            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                System.out.println(e.getKeyChar());

            }
        });

        this.content.add(display, BorderLayout.NORTH);
        this.content.add(keyPad, BorderLayout.SOUTH);
    }
}
