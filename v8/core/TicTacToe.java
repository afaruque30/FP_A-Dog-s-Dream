package core;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import components.Application;

public class TicTacToe extends Application {
    private boolean playerTurn;
    private int[][] board;

    public TicTacToe(JPanel desktop, Taskbar taskbar, JLayeredPane appsPane) {
        super("TicTacToe", "./assets/game.png", desktop, taskbar, appsPane);
        this.playerTurn = true;
        this.board = new int[][] {
                { 0, 0, 0 },
                { 0, 0, 0 },
                { 0, 0, 0 }
        };
    }

    @Override
    protected void setupWindow() {
        super.setupWindow();

        this.window.setSize(300, 300);

        this.content.setBackground(GREY);
        this.content.setLayout(new BorderLayout());
        this.content.setBorder(new EmptyBorder(4, 40, 4, 40));

        JPanel gameGrid = new JPanel(new GridLayout(3, 3, 4, 4));
        gameGrid.setPreferredSize(new Dimension(200, 200));
        gameGrid.setOpaque(false);

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                JButton button = new JButton() {
                    
                };
                button.setBackground(GREY);
                button.addActionListener(e -> {

                });
                gameGrid.add(button);
            }
        }

        this.content.add(gameGrid, BorderLayout.NORTH);
    }
}