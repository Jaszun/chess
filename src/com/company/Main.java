package com.company;

//<div>Icons made by <a href="https://www.freepik.com" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a></div>

import com.company.Backend.Board;
import com.company.Backend.ChessClock;
import com.company.Backend.Move;
import com.company.Frontend.View;
import com.company.Pieces.*;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Move move = new Move();

        View view = new View(board.getBoard(), move);
    }
}
