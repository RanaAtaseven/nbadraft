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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class TeamPage extends JFrame {
    private Team team;
    private JList<Player> playerList;

    public TeamPage(Team team) {
        this.team = team;
        setTitle("Team View: " + team.getTeamName()); // Set title with team name
        initializeComponents();
        setupLayout();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this window
    }

    private void initializeComponents() {
        playerList = new JList<>(new Vector<>(team.getPlayers()));
        playerList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    Player selectedPlayer = playerList.getSelectedValue();
                    if (selectedPlayer != null) {
                        JOptionPane.showMessageDialog(TeamPage.this,
                                "Details for " + selectedPlayer.getPlayerName() +
                                "\nPosition: " + selectedPlayer.getPosition(),
                                "Player Details",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
        // Optionally add a cell renderer to display player details
        // playerList.setCellRenderer(new MyCellRenderer());
    }

    private void setupLayout() {
        add(new JScrollPane(playerList), BorderLayout.CENTER);
        // Add additional components like team logo, if needed
        pack(); // Adjust window to fit components
    }

    // Display the GUI
    public void display() {
        setVisible(true);
    }

    // Optional: Custom cell renderer class if you want to customize list display
    // private static class MyCellRenderer extends DefaultListCellRenderer {
    //     @Override
    //     public Component getListCellRendererComponent(JList<?> list, Object value, int index,
    //                                                   boolean isSelected, boolean cellHasFocus) {
    //         super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
    //         Player player = (Player) value;
    //         setText(player.getPlayerName() + " - " + player.getPosition());
    //         return this;
    //     }
    // }
}
