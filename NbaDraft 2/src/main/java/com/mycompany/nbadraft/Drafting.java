/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nbadraft;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Drafting {
    private List<Player> availablePlayers;
    private List<Team> teams;
    private int currentRound;
    private boolean isUserTurn;
    private int playerNumforTeam;

    public Drafting(List<Player> players, List<Team> teams) {
        this.availablePlayers = new ArrayList<>(players); // Create a copy of the players list
        this.teams = teams;
        this.currentRound = 1;
        this.isUserTurn = false;
        this.playerNumforTeam = 10;
// Assuming the user does not start first
    }
    
    

    // Starting the daft process untill all available players have been drafted it will continues
    public void startDraft() {
        Collections.shuffle(teams);
        System.out.println("Drafting has started!!.");
        while (!availablePlayers.isEmpty()) {
            for (Team team : teams) {
                if (team.getPlayers().size()!= playerNumforTeam) {
                    isUserTurn = true;
                    System.out.println("User's turn to draft.");
                    // Trigger GUI for user to pick a player
                } else {
                    normalDraftingPlayer(team);
                }
                if (availablePlayers.isEmpty()) break;
            }
            Collections.reverse(teams);
            System.out.println(currentRound +". Round" +" completed.");
            currentRound++;
        }
        System.out.println("Congrats Drafting has completed");
    }

    private void normalDraftingPlayer(Team team) {
        Player chosenPlayer = choosePlayerForTeam(team);
        if (team.positionChecker(chosenPlayer)) {
            team.addPlayer(chosenPlayer);
            availablePlayers.remove(chosenPlayer);
            System.out.println("Team " + team.getTeamName() + " drafted " + chosenPlayer.getPlayerName());
        }
    }

    // Automatically draft a player for a non-user controlled team
    

    // Logic to select a player for a team randomly
    private Player choosePlayerForTeam(Team team) {
        // Implement your logic here. For example, picking a random player:
        int randomIndex = (int) (Math.random() * availablePlayers.size());
        return availablePlayers.get(randomIndex);
    }

    // method for user selection
    public void userDraftsPlayer(Player player, Team userTeam) {
        if (isUserTurn && availablePlayers.contains(player) && userTeam.positionChecker(player) == true) {
            userTeam.addPlayer(player);
            availablePlayers.remove(player);
            isUserTurn = false;
        }
    }

    // Getters 
    public int getCurrentRound() {
        return currentRound;
    }

    public List<Player> getAvailablePlayers() {
        return availablePlayers;
    }

    
}
