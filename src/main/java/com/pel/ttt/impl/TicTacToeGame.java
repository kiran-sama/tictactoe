package com.pel.ttt.impl;

import com.pel.ttt.*;
import com.pel.ttt.runner.Game;
import com.pel.ttt.util.IllegalMoveException;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by ksama on 5/14/17.
 */
public class TicTacToeGame implements Game {

    Scanner input;
    PrintStream output;
    Player player1 = null;
    Player player2 = null;
    Board ticTacToeBoard = null;
    List<MoveValidator> moveValidatorList = null;
    boolean isGameComplete = false;
    boolean isGameTie = false;
    int noOfRows = 3;
    int noOfColumns = 3;

    public void start(Scanner input, PrintStream output, int noOfHumanPlayers) {
        this.input = input;
        this.output = output;
        player1 = new TicTacToeHumanPlayer(input, output);
        player2 = new TicTacToeComputerPlayer(output, "");
        ticTacToeBoard = new BoardImpl(noOfRows,noOfColumns);
        moveValidatorList = new ArrayList<MoveValidator>();
        moveValidatorList.add(new TicTacToeMoveValidator());
        Player currentPlayer = player1;
        ticTacToeBoard.displayBoard();
        while(!isGameComplete){
            boolean isValid = false;
            Move next = null;
            while(!isValid){
                next = currentPlayer.getNextMove(ticTacToeBoard);
                boolean success = true;
                for(MoveValidator validator:moveValidatorList){
                    try {
                        validator.validateMove(ticTacToeBoard, next);
                    } catch (IllegalMoveException e) {
                        output.println(e.getMessage());
                        ticTacToeBoard.displayBoard();
                        success = false;
                    }
                }
                isValid = success;
            }
            ticTacToeBoard.applyMove(next);
            output.println("Turn completed");
            postMoveCheck(next);
            ticTacToeBoard.displayBoard();
            if(isGameComplete){
                if(!isGameTie){
                    output.println(currentPlayer.getPlayerName()+" wins");
                } else {
                    output.println("It's a tie");
                }
            } else {
                if(currentPlayer == player1){
                    currentPlayer = player2;
                } else{
                    currentPlayer = player1;
                }
            }
        }
    }

    /**
     * This will validate if board has completed and if there is a winner. if the game is complete game will be terminated
     * @param move
     */

    public void postMoveCheck(Move move){
        Position position = null;
        char value = ' ';
        for(Map.Entry<Position, Character> entry: move.getChanges().entrySet()){
            position = entry.getKey();
            value = entry.getValue();
        }
        int row = position.getRow();
        int column = position.getColumn();
        if(ticTacToeBoard.getCells()[row][0] == ticTacToeBoard.getCells()[row][1] &&
                ticTacToeBoard.getCells()[row][1] == ticTacToeBoard.getCells()[row][2]){
           isGameComplete = true;
        }

        if(ticTacToeBoard.getCells()[0][column]==ticTacToeBoard.getCells()[1][column] &&
                ticTacToeBoard.getCells()[1][column]==ticTacToeBoard.getCells()[2][column]){
            isGameComplete = true;
        }

        if(column == row){
            if(ticTacToeBoard.getCells()[0][0]==ticTacToeBoard.getCells()[1][1] &&
                    ticTacToeBoard.getCells()[1][1]==ticTacToeBoard.getCells()[2][2]){
                isGameComplete = true;
            }
        }

        boolean isEmptyFound = false;
        if(!isGameComplete){
            for(int i=0; i<noOfRows; i++){
                for(int j=0;j<noOfColumns;j++){
                    if(ticTacToeBoard.getCells()[i][j] == ' '){
                        isEmptyFound = true;
                    }
                }
            }
            if(!isEmptyFound){
                isGameComplete = true;
                isGameTie = true;
            }
        }
    }


}
