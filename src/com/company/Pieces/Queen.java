package com.company.Pieces;

import com.company.Frontend.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Queen extends Piece{
    public Queen(int color) {
        super(color);

        switch (color){
            case 0:
                super.setPath("res/pieces/009-queen-1.png");
                break;
            default:
                super.setPath("res/pieces/010-queen.png");
        }
    }

    @Override
    public int[][] validate(int[] from, int pieceColor, View view) {
        List<Integer[]> validMoveCoordinatesList = new ArrayList<>();

        for (int j = from[0]; j < 8; j++){
            if (j == from[0]){
                continue;
            }

            else if (!view.getBoardFields()[j][from[1]].isOccupied()){
                validMoveCoordinatesList.add(new Integer[]{j, from[1]});
            }

            else if (view.getBoardFields()[j][from[1]].isOccupied() && view.getPieces()[j][from[1]].getColor() != pieceColor){
                validMoveCoordinatesList.add(new Integer[]{j, from[1]});
                break;
            }

            else{
                break;
            }
        }

        for (int j = from[0]; j >= 0; j--){
            if (j == from[0]){
                continue;
            }

            else if (!view.getBoardFields()[j][from[1]].isOccupied()){
                validMoveCoordinatesList.add(new Integer[]{j, from[1]});
            }

            else if (view.getBoardFields()[j][from[1]].isOccupied() && view.getPieces()[j][from[1]].getColor() != pieceColor){
                validMoveCoordinatesList.add(new Integer[]{j, from[1]});
                break;
            }

            else{
                break;
            }
        }

        for (int j = from[1]; j < 8; j++){
            if (j == from[1]){
                continue;
            }

            else if (!view.getBoardFields()[from[0]][j].isOccupied()){
                validMoveCoordinatesList.add(new Integer[]{from[0], j});
            }

            else if (view.getBoardFields()[from[0]][j].isOccupied() && view.getPieces()[from[0]][j].getColor() != pieceColor){
                validMoveCoordinatesList.add(new Integer[]{from[0], j});
                break;
            }

            else{
                break;
            }
        }

        for (int j = from[1]; j >= 0; j--){
            if (j == from[1]){
                continue;
            }

            else if (!view.getBoardFields()[from[0]][j].isOccupied()){
                validMoveCoordinatesList.add(new Integer[]{from[0], j});
            }

            else if (view.getBoardFields()[from[0]][j].isOccupied() && view.getPieces()[from[0]][j].getColor() != pieceColor){
                validMoveCoordinatesList.add(new Integer[]{from[0], j});
                break;
            }

            else{
                break;
            }
        }

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
