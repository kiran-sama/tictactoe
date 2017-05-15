package com.pel.ttt;

/**
 * Created by ksama on 5/14/17.
 * Definition of TicTacToeStrategy that computer can use
 * Each computer stragety has to implement this interface
 */
public interface TicTacToeStrategy {

    Position getNextPosition(Board board);
}
