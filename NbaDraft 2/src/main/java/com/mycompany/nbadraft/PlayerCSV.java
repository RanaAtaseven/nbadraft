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
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author rana
 */
public class PlayerCSV {
    public Player createPlayer(String[] columns) {
            String playerNum = columns[0];
            String playerName = columns[1];
            String position = columns[2];
            String pts = columns[29]; // Points
            String totalRebounds = columns[24]; // Total Rebounds
            String assists = columns[25]; // Assists
            String blocks = columns[27]; // Blocks
            String steals = columns[26]; // Steals // Steals

    switch (position) {
        case "C":
            return new Center(playerName, pts, totalRebounds, assists, blocks, steals);

        case "PG":
            return new PointGuard(playerName, pts, totalRebounds, assists, blocks, steals);

        case "SG":
            return new ShootingGuard(playerName, pts, totalRebounds, assists, blocks, steals);

        case "SF":
            return new SmallForward(playerName, pts, totalRebounds, assists, blocks, steals);

        case "PF":
            return new PowerForward(playerName, pts, totalRebounds, assists, blocks, steals);

        default:
            System.out.println("Unknown position: " + position); // for debugging
            
            return null;
    }

        }
    //this method will read the csv file using filereader methods
    public ArrayList<Player> CSVReader(String filePath, String outputPath) {
    ArrayList<Player> players = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;
        boolean isFirstRow = true;
        while ((line = br.readLine()) != null) {
            if (isFirstRow) {
                isFirstRow = false;
                continue; 
            }
            String[] columns = line.split(";"); 
            Player player = createPlayer(columns);
            if (player != null) { // Check ifor the player object is not null
                players.add(player);
            }
        }
    } catch (IOException e) {
        e.printStackTrace(); 
    }
    
    // I am sorting  players based on their calculated score in descending order
    Collections.sort(players, new Comparator<Player>() {
       @Override
       public int compare(Player p1, Player p2) {
           return Integer.compare(p2.getFinalScore(), p1.getFinalScore());
       }
    });

    //after reading the file this part writes the necessery info to playerdata.txt
    try (BufferedWriter br = new BufferedWriter(new FileWriter("/Users/rana/NetBeansProjects/NbaDraft/src/main/java/com/mycompany/nbadraft/PlayerData.txt"))) {
        for (Player player : players) {
            String line = player.getPlayerName() + "," + player.getPosition() + "," + player.pts + "," + 
                    player.totalRebounds + "," + player.assists + "," + player.blocks + "," + player.steals;
            br.write(line);
            br.newLine();
        }
        br.flush();
        br.close();
    } catch (IOException e) {
        e.printStackTrace(); 
    }
    return players;
}

    
}
