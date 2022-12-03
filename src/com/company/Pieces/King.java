package com.company.Pieces;

import com.company.Frontend.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class King extends Piece{
    private boolean moved = false;

    public King(int color) {
        super(color);

        switch (color){
            case 0:
                super.setPath("res/pieces/001-king.png");
                break;
            default:
                super.setPath("res/pieces/002-king-1.png");
        }
    }

    public boolean isMoved() {
        return moved;
    }

    public void setMoved(boolean moved) {
        this.moved = moved;
    }

    @Override
    public int[][] validate(int[] from, int pieceColor, View view) {
        List<Integer[]> validMoveCoordinatesList = new ArrayList<>();

        if (from[0] > 0){
            if (!view.getBoardFields()[from[0] - 1][from[1]].isOccupied()
                    || (view.getBoardFields()[from[0] - 1][from[1]].isOccupied()
                    && view.getPieces()[from[0] - 1][from[1]].getColor() != pieceColor))

                validMoveCoordinatesList.add(new Integer[]{from[0] - 1, from[1]});

            if (from[1] > 0){
                if (!view.getBoardFields()[from[0] - 1][from[1] - 1].isOccupied()
                        || (view.getBoardFields()[from[0] - 1][from[1] - 1].isOccupied()
                        && view.getPieces()[from[0] - 1][from[1] - 1].getColor() != pieceColor)){

                    validMoveCoordinatesList.add(new Integer[]{from[0] - 1, from[1] - 1});
                }
            }

            if (from[1] < 7){
                if (!view.getBoardFields()[from[0] - 1][from[1] + 1].isOccupied()
                        || (view.getBoardFields()[from[0] - 1][from[1] + 1].isOccupied()
                        && view.getPieces()[from[0] - 1][from[1] + 1].getColor() != pieceColor)){

                    validMoveCoordinatesList.add(new Integer[]{from[0] - 1, from[1] + 1});
                }
            }
        }

        if (from[0] < 7){
            if (!view.getBoardFields()[from[0] + 1][from[1]].isOccupied()
                    || (view.getBoardFields()[from[0] + 1][from[1]].isOccupied()
                    && view.getPieces()[from[0] + 1][from[1]].getColor() != pieceColor))

                validMoveCoordinatesList.add(new Integer[]{from[0] + 1, from[1]});

            if (from[1] > 0){
                if (!view.getBoardFields()[from[0] + 1][from[1] - 1].isOccupied()
                        || (view.getBoardFields()[from[0] + 2][from[1] - 1].isOccupied()
                        && view.getPieces()[from[0] + 1][from[1] - 1].getColor() != pieceColor)){

                    validMoveCoordinatesList.add(new Integer[]{from[0] + 1, from[1] - 1});
                }
            }

            if (from[1] < 7){
                if (!view.getBoardFields()[from[0] + 1][from[1] + 1].isOccupied()
                        || (view.getBoardFields()[from[0] + 1][from[1] + 1].isOccupied()
                        && view.getPieces()[from[0] + 1][from[1] + 1].getColor() != pieceColor)){

                    validMoveCoordinatesList.add(new Integer[]{from[0] + 1, from[1] + 1});
                }
            }
        }

        if (from[1] > 0){
            if (!view.getBoardFields()[from[0]][from[1] - 1].isOccupied()
                    || (view.getBoardFields()[from[0]][from[1] - 1].isOccupied()
                    && view.getPieces()[from[0]][from[1] - 1].getColor() != pieceColor))

                validMoveCoordinatesList.add(new Integer[]{from[0], from[1] - 1});

            if (from[0] > 0){
                if (!view.getBoardFields()[from[0] - 1][from[1] - 1].isOccupied()
                        || (view.getBoardFields()[from[0] - 1][from[1] - 1].isOccupied()
                        && view.getPieces()[from[0] - 1][from[1] - 1].getColor() != pieceColor)){

                    validMoveCoordinatesList.add(new Integer[]{from[0] - 1, from[1] - 1});
                }
            }

            if (from[0] < 7){
                if (!view.getBoardFields()[from[0] + 1][from[1] - 1].isOccupied()
                        || (view.getBoardFields()[from[0] + 1][from[1] - 1].isOccupied()
                        && view.getPieces()[from[0] + 1][from[1] - 1].getColor() != pieceColor)){

                    validMoveCoordinatesList.add(new Integer[]{from[0] + 1, from[1] - 1});
                }
            }
        }

        if (from[1] < 7){
            if (!view.getBoardFields()[from[0]][from[1] + 1].isOccupied()
                    || (view.getBoardFields()[from[0]][from[1] + 1].isOccupied()
                    && view.getPieces()[from[0]][from[1] + 1].getColor() != pieceColor))

                validMoveCoordinatesList.add(new Integer[]{from[0], from[1] + 1});

            if (from[0] > 0){
                if (!view.getBoardFields()[from[0] - 1][from[1] + 1].isOccupied()
                        || (view.getBoardFields()[from[0] - 1][from[1] + 1].isOccupied()
                        && view.getPieces()[from[0] - 1][from[1] + 1].getColor() != pieceColor)){

                    validMoveCoordinatesList.add(new Integer[]{from[0] - 1, from[1] + 1});
                }
            }

            if (from[0] < 7){
                if (!view.getBoardFields()[from[0] + 1][from[1] + 1].isOccupied()
                        || (view.getBoardFields()[from[0] + 1][from[1] + 1].isOccupied()
                        && view.getPieces()[from[0] + 1][from[1] + 1].getColor() != pieceColor)){

                    validMoveCoordinatesList.add(new Integer[]{from[0] + 1, from[1] + 1});
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

    public int[][] validateForKing(int[][] kingCoords, int[][] opponentCoords, Piece opponent, int[] opponentPosition){
        List<Integer[]> newCoordinates = new ArrayList<>();

        for (int[] i : kingCoords){
            newCoordinates.add(new Integer[]{i[0], i[1]});
        }

        for (int i = 0; i < opponentCoords.length; i++){
            for (int j = 0; j < newCoordinates.size(); j++){
                if (opponent instanceof Pawn){
                    //TODO

//                    int direction = (opponent.getColor() == 1 ? 1 : -1);
//
////                    System.out.println("[" + opponentCoords[i][0] + ", " + opponentPosition[1] + "]");
//
//                    if (opponentPosition[1] + direction == newCoordinates.get(j)[1]
//                        && (opponentCoords[i][0] + 1 == newCoordinates.get(j)[0]
//                            || opponentCoords[i][0] - 1 == newCoordinates.get(j)[0])){
//
//                        System.out.println((opponentCoords[i][0] + 1) + " " + (opponentCoords[i][0] - 1) + " " + (opponentPosition[1] + direction));
//
//                        newCoordinates.remove(j);
//                    }
                }

                else if (opponentCoords[i][0] == (int) newCoordinates.get(j)[0]
                        && opponentCoords[i][1] == (int) newCoordinates.get(j)[1]){
                        System.out.println(Arrays.toString(newCoordinates.get(j)) + " usuniete");
                        newCoordinates.remove(j);
                }
            }
        }

        int j = 0;

        int[][] newCoordinatesInt = new int[newCoordinates.size()][];

        for (Integer[] i : newCoordinates) {
            newCoordinatesInt[j++] = new int[]{i[0], i[1]};
        }

        return newCoordinatesInt;
    }
}
