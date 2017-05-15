package com.pel.ttt;

/**
 * Created by ksama on 5/14/17.
 * Definition of Player
 * Human or computer player should implement this
 */
public interface Player {

    Move getNextMove(Board board);

    String getPlayerName();

}
