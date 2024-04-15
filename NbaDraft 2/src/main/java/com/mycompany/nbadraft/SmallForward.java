/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nbadraft;

import java.util.Random;

public class SmallForward extends Player {
    private final double ptsWeight;
    private final double trbWeight;
    private final double astWeight;
    private final double blkWeight;
    private final double stlWeight;

    public SmallForward(String playerName, String pts, String totalRebounds, String assists, String blocks, String steals) {
        super(playerName, "SF", pts, totalRebounds, assists, blocks, steals);
        this.ptsWeight = 0.30;
        this.trbWeight = 0.10;
        this.astWeight = 0.40;
        this.blkWeight = 0.10;
        this.stlWeight = 0.10;
    }

    @Override
    public int calculateScore() {
            int n = 5;
            Random random = new Random();

             // n = 5, pts = 20, 15 - 25
             // 
            // Calculate random values within the range [value - n, value + n]
            int randomPts = random.nextInt(Integer.parseInt(pts) - n, Integer.parseInt(pts) + n + 1); // nextInt(15,)
            int randomTrb = random.nextInt(Integer.parseInt(totalRebounds) - n, Integer.parseInt(totalRebounds) + n + 1);
            int randomAst = random.nextInt(Integer.parseInt(assists) - n, Integer.parseInt(assists) + n + 1);
            int randomBlk = random.nextInt(Integer.parseInt(blocks) - n, Integer.parseInt(blocks) + n + 1);
            int randomStl = random.nextInt(Integer.parseInt(blocks) - n, Integer.parseInt(blocks) + n + 1);

            // Ensure values do not go below 0
            // 0, 8
           // Ensure points (PTS) do not go below 0
    if (Integer.parseInt(pts) - n < 0) {
        randomPts = random.nextInt(0, Integer.parseInt(pts) + n + 1);
    }

    // Ensure total rebounds (TRB) do not go below 0
    if (Integer.parseInt(totalRebounds) - n < 0) {
        randomTrb = random.nextInt(0, Integer.parseInt(totalRebounds) + n + 1);
    }

    // Ensure assists (AST) do not go below 0
    if (Integer.parseInt(assists) - n < 0) {
        randomAst = random.nextInt(0, Integer.parseInt(assists) + n + 1);
    }

    // Ensure blocks (BLK) do not go below 0
    if (Integer.parseInt(blocks) - n < 0) {
        randomBlk = random.nextInt(0, Integer.parseInt(blocks) + n + 1);
    }

    // Ensure steals (STL) do not go below 0
    if (Integer.parseInt(steals) - n < 0) {
        randomStl = random.nextInt(0, Integer.parseInt(steals) + n + 1);
    }



            // Calculate the score using the weights
            double score = ptsWeight * randomPts + trbWeight * randomTrb + astWeight * randomAst + blkWeight * randomBlk + stlWeight * randomStl;

            // Round the score to the nearest whole number and return it
            return (int) Math.round(score);
        }
}
