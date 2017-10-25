/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hhsconnectfour;

import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author Ben
 */
public class CoinHandler {
    
    ArrayList<JLabel> spaceList;
    int turn;
    
    public CoinHandler() {
        this.spaceList = new ArrayList<>();
        turn = 1;
    }
        
    /**
     *
     * looks for a free slot keeping gravity in mind,
     * returns the play field with added coin if there's a free slot,
     * otherwise prompts user
     */
    public int[][] addCoin(int col,int[][] playfield) {
        // int for keeping track of which slot is free
        int freeslot;
        freeslot = -1;
        
        // for logging
        String str_x = Integer.toString(col); 
        String str_y = "-1";
        
        // check rows from the bottom to the top
        for(int row=6;row>0;row--) 
        {
            if(playfield[col][row]>0) {  
                // if the slot is taken,
                str_y = Integer.toString(row);
                System.out.print("Slot #"+str_y+" was taken; ");
            } else {
                // free slot found, store y value
                freeslot = row;
                str_y = Integer.toString(row);
                
                // exit loop once free slot is found
                break; 
            }
        }
        if(freeslot != -1) {
            System.out.println("Coin was put in Slot #"+str_y+".");
            playfield[col][freeslot] = this.turn;
            
            // switch turns
            if(turn==1){ turn=2; } else { turn=1; }
        } else {
            System.out.println("Column #"+str_x+" is full!");
        }
        return playfield;
    }

}
