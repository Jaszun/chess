package com.company.Pieces;

import com.company.Frontend.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Knight extends Piece{
    public Knight(int color) {
        super(color);

        switch (color){
            case 0:
                super.setPath("res/pieces/007-knight.png");
                break;
            default:
                super.setPath("res/pieces/008-knight-1.png");
        }
    }

    @Override
    public int[][] validate(int[] from, int pieceColor, View view) {
        List<Integer[]> validMoveCoordinatesList = new ArrayList<>();

        if (from[0] > 1){
            if (from[1] > 0){
                if (!view.getBoardFields()[from[0] - 2][from[1] - 1].isOccupied()
                        || (view.getBoardFields()[from[0] - 2][from[1] - 1].isOccupied()
                        && view.getPieces()[from[0] - 2][from[1] - 1].getColor() != pieceColor)){

                    validMoveCoordinatesList.add(new Integer[]{from[0] - 2, from[1] - 1});
                }
            }

            if (from[1] < 7){
                if (!view.getBoardFields()[from[0] - 2][from[1] + 1].isOccupied()
                        || (view.getBoardFields()[from[0] - 2][from[1] + 1].isOccupied()
                        && view.getPieces()[from[0] - 2][from[1] + 1].getColor() != pieceColor)){

                    validMoveCoordinatesList.add(new Integer[]{from[0] - 2, from[1] + 1});
                }
            }
        }

        if (from[0] < 6){
            if (from[1] > 0){
                if (!view.getBoardFields()[from[0] + 2][from[1] - 1].isOccupied()
                        || (view.getBoardFields()[from[0] + 2][from[1] - 1].isOccupied()
                        && view.getPieces()[from[0] + 2][from[1] - 1].getColor() != pieceColor)){

                    validMoveCoordinatesList.add(new Integer[]{from[0] + 2, from[1] - 1});
                }
            }

            if (from[1] < 7){
                if (!view.getBoardFields()[from[0] + 2][from[1] + 1].isOccupied()
                        || (view.getBoardFields()[from[0] + 2][from[1] + 1].isOccupied()
                        && view.getPieces()[from[0] + 2][from[1] + 1].getColor() != pieceColor)){

                    validMoveCoordinatesList.add(new Integer[]{from[0] + 2, from[1] + 1});
                }
            }
        }

        if (from[1] > 1){
            if (from[0] > 0){
                if (!view.getBoardFields()[from[0] - 1][from[1] - 2].isOccupied()
                        || (view.getBoardFields()[from[0] - 1][from[1] - 2].isOccupied()
                        && view.getPieces()[from[0] - 1][from[1] - 2].getColor() != pieceColor)){

                    validMoveCoordinatesList.add(new Integer[]{from[0] - 1, from[1] - 2});
                }
            }

            if (from[0] < 7){
                if (!view.getBoardFields()[from[0] + 1][from[1] - 2].isOccupied()
                        || (view.getBoardFields()[from[0] + 1][from[1] - 2].isOccupied()
                        && view.getPieces()[from[0] + 1][from[1] - 2].getColor() != pieceColor)){

                    validMoveCoordinatesList.add(new Integer[]{from[0] + 1, from[1] - 2});
                }
            }
        }

        if (from[1] < 6){
            if (from[0] > 0){
                if (!view.getBoardFields()[from[0] - 1][from[1] + 2].isOccupied()
                        || (view.getBoardFields()[from[0] - 1][from[1] + 2].isOccupied()
                        && view.getPieces()[from[0] - 1][from[1] + 2].getColor() != pieceColor)){

                    validMoveCoordinatesList.add(new Integer[]{from[0] - 1, from[1] + 2});
                }
            }

            if (from[0] < 7){
                if (!view.getBoardFields()[from[0] + 1][from[1] + 2].isOccupied()
                        || (view.getBoardFields()[from[0] + 1][from[1] + 2].isOccupied()
                        && view.getPieces()[from[0] + 1][from[1] + 2].getColor() != pieceColor)){

                    validMoveCoordinatesList.add(new Integer[]{from[0] + 1, from[1] + 2});
                }
            }
        }

        int[][] validMoveCoordinates = new int[validMoveCoordinatesList.size()][];

        int i = 0;

        for (Integer[] j : validMoveCoordinatesList) {
            validMoveCoordinates[i++] = new int[]{j[0], j[1]};
        }

//        for (int[] j : validMoveCoordinates) {
//            System.out.println(Arrays.toString(j));
//        }

        return validMoveCoordinates;
    }
}
