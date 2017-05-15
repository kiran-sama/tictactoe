package com.pel.ttt;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ksama on 5/14/17.
 * Defintion of all the changes that define a move
 * In board game like chess it will have list of position and value combinations
 */
public class Move {
    Map<Position,Character> changes = null;

    public Move(){
        changes = new HashMap<Position, Character>();
    }

    public void addChange(Position pos, char value){
        changes.put(pos, value);
    }

    public Map<Position, Character>  getChanges(){
        return changes;
    }
}
