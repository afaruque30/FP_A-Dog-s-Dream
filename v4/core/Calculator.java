package core;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {
    private String displayText;
    private JLabel display;
    private JButton nm1;
    private JButton nm2;
    private JButton nm3;
    private JButton nm4;
    private JButton nm5;
    private JButton nm6;
    private JButton nm7;
    private JButton nm8;
    private JButton nm9;
    private JButton nm0;
    private JButton cle;
    private JButton sqt; // sqrt
    private JButton sqr; // square
    private JButton add;
    private JButton sub;
    private JButton mul;
    private JButton div;
    private JButton neg;
    private JButton dec;
    private JButton equ;
    private double prevNum;
    private String prevOp;

    public Calculator() {
        this.setTitle("Calculator");
        this.setSize(225, 250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);

        this.displayText = "";
        this.prevNum = 0;
        this.prevOp = "";
        this.display = new JLabel(this.displayText);
        this.display.setHorizontalAlignment(JLabel.RIGHT);
        this.display.setPreferredSize(new Dimension(225, 30));

        this.nm1 = new JButton("1");
        this.nm2 = new JButton("2");
        this.nm3 = new JButton("3");
        this.nm4 = new JButton("4");
        this.nm5 = new JButton("5");
        this.nm6 = new JButton("6");
        this.nm7 = new JButton("7");
        this.nm8 = new JButton("8");
        this.nm9 = new JButton("9");
        this.nm0 = new JButton("0");
        this.cle = new JButton("C");
        this.sqt = new JButton("√");
        this.sqr = new JButton("x²");
        this.add = new JButton("+");
        this.sub = new JButton("_");
        this.mul = new JButton("*");
        this.div = new JButton("/");
        this.neg = new JButton("-");
        this.dec = new JButton(".");
        this.equ = new JButton("=");

        this.nm1.addActionListener(this);
        this.nm2.addActionListener(this);
        this.nm3.addActionListener(this);
        this.nm4.addActionListener(this);
        this.nm5.addActionListener(this);
        this.nm6.addActionListener(this);
        this.nm7.addActionListener(this);
        this.nm8.addActionListener(this);
        this.nm9.addActionListener(this);
        this.nm0.addActionListener(this);
        this.cle.addActionListener(this);
        this.sqt.addActionListener(this);
        this.sqr.addActionListener(this);
        this.add.addActionListener(this);
        this.sub.addActionListener(this);
        this.mul.addActionListener(this);
        this.div.addActionListener(this);
        this.neg.addActionListener(this);
        this.dec.addActionListener(this);
        this.equ.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 5, 10));

        this.add(this.display, BorderLayout.NORTH);
        panel.add(this.cle);
        panel.add(this.sqt);
        panel.add(this.sqr);
        panel.add(this.mul);
        panel.add(this.nm1);
        panel.add(this.nm2);
        panel.add(this.nm3);
        panel.add(this.div);
        panel.add(this.nm4);
        panel.add(this.nm5);
        panel.add(this.nm6);
        panel.add(this.add);
        panel.add(this.nm7);
        panel.add(this.nm8);
        panel.add(this.nm9);
        panel.add(this.sub);
        panel.add(this.dec);
        panel.add(this.nm0);
        panel.add(this.neg);
        panel.add(this.equ);

        this.add(panel);
        // this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.displayText = this.display.getText();

        if (e.getSource() == this.nm1 || e.getSource() == this.nm2 || e.getSource() == this.nm3
                || e.getSource() == this.nm4 || e.getSource() == this.nm5 || e.getSource() == this.nm6
                || e.getSource() == this.nm7 || e.getSource() == this.nm8 || e.getSource() == this.nm9
                || e.getSource() == this.nm0) {
            this.displayText += ((JButton) e.getSource()).getText();
        } else if (e.getSource() == this.dec) {
            if (!this.displayText.contains(".")) {
                this.displayText += ((JButton) e.getSource()).getText();
            }
        } else if (e.getSource() == this.neg) {
            if (this.displayText.charAt(0) == '-') {
                this.displayText = this.displayText.substring(1);
            } else {
                this.displayText = '-' + this.displayText;
            }
        } else if (e.getSource() == this.sqt) {
            double num = Double.parseDouble(this.displayText);
            if (num > 0) {
                this.displayText = String.valueOf(Math.sqrt(num));
            }
        } else if (e.getSource() == this.sqr) {
            double num = Double.parseDouble(this.displayText);
            this.displayText = String.valueOf(Math.pow(num, 2));
        } else if (e.getSource() == this.add) {
            this.prevNum = Double.parseDouble(doCalc(this.displayText));
            this.prevOp = "+";
            this.displayText = "";
        } else if (e.getSource() == this.sub) {
            this.prevNum = Double.parseDouble(doCalc(this.displayText));
            this.prevOp = "-";
            this.displayText = "";
        } else if (e.getSource() == this.mul) {
            this.prevNum = Double.parseDouble(doCalc(this.displayText));
            this.prevOp = "*";
            this.displayText = "";
        } else if (e.getSource() == this.div) {
            this.prevNum = Double.parseDouble(doCalc(this.displayText));
            this.prevOp = "/";
            this.displayText = "";
        } else if (e.getSource() == this.equ) {
            this.displayText = doCalc(this.displayText);
            this.prevOp = "";
        } else if (e.getSource() == this.cle) {
            this.displayText = "";
            this.prevNum = 0;
            this.prevOp = "";
        }
        this.display.setText(this.displayText);
    }

    public String doCalc(String curr) {
        if (curr != "") {
            String currOp = this.prevOp;
            this.prevOp = "";
            switch (currOp) {
                case "+":
                    return String.valueOf(this.prevNum + Double.parseDouble(curr));
                case "-":
                    return String.valueOf(this.prevNum - Double.parseDouble(curr));
                case "*":
                    return String.valueOf(this.prevNum * Double.parseDouble(curr));
                case "/":
                    if (Double.parseDouble(curr) != 0) {
                        return String.valueOf(this.prevNum / Double.parseDouble(curr));
                    } else {
                        return curr;
                    }
                default:
                    return curr;
            }
        } else {
            return curr;
        }
    }
}
