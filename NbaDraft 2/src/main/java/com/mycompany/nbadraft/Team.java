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
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author rana
 */
public class Team {
    private String teamName;
    private ImageIcon teamLogo; 
    private List<Player> players;
    private boolean UsersTurnCheck;

    public Team(String teamName, ImageIcon teamLogo, boolean isUserControlled) {
        this.teamName = teamName;
        this.teamLogo = teamLogo;
        this.players = new ArrayList<>();
        this.UsersTurnCheck = isUserControlled;
        
    }

    public boolean UsersTurnChecker() {
         
        return UsersTurnCheck;
    }
    

    public void addPlayer(Player chosenPlayer) {
        players.add(chosenPlayer);
        
    }
    
    public int calculateTeamScore() {
    int teamScore = 0;
    for (Player player : players) {
        int score = player.calculateScore();
        teamScore += score;
    }
    return teamScore;
}

    public String getTeamName() {
    return teamName;
    }
    
    public List<Player> getPlayers() {
        return players; // Return the list of players
    }
    
    public void displayTeamInfo() {
        System.out.println("Team: " + getTeamName());
        for (Player player : players) {
            System.out.println("Player: " + player.getPlayerName() + ", Position: " + player.getPosition());
        }
    }
    
    public boolean positionChecker(Player potentialPlayer) {
    boolean C_stat = false;
    boolean PG_stat = false;
    boolean PF_stat = false;
    boolean SF_stat = false;
    boolean SG_stat = false;

    for (Player player : players) {
        if (player.getPosition().equals("C")) {
            C_stat = true;
        } else if (player.getPosition().equals("PG")) {
            PG_stat = true;
        } else if (player.getPosition().equals("SG")) {
            SG_stat = true;
        } else if (player.getPosition().equals("PF")) {
            PF_stat = true;
        } else if (player.getPosition().equals("SF")) {
            SF_stat = true;
        }
    }

    return C_stat && PG_stat && PF_stat && SF_stat && SG_stat;
}
    public void TeamDataCSV (String filePath) {
    
    

    try (BufferedWriter br = new BufferedWriter(new FileWriter("/Users/rana/NetBeansProjects/NbaDraft/src/main/java/com/mycompany/nbadraft/TeamData.txt"))) {
        br.write("Team Name: " + getTeamName() + "\n" + "Team Score: " + calculateTeamScore() + "\n");

        for (Player player : players) {
            String line = "Player:" + player.getPlayerName() + " Position:" + player.getPosition() + "/n";
            br.write(line);
            br.newLine();
        }
        br.flush();
        br.close();
    } catch (IOException e) {
        e.printStackTrace(); // Consider a more robust error handling strategy.
  }
    
  }
}
    
  
    
    

