package com.pel.ttt.runner;

import com.pel.ttt.impl.TicTacToeGame;

import java.util.Scanner;

/**
 * Created by ksama on 5/14/17.
 * Main program that runs the game
 */
public class GameRunner {
    public static void main(String args[]){
        Game game = new TicTacToeGame();
        Scanner input = new Scanner(System.in);
        game.start(input, System.out, 1);
    }
}
