import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TicTacToe extends JFrame implements ActionListener {
    private JButton a1;
    private JButton a2;
    private JButton a3;
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton c1;
    private JButton c2;
    private JButton c3;

    public TicTacToe() {
        a1 = new JButton("");
        a2 = new JButton("");
        a3 = new JButton("");
        b1 = new JButton("");
        b2 = new JButton("");
        b3 = new JButton("");
        c3 = new JButton("");
        c1 = new JButton("");
        c2 = new JButton("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}