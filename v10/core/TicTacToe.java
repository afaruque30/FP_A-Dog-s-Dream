package core;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import components.Application;

public class TicTacToe extends Application {
    private JButton[][] board;
    private JButton retryButton;
    private Random random;

    public TicTacToe(JPanel desktop, Taskbar taskbar, JLayeredPane appsPane) {
        super("TicTacToe", "./assets/game.png", desktop, taskbar, appsPane);
        this.random = new Random();
    }

    @Override
    protected void setupWindow() {
        super.setupWindow();
        this.board = new JButton[3][3];
        this.retryButton = new JButton();

        this.window.setSize(300, 300);

        this.content.setBackground(GREY);
        this.content.setLayout(new BorderLayout());
        this.content.setBorder(new EmptyBorder(4, 40, 4, 40));

        JPanel gameGrid = new JPanel(new GridLayout(3, 3, 4, 4));
        gameGrid.setPreferredSize(new Dimension(200, 200));
        gameGrid.setOpaque(false);

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                JButton button = new JButton();
                button.setBackground(GREY);
                button.addActionListener(e -> {
                    if (button.getText().equals("")) {
                        button.setText("X");
                        updateGame();
                    }
                });
                this.board[y][x] = button;
                gameGrid.add(button);
            }
        }

        this.retryButton.setBackground(GREY);
        this.retryButton.setEnabled(false);
        this.retryButton.addActionListener(e -> {
            for (JButton[] row : this.board) {
                for (JButton button : row) {
                    button.setText("");
                }
            }
            this.retryButton.setEnabled(false);
        });

        this.content.add(gameGrid, BorderLayout.NORTH);
        this.content.add(this.retryButton, BorderLayout.CENTER);
    }

    public void updateGame() {
        if (checkWin() == 0) {
            JButton button = this.board[this.random.nextInt(3)][this.random.nextInt(3)];
            while (!"".equals(button.getText())) {
                button = this.board[this.random.nextInt(3)][this.random.nextInt(3)];
            }
            button.setText("O");
            if (checkWin() != 0) {
                this.retryButton.setText((checkWin() == 1 ? "Player" : "Computer") + " Wins!");
                this.retryButton.setEnabled(true);
            }
        } else {
            this.retryButton.setText((checkWin() == 1 ? "Player" : "Computer") + " Wins!");
            this.retryButton.setEnabled(true);
        }
    }

    public int checkWin() {
        int[][][] winCons = {
                { { 0, 0 }, { 0, 1 }, { 0, 2 } },
                { { 1, 0 }, { 1, 1 }, { 1, 2 } },
                { { 2, 0 }, { 2, 1 }, { 2, 2 } },
                { { 0, 0 }, { 1, 0 }, { 2, 0 } },
                { { 0, 1 }, { 1, 1 }, { 2, 1 } },
                { { 0, 2 }, { 1, 2 }, { 2, 2 } },
                { { 0, 0 }, { 1, 1 }, { 2, 2 } },
                { { 0, 2 }, { 1, 1 }, { 2, 0 } }
        };
        for (int[][] winCon : winCons) {
            String con = this.board[winCon[0][0]][winCon[0][1]].getText() +
                    this.board[winCon[1][0]][winCon[1][1]].getText() +
                    this.board[winCon[2][0]][winCon[2][1]].getText();
            if ("XXX".equals(con))
                return 1;
            if ("OOO".equals(con))
                return 2;
        }
        return 0;
    }
}