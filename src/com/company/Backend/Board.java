package com.company.Backend;

import com.company.Pieces.*;

public class Board {
    private Piece[][] board;

    public Board(){
        board = new Piece[8][8];

        prepereBoard();
    }

    private void prepereBoard(){
        for (int i = 0; i < 4; i++){
            board[i][1] = board[7 - i][1] = new Pawn(1);
            board[i][6] = board[7 - i][6] = new Pawn(0);

            switch (i){
                case 0:
                    board[0][0] = board[7][0] = new Rook(1);
                    board[0][7] = board[7][7] = new Rook(0);
                    break;
                case 1:
                    board[1][0] = board[6][0] = new Knight(1);
                    board[1][7] = board[6][7] = new Knight(0);
                    break;
                case 2:
                    board[2][0] = board[5][0] = new Bishop(1);
                    board[2][7] = board[5][7] = new Bishop(0);
                    break;
                case 3:
                    board[3][0] = new Queen(1);
                    board[4][0] = new King(1);
                    board[3][7] = new Queen(0);
                    board[4][7] = new King(0);
                    break;
            }
        }
    }

    public Piece[][] getBoard() {
        return board;
    }

    public void setBoard(Piece[][] board) {
        this.board = board;
    }
}
