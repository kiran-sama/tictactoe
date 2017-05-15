package com.pel.ttt;


/**
 * Created by ksama on 5/14/17.
 *
 * Definition of a board that can be used for different games
 * like TicTacToe, Sudoku, Chess etc
 */
public interface Board {

     void displayBoard();

     void applyMove(Move move);

     char[][] getCells();

     Move getLastMove();

}
