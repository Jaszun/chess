package com.company.Backend;

import com.company.Frontend.View;

public interface MoveValidator {
    int[][] validate(int[] from, int pieceColor, View view);
}
