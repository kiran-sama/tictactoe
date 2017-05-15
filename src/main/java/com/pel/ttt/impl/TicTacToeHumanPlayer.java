package com.pel.ttt.impl;

import com.pel.ttt.Board;
import com.pel.ttt.Move;
import com.pel.ttt.Player;
import com.pel.ttt.Position;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by ksama on 5/14/17.
 */
public class TicTacToeHumanPlayer implements Player{
    Scanner input = null;
    PrintStream output = null;
    char symbol ='X';
    String playerName = "Human";

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public TicTacToeHumanPlayer(Scanner input, PrintStream output) {
        this.input = input;
        this.output = output;

    }

    public Move getNextMove(Board board) {
        output.println("Now "+playerName+"'s turn, enter the position number");
        int position = input.nextInt();
        int row = (position-1)/3;
        int column = (position-1)%3;
        Move move = new Move();
        move.addChange(new Position(row, column), symbol);
        return move;
    }
}
