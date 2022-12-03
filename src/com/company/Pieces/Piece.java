package com.company.Pieces;

import com.company.Backend.MoveValidator;

public abstract class Piece implements MoveValidator {
    private int color; //1 - black | 0 - white
    private String path;

    public Piece(int color){
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Piece{" +
                "color=" + color +
                ", path='" + path + '\'' +
                '}';
    }
}
