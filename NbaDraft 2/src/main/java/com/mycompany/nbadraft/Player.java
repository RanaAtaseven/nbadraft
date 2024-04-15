/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nbadraft;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author rana
 */
public class Player {
    
        public String playerName;
        public String position;
        public String pts; // Points
        public String totalRebounds; // Total Rebounds
        public String assists; // Assists
        public String blocks; // Blocks
        public String steals; // Steals
        public String playerNum;

        protected double ptsWeight;  // Example weights, you will override these in subclasses
        protected double trbWeight;
        protected double astWeight;
        protected double blkWeight;
        protected double stlWeight;
        
         private int finalScore = -1;

        // Constructor
        public Player(String playerName, String position, String pts, String totalRebounds, String assists, String blocks, String steals) {
            this.playerName = playerName;
            this.position = position;
            this.pts = pts;
            this.totalRebounds = totalRebounds;
            this.assists = assists;
            this.blocks = blocks;
            this.steals = steals;
            this.playerNum = playerNum;
        }
        
        public int getFinalScore() {
        if (finalScore == -1) {
            finalScore = calculateScore(); // Calculate score if not already done
        }
        return finalScore;
    }
        public String getPlayerName() {
            return playerName;
        }

        public String getPosition() {
            return position;
        }

        public int calculateScore() {
            int n = 5;
            Random random = new Random();

             // n = 5, pts = 20, 15 - 25
             // 
            // Calculate random values within the range [value - n, value + n]
            int randomPts = random.nextInt(Integer.parseInt(pts) - n, 
                    Integer.parseInt(pts) + n + 1); // nextInt(15,)
            int randomTrb = random.nextInt(Integer.parseInt(totalRebounds) - n, 
                    Integer.parseInt(totalRebounds) + n + 1);
            int randomAst = random.nextInt(Integer.parseInt(assists) - n, 
                    Integer.parseInt(assists) + n + 1);
            int randomBlk = random.nextInt(Integer.parseInt(blocks) - n, 
                    Integer.parseInt(blocks) + n + 1);
            int randomStl = random.nextInt(Integer.parseInt(blocks) - n, 
                    Integer.parseInt(blocks) + n + 1);

            //this part is for checking and preventin the values not to go down 0
    if (Integer.parseInt(pts) - n < 0) {
        randomPts = random.nextInt(0, Integer.parseInt(pts) + n + 1);
    }

    if (Integer.parseInt(totalRebounds) - n < 0) {
        randomTrb = random.nextInt(0, Integer.parseInt(totalRebounds) + n + 1);
    }

    if (Integer.parseInt(assists) - n < 0) {
        randomAst = random.nextInt(0, Integer.parseInt(assists) + n + 1);
    }

    if (Integer.parseInt(blocks) - n < 0) {
        randomBlk = random.nextInt(0, Integer.parseInt(blocks) + n + 1);
    }

    if (Integer.parseInt(steals) - n < 0) {
        randomStl = random.nextInt(0, Integer.parseInt(steals) + n + 1);
    }



            // Calculate the score using the weights
            double score = ptsWeight * randomPts + trbWeight * randomTrb + astWeight * randomAst + blkWeight * randomBlk + stlWeight * randomStl;

            // Round the score
            return (int) Math.round(score);
        }

        
        
}

