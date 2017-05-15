package com.pel.ttt.runner;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by ksama on 5/14/17.
 */
public interface Game {

    public void start(Scanner input, PrintStream output, int noOfHumanPlayers);
}
