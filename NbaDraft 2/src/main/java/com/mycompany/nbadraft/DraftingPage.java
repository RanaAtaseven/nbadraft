/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nbadraft;

/**
 *
 * @author rana
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
//this is my code for the gui printing
public class DraftingPage extends JFrame {
    
        private Drafting drafting;
        private JComboBox<Player> playerComboBox;
        private JButton draftButton;
        private JLabel infoLabel;
        private Team userTeam;

        public DraftingPage(Drafting drafting, Team userTeam) {
            this.drafting = drafting;
            this.userTeam = userTeam;
            initializeComponents();
            setupLayout();
        }
        //this part is for initializing gui components 
        private void initializeComponents() {
            playerComboBox = new JComboBox<>();
            draftButton = new JButton("Draft Player");
            infoLabel = new JLabel("Select a player to draft:");

            draftButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleDraftButton();
                }
            });
        }

        private void setupLayout() {
            // giving the spesific coordinates for gui
            setLayout(new BorderLayout());
            add(infoLabel, BorderLayout.NORTH);
            add(playerComboBox, BorderLayout.CENTER);
            add(draftButton, BorderLayout.SOUTH);
            pack();
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        private void handleDraftButton() {
            Player selectedPlayer = (Player) playerComboBox.getSelectedItem();
            if (selectedPlayer != null) {
                drafting.userDraftsPlayer(selectedPlayer, userTeam);
                System.out.println("User drafted " + selectedPlayer.getPlayerName());
                updateAvailablePlayers();
            }
        }

        public void updateAvailablePlayers() {
            // after draft process has begun this will update the players
            List<Player> availablePlayers = drafting.getAvailablePlayers();
            playerComboBox.removeAllItems();
            for (Player player : availablePlayers) {
                playerComboBox.addItem(player);
            }
        }

        public void startDraftingProcess() {
            updateAvailablePlayers();
            setVisible(true);
        }

    }

