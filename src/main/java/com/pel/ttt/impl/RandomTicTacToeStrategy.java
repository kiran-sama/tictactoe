package com.pel.ttt.impl;

import com.pel.ttt.Board;
import com.pel.ttt.Position;
import com.pel.ttt.TicTacToeStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by ksama on 5/14/17.
 * Strategy takes any randome position in empty positions
 */
public class RandomTicTacToeStrategy implements TicTacToeStrategy{

    Random r = null;

    public RandomTicTacToeStrategy(){
        r = new Random();
    }

    public Position getNextPosition(Board board) {
        List<Position> emptyPositions = new ArrayList<Position>();
        for(int i=0;i<board.getCells().length;i++){
            for(int j=0;j<board.getCells()[0].length;j++){
                if(board.getCells()[i][j] == ' '){
                    emptyPositions.add(new Position(i,j));
                }
            }
        }
        return emptyPositions.get(r.nextInt(emptyPositions.size()));
    }
}
