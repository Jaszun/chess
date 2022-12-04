package com.company.Frontend;

import com.company.Backend.ChessClock;
import com.company.Backend.Move;
import com.company.Pieces.Piece;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//        JOptionPane.showMessageDialog(null, "Message");

public class View {
    private JFrame frame;
    private JPanel panel;
    private JLabel board;
    private Field[][] boardFields;
    private Piece[][] pieces;
    private Move move;
    private int gameLength;
    private ChessClock whiteClock;
    private ChessClock blackClock;
    private boolean isOn = true;

    public View(Piece[][] pieces, Move move){
        frame = new JFrame();
        panel = new JPanel();
        board = new JLabel();
        boardFields = new Field[8][8];
        this.pieces = pieces;
        this.move = move;

        init();

        gameLength = chooseGameLength();

        whiteClock = new ChessClock("whiteClock", true, gameLength);
        blackClock = new ChessClock("blackClock", false, gameLength);

        whiteClock.start();
        blackClock.start();
    }

    private void init(){
        panel.setOpaque(true);
        panel.setBackground(new Color(89, 53, 36));

        board.setBounds(25, 25, 400, 400);
        board.setOpaque(true);
        board.setVisible(true);
//        board.setLayout(new GridLayout(8, 8));
//        board.setComponentOrientation(ComponentOrientation.UNKNOWN);

        prepereBoard();

        panel.setLayout(null);
        panel.add(board);

        frame.setSize(700, 500);
        frame.setIconImage(new ImageIcon("res/pieces/010-queen.png").getImage());
        frame.setResizable(false);
        frame.setTitle("Szachy");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(panel);
    }

    public void changeClocks(){
        isOn = !isOn;

        System.out.println(isOn);

        whiteClock.setOn(isOn);
        blackClock.setOn(!isOn);
    }

    private void prepereBoard(){
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                Field field = new Field((i + j) % 2, new int[]{i, j}, this, move);

                field.setBounds((Field.FIELD_WIDTH) * i, (Field.FIELD_WIDTH) * j, Field.FIELD_WIDTH, Field.FIELD_WIDTH);

                boardFields[i][j] = field;

                if (pieces[i][j] != null) {
                    field.setOccupied(true);
                    field.getFieldForeground().setIcon(new ImageIcon(pieces[i][j].getPath()));
                }

                else field.setOccupied(false);

                board.add(field);
            }
        }
    }

    public void updateBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (pieces[i][j] != null) {
                    boardFields[i][j].setOccupied(true);
                    boardFields[i][j].getFieldForeground().setIcon(new ImageIcon(pieces[i][j].getPath()));
                } else {
                    boardFields[i][j].setOccupied(false);
                    boardFields[i][j].getFieldForeground().setIcon(null);
                }
            }
        }
    }

    public Piece getPiece(int[] position){
        return pieces[position[0]][position[1]];
    }

    public void setPiece(int[] position, Piece piece){
        pieces[position[0]][position[1]] = piece;
    }

    public void movePiece(int[] from, int[] to){
        pieces[to[0]][to[1]] = pieces[from[0]][from[1]];
        pieces[from[0]][from[1]] = null;
    }

    public Field[][] getBoardFields() {
        return boardFields;
    }

    public void setBoardFields(Field[][] boardFields) {
        this.boardFields = boardFields;
    }

    public void removePiece(int i, int j){
        pieces[i][j] = null;
    }

    public Piece[][] getPieces() {
        return pieces;
    }

    public void setPieces(Piece[][] pieces) {
        this.pieces = pieces;
    }

    private int chooseGameLength(){
        String[] choices = {"15", "30", "45", "60", "90"};

        JOptionPane optionPane = new JOptionPane();

        String input = (String) optionPane.showInputDialog(
                null,
                "Choose game length",
                "Choose game length",
                JOptionPane.QUESTION_MESSAGE,
                null,
                choices,
                choices[0]);


        return Integer.valueOf(input);
    }

    public ChessClock getWhiteClock() {
        return whiteClock;
    }

    public ChessClock getBlackClock() {
        return blackClock;
    }
}
