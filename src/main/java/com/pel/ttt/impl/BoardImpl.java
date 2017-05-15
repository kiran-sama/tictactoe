package com.pel.ttt.impl;

import com.pel.ttt.Board;
import com.pel.ttt.Move;
import com.pel.ttt.Position;
import java.util.Map;

/**
 * Created by ksama on 5/14/17.
 */
public class BoardImpl implements Board {
    char[][] cells;
    int noOfRows = 0;
    int noOfColumns = 0;
    Move lastMove = null;

    public BoardImpl(int noOfRows, int noOfColumns){
        this.noOfRows = noOfRows;
        this.noOfColumns = noOfColumns;
        cells = new char[noOfRows][noOfColumns];
        for(int i=0;i<noOfRows;i++){
            for(int j=0;j<noOfColumns;j++){
                cells[i][j] =' ';
            }
        }
    }

    public void displayBoard() {
        for(int i=0;i<noOfRows;i++){
            for(int j=0;j<noOfColumns;j++){
                System.out.print("|");
                System.out.print(cells[i][j]);
            }
            System.out.println("|");
        }
    }

    public void applyMove(Move move) {
        for(Map.Entry<Position, Character> entry: move.getChanges().entrySet()) {
            Position pos = entry.getKey();
            char value = entry.getValue();
            cells[pos.getRow()][pos.getColumn()] = value;
        }
        lastMove = move;
    }

    public char[][] getCells() {
        return cells;
    }

    public Move getLastMove() {
        return lastMove;
    }
}
