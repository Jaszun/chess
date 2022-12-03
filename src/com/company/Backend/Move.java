package com.company.Backend;

import com.company.Pieces.Piece;

public class Move {
    private int[] from;
    private int[] to;
    private Piece piece;
    private int[][] validatedCoordinates;

    public Move(){}

    public int[] getFrom() {
        return from;
    }

    public void setFrom(int[] from, Piece piece, int[][] validatedCoordinates) {
        this.from = from;
        this.piece = piece;
        this.validatedCoordinates = validatedCoordinates;
    }

    public int[] getTo() {
        return to;
    }

    public void restartMove(){
        from = to = null;
        validatedCoordinates = null;
        piece = null;
    }

    public int[] setTo(int[] to) {
        from = null;

        this.to = to;

        for (int[] i : validatedCoordinates){
            if (i[0] == to[0] && i[1] == to[1]){
                System.out.println("jeszcze jak");
                return i;
            }
        }

        this.to = null;

        return null;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
