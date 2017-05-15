package com.pel.ttt.impl;

import com.pel.ttt.Board;
import com.pel.ttt.Move;
import com.pel.ttt.MoveValidator;
import com.pel.ttt.Position;
import com.pel.ttt.util.IllegalMoveException;

/**
 * Created by ksama on 5/14/17.
 * This validates if human is entering already filled position
 */
public class TicTacToeMoveValidator implements MoveValidator{
    public void validateMove(Board board, Move move) throws IllegalMoveException {
        Position next = null;
        for(Position pos:move.getChanges().keySet()){
            next = pos;
        }
        if(next.getRow() <0 || next.getRow()>2||next.getColumn() <0 || next.getColumn()>2){
            throw new IllegalMoveException("Not a valid position in board, please enter number a number from 1 to 9");
        }
        if(board.getCells()[next.getRow()][next.getColumn()] != ' '){
            throw new IllegalMoveException("Position has already been filled");
        }
    }
}
