/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.nbadraft;

import com.mycompany.nbadraft.PlayerCSV;


public class NbaDraft {

    public static void main(String[] args) {
        PlayerCSV playerCSV = new PlayerCSV();
        String csvPath = "/Users/rana/NetBeansProjects/NbaDraft/src/main/java/com/mycompany/nbadraft/2022-2023 NBA Player Stats - Regular.csv";
        String outputPath = "/Users/rana/NetBeansProjects/NbaDraft/src/main/java/com/mycompany/nbadraft/PlayerData.txt";
        playerCSV.CSVReader(csvPath, outputPath);
    }
}