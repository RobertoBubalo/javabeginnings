package com.robertobubalo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by rober on 07/07/2017.
 */
public class TicTacToeGUI extends JFrame {
    private Container pane;
    private String currentPlayer;
    private JButton [][] board;
    private boolean hasWinner;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem quit;
    private JMenuItem newGame;

    public TicTacToeGUI(){
        super();
        pane = getContentPane();
        pane.setLayout(new GridLayout(3,3));
        setTitle("Tic Tac Toe");
        setSize(500,500);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        currentPlayer = "X";
        board = new JButton[3][3];
        hasWinner = false;
        intializeTheBoard();
        intializeMenuBar();

        setVisible(true);
    }
    private void intializeMenuBar(){
        menuBar = new JMenuBar();
        menu = new JMenu("File");

        newGame = new JMenuItem("New Game");
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetTheBoard();
            }
        });
        quit = new JMenuItem("Quit");
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        });

        menu.add(newGame);
        menu.add(quit);
        menuBar.add(menu);
        setJMenuBar(menuBar);

    }
    private void resetTheBoard(){
        currentPlayer = "X";
        hasWinner = false;
        for(int i = 0; i < 3; i++){
            for(int j=0; j<3; j++){
                board[i][j].setText("");
            }

        }
    }
    private void intializeTheBoard(){
        for(int i=0; i<3;i++){
            for(int j=0; j<3;j++){
                JButton btn = new JButton();
                btn.setFont(new Font(Font.SANS_SERIF,Font.BOLD,100));
                board[i][j] = btn;
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       if( ((JButton)e.getSource()).getText().equals("") && hasWinner==false ) {

                           btn.setText(currentPlayer);
                           hasWinner();
                           togglePlayer();
                       }
                    }
                });
                pane.add(btn);
            }
        }
    }
    private void togglePlayer(){
        if(currentPlayer.equals("X"))
            currentPlayer = "O";
        else
            currentPlayer = "X";

    }
    private void hasWinner(){
        if(board[0][0].getText().equals(currentPlayer) && board[1][0].getText().equals(currentPlayer) &&
                board[2][0].getText().equals(currentPlayer) ){
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
            hasWinner = true;
        }else if(board[0][1].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) &&
                board[2][2].getText().equals(currentPlayer) ){
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
            hasWinner = true;
        }else if(board[0][2].getText().equals(currentPlayer) && board[1][2].getText().equals(currentPlayer) &&
                board[2][2].getText().equals(currentPlayer) ){
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
            hasWinner = true;
        }else if(board[1][0].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) &&
                board[1][2].getText().equals(currentPlayer) ){
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
            hasWinner = true;
        }else if(board[0][0].getText().equals(currentPlayer) && board[0][1].getText().equals(currentPlayer) &&
                board[0][2].getText().equals(currentPlayer) ){
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
            hasWinner = true;
        }else if(board[2][0].getText().equals(currentPlayer) && board[2][1].getText().equals(currentPlayer) &&
                board[2][2].getText().equals(currentPlayer) ){
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
            hasWinner = true;
        }else if(board[0][0].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) &&
                board[2][2].getText().equals(currentPlayer) ){
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
            hasWinner = true;
        }else if(board[2][0].getText().equals(currentPlayer) && board[1][1].getText().equals(currentPlayer) &&
                board[0][2].getText().equals(currentPlayer) ){
            JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " has won");
            hasWinner = true;
        }

    }

}
