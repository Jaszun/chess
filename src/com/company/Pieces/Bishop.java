package com.company.Pieces;

import com.company.Frontend.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bishop extends Piece{
    public Bishop(int color) {
        super(color);

        switch (color){
            case 0:
                super.setPath("res/pieces/003-bishop.png");
                break;
            default:
                super.setPath("res/pieces/004-bishop-1.png");
        }
    }

    @Override
    public int[][] validate(int[] from, int pieceColor, View view) {
        List<Integer[]> validMoveCoordinatesList = new ArrayList<>();

        int k = 0;

        for (int j = from[0] + 1; j < 8; j++){
            ++k;

            if (from[1] + k > 7){
                break;
            }

            if (!view.getBoardFields()[j][from[1] + k].isOccupied()){
                validMoveCoordinatesList.add(new Integer[]{j, from[1] + k});
            }

            else if (view.getBoardFields()[j][from[1] + k].isOccupied() && view.getPieces()[j][from[1] + k].getColor() != pieceColor){
                validMoveCoordinatesList.add(new Integer[]{j, from[1] + k});
                break;
            }

            else{
                break;
            }
        }

        k = 0;

        for (int j = from[0] - 1; j >= 0; j--){
            --k;

            if (from[1] + k < 0){
                break;
            }

            if (!view.getBoardFields()[j][from[1] + k].isOccupied()){
                validMoveCoordinatesList.add(new Integer[]{j, from[1] + k});
            }

            else if (view.getBoardFields()[j][from[1] + k].isOccupied() && view.getPieces()[j][from[1] + k].getColor() != pieceColor){
                validMoveCoordinatesList.add(new Integer[]{j, from[1] + k});
                break;
            }

            else{
                break;
            }
        }

        k = 0;

        for (int j = from[0] + 1; j < 8; j++){
            --k;

            if (from[1] + k < 0){
                break;
            }

            if (!view.getBoardFields()[j][from[1] + k].isOccupied()){
                validMoveCoordinatesList.add(new Integer[]{j, from[1] + k});
            }

            else if (view.getBoardFields()[j][from[1] + k].isOccupied() && view.getPieces()[j][from[1] + k].getColor() != pieceColor){
                validMoveCoordinatesList.add(new Integer[]{j, from[1] + k});
                break;
            }

            else{
                break;
            }
        }

        k = 0;

        for (int j = from[0] - 1; j >= 0; j--){
            ++k;

            if (from[1] + k > 7){
                break;
            }

            if (!view.getBoardFields()[j][from[1] + k].isOccupied()){
                validMoveCoordinatesList.add(new Integer[]{j, from[1] + k});
            }

            else if (view.getBoardFields()[j][from[1] + k].isOccupied() && view.getPieces()[j][from[1] + k].getColor() != pieceColor){
                validMoveCoordinatesList.add(new Integer[]{j, from[1] + k});
                break;
            }

            else{
                break;
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
