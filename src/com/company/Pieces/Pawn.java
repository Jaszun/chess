package com.company.Pieces;

import com.company.Frontend.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pawn extends Piece{
    public Pawn(int color) {
        super(color);

        switch (color){
            case 0:
                super.setPath("res/pieces/011-strategy.png");
                break;
            default:
                super.setPath("res/pieces/012-strategy-1.png");
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int[][] validate(int[] from, int pieceColor, View view) {
        List<Integer[]> validMoveCoordinatesList = new ArrayList<>();

        if (from[1] != 0 && from[1] != 7) {

            int distance;

            if ((pieceColor == 1 && from[1] == 1 && !view.getBoardFields()[from[0]][from[1] + 1].isOccupied())
                    || (pieceColor == 0 && from[1] == 6 && !view.getBoardFields()[from[0]][from[1] - 1].isOccupied())) distance = 2;
            else distance = 1;

            int direction = (pieceColor == 0 ? -1 : 1);

            for (int i = 1; i <= distance; i++) {
                if (from[1] + (i * direction) >= 0
                        && from[1] + (i * direction) <= 7
                        && !view.getBoardFields()[from[0]][from[1] + (i * direction)].isOccupied()) {
                    validMoveCoordinatesList.add(new Integer[]{from[0], from[1] + (i * direction)});
                }
            }

            if (from[0] + (1 * direction) >= 0 && from[0] + (1 * direction) <= 7) {
                if (view.getBoardFields()[from[0] + (1 * direction)][from[1] + (1 * direction)].isOccupied()
                        && view.getPieces()[from[0] + (1 * direction)][from[1] + (1 * direction)].getColor() != super.getColor()) {
                    validMoveCoordinatesList.add(new Integer[]{from[0] + (1 * direction), from[1] + (1 * direction)});
                }
            }

            if (from[0] - (1 * direction) >= 0 && from[0] - (1 * direction) <= 7) {
                if (view.getBoardFields()[from[0] - (1 * direction)][from[1] + (1 * direction)].isOccupied()
                        && view.getPieces()[from[0] - (1 * direction)][from[1] + (1 * direction)].getColor() != super.getColor()) {
                    validMoveCoordinatesList.add(new Integer[]{from[0] - (1 * direction), from[1] + (1 * direction)});
                }
            }

            boolean onRight = false;
            boolean onLeft = false;

            if (super.getColor() == 1 && from[1] == 4){
                if (from[0] != 0) onLeft = true;
                if (from[0] != 7) onRight = true;

                if (onLeft){
                    if (view.getBoardFields()[from[0] - 1][from[1]].isOccupied()
                        && view.getPieces()[from[0] - 1][from[1]] instanceof Pawn
                        && !view.getBoardFields()[from[0] - 1][from[1] + 1].isOccupied()){
                        validMoveCoordinatesList.add(new Integer[]{from[0] - 1, from[1] + 1});
                    }
                }

                if (onRight){
                    if (view.getBoardFields()[from[0] + 1][from[1]].isOccupied()
                            && view.getPieces()[from[0] + 1][from[1]] instanceof Pawn
                            && !view.getBoardFields()[from[0] + 1][from[1] + 1].isOccupied()){
                        validMoveCoordinatesList.add(new Integer[]{from[0] + 1, from[1] + 1});
                    }
                }
            }

            else if (super.getColor() == 0 && from[1] == 3){
                if (from[0] != 7) onLeft = true;
                if (from[0] != 0) onRight = true;

                if (onLeft){
                    if (view.getBoardFields()[from[0] + 1][from[1]].isOccupied()
                            && view.getPieces()[from[0] + 1][from[1]] instanceof Pawn
                            && !view.getBoardFields()[from[0] + 1][from[1] - 1].isOccupied()){
                        validMoveCoordinatesList.add(new Integer[]{from[0] + 1, from[1] - 1});
                    }
                }

                if (onRight){
                    if (view.getBoardFields()[from[0] - 1][from[1]].isOccupied()
                            && view.getPieces()[from[0] - 1][from[1]] instanceof Pawn
                            && !view.getBoardFields()[from[0] - 1][from[1] - 1].isOccupied()){
                        validMoveCoordinatesList.add(new Integer[]{from[0] - 1, from[1] - 1});
                    }
                }
            }

            int[][] validMoveCoordinates = new int[validMoveCoordinatesList.size()][];

            int i = 0;

            for (Integer[] j : validMoveCoordinatesList) {
                validMoveCoordinates[i++] = new int[]{j[0], j[1]};
            }

//            for (int[] j : validMoveCoordinates) {
//                System.out.println(Arrays.toString(j));
//            }

            return validMoveCoordinates;
        }

        return null;
    }
}
