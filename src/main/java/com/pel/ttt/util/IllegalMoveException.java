package com.pel.ttt.util;

/**
 * Created by ksama on 5/14/17.
 * Exception that tells that user input is not valid
 */
public class IllegalMoveException extends Exception {

    public IllegalMoveException(String message){
        super(message);
    }
}
