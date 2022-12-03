package com.company.Frontend;

import com.company.Backend.Move;
import com.company.Pieces.King;
import com.company.Pieces.Pawn;
import com.company.Pieces.Piece;
import com.company.Pieces.Rook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class Field extends JLabel {
    public static final int FIELD_WIDTH = 50;
    private int colorId;
    private int currentColorId;
    private boolean isOccupied;
    private boolean isClickable;
    private View view;
    private int[] position;
    private int[][] validatedCoordinates;

    private JLabel background;
    private JLabel foreground;

    public Field(int color, int[] position, View view, Move move) {
        isOccupied = false;
        isClickable = false;
        colorId = color;

        this.position = position;
        this.view = view;

        background = new JLabel();
        foreground = new JLabel();

        background.setVisible(true);
        background.setBounds(0, 0, 50, 50);

        foreground.setVisible(true);
        foreground.setBounds(0, 0, 50, 50);

        setVisible(true);

        setBackgroundColor(colorId);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                restartBoard();

                if (move.getFrom() == null
                    || (view.getBoardFields()[position[0]][position[1]].isOccupied
                        && view.getPieces()[position[0]][position[1]].getColor() == view.getPieces()[move.getFrom()[0]][move.getFrom()[1]].getColor())){

                    if (isOccupied){
                        Piece piece = view.getPieces()[position[0]][position[1]];

                        if (piece instanceof King && move.getPiece() != null){
                            int[][] tempKingValidCoordinates = piece.validate(position, move.getPiece().getColor(), view);

                            for (int i = 0; i < 8; i++){
                                for (int j = 0; j < 8; j++){
                                    if (view.getPieces()[i][j] != null && tempKingValidCoordinates != null && view.getPieces()[i][j].getColor() != piece.getColor()){
                                        tempKingValidCoordinates = ((King) piece).validateForKing(tempKingValidCoordinates, view.getPieces()[i][j].validate(new int[]{i, j}, view.getPieces()[i][j].getColor(), view), view.getPieces()[i][j], new int[]{i, j});
                                    }
                                }
                            }

                            validatedCoordinates = tempKingValidCoordinates;
                        }

                        else{
                            validatedCoordinates = piece.validate(position, piece.getColor(), view);
                        }

                        if (validatedCoordinates != null){
                            move.setFrom(position, piece, validatedCoordinates);

                            for (int[] i : validatedCoordinates){
                                Field validField = view.getBoardFields()[i[0]][i[1]];

                                if ((validField.isOccupied && view.getPieces()[i[0]][i[1]].getColor() != view.getPieces()[position[0]][position[1]].getColor())
                                        || (view.getPieces()[move.getFrom()[0]][move.getFrom()[1]] instanceof Pawn && !validField.isOccupied && (view.getPieces()[i[0]][i[1] - 1] instanceof Pawn || view.getPieces()[i[0]][i[1] + 1] instanceof Pawn) && (i[0] - 1 == position[0] || i[0] + 1 == position[0]))){
                                    validField.setBackgroundColor(validField.getColorId() + 6);
                                }

                                else{
                                    validField.setBackgroundColor(validField.getColorId() + 4);
                                }

                                validField.setClickable(true);
                            }
                        }
                    }
                }

                else{
                    int[] from = move.getFrom();

                    if (from[0] == position[0] && from[1] == position[1]){
                        restartBoard();
                        view.updateBoard();
                        move.restartMove();
                    }

                    else{
                        int[] fromInOrderToCheckIfKingOrRookWasMoved = move.getFrom();

                        int[] goTo = move.setTo(position);

                        if (goTo != null){
//                            System.out.println(Arrays.toString(goTo));
//                            System.out.println(Arrays.toString(goTo));
                            if (view.getPieces()[fromInOrderToCheckIfKingOrRookWasMoved[0]][fromInOrderToCheckIfKingOrRookWasMoved[1]] instanceof King){

                                King tempKing = (King) view.getPiece(fromInOrderToCheckIfKingOrRookWasMoved);

                                tempKing.setMoved(true);

                                view.setPiece(fromInOrderToCheckIfKingOrRookWasMoved, tempKing);
                            }

                            else if (view.getPieces()[fromInOrderToCheckIfKingOrRookWasMoved[0]][fromInOrderToCheckIfKingOrRookWasMoved[1]] instanceof King){

                                King tempKing = (King) view.getPiece(fromInOrderToCheckIfKingOrRookWasMoved);

                                tempKing.setMoved(true);

                                view.setPiece(fromInOrderToCheckIfKingOrRookWasMoved, tempKing);
                            }

                            if (view.getPieces()[from[0]][from[1]] instanceof Pawn
                                    && goTo[0] != from[0]
                                    && goTo[1] != from[1]
                                    && !view.getBoardFields()[goTo[0]][goTo[1]].isOccupied()) {

                                System.out.println("bicie w przelocie");

                                if (view.getPieces()[from[0]][from[1]].getColor() == 1){
                                    view.removePiece(goTo[0], goTo[1] - 1);
                                }

                                else if (view.getPieces()[from[0]][from[1]].getColor() == 0){
                                    view.removePiece(goTo[0], goTo[1] + 1);
                                }
                            }

                            view.movePiece(from, goTo);

                            view.updateBoard();

                        }

                        if (view.getWhiteClock() != null && view.getBlackClock() != null) view.changeClocks();
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);

                if (isOccupied || isClickable) setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

                if (currentColorId == colorId) setBackgroundColor(colorId + 2);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);

                if (currentColorId == colorId + 2) setBackgroundColor(colorId);
            }
        });

        add(foreground);
        add(background);
    }

    public void restartBoard(){
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                view.getBoardFields()[i][j].setBackgroundColor(view.getBoardFields()[i][j].getColorId());
                view.getBoardFields()[i][j].setClickable(false);
            }
        }
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public boolean isClickable() {
        return isClickable;
    }

    public void setClickable(boolean clickable) {
        isClickable = clickable;
    }

    public JLabel getFieldForeground() {
        return foreground;
    }

    public void setFieldForeground(JLabel foreground) {
        this.foreground = foreground;
    }

    public int getColorId() {
        return colorId;
    }

    public int getCurrentColorId() {
        return currentColorId;
    }

    public void setCurrentColorId(int currentColorId) {
        this.currentColorId = currentColorId;
    }

    public int[][] getValidatedCoordinates() {
        return validatedCoordinates;
    }

    public void setValidatedCoordinates(int[][] validatedCoordinates) {
        this.validatedCoordinates = validatedCoordinates;
    }

    private void setBackgroundColor(int color){
        currentColorId = color;

        switch (color){
            case 0:
                background.setIcon(new ImageIcon(new ImageIcon("res/board/light_field.png").getImage()));
                break;
            case 1:
                background.setIcon(new ImageIcon(new ImageIcon("res/board/dark_field.png").getImage()));
                break;
            case 2:
                background.setIcon(new ImageIcon(new ImageIcon("res/board/light_field_1.png").getImage()));
                break;
            case 3:
                background.setIcon(new ImageIcon(new ImageIcon("res/board/dark_field_1.png").getImage()));
                break;
            case 4:
                background.setIcon(new ImageIcon(new ImageIcon("res/board/light_field_2.png").getImage()));
                break;
            case 5:
                background.setIcon(new ImageIcon(new ImageIcon("res/board/dark_field_2.png").getImage()));
                break;
            case 6:
                background.setIcon(new ImageIcon(new ImageIcon("res/board/light_field_3.png").getImage()));
                break;
            case 7:
                background.setIcon(new ImageIcon(new ImageIcon("res/board/dark_field_3.png").getImage()));
                break;
            default:
                background.setIcon(new ImageIcon(new ImageIcon("res/board/dark_field.png").getImage()));
        }
    }
}
