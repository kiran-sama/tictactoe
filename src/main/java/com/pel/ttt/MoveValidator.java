package com.pel.ttt;

import com.pel.ttt.util.IllegalMoveException;

/**
 * Created by ksama on 5/14/17.
 *
 * Defines the validator which validates human player input
 */
public interface MoveValidator {

    public void validateMove(Board board, Move move) throws IllegalMoveException;
}
