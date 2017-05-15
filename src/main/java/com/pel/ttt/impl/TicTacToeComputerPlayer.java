package com.pel.ttt.impl;

import com.pel.ttt.*;

import java.io.PrintStream;

/**
 * Created by ksama on 5/14/17.
 */
public class TicTacToeComputerPlayer implements Player {

    TicTacToeStrategy strategy = null;
    char symbol ='O';
    String playerName = "Computer";
    PrintStream output = null;

    public TicTacToeComputerPlayer(PrintStream output, String strategyName){
        this.output = output;
        strategy = new RandomTicTacToeStrategy();
    }

    public Move getNextMove(Board board) {
        output.println("It's Computer turn now");
        Position next = strategy.getNextPosition(board);
        Move nextMove = new Move();
        nextMove.addChange(next, symbol);
        return nextMove;
    }

    public String getPlayerName() {
        return "Computer";
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
