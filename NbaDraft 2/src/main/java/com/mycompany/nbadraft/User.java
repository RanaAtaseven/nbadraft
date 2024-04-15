/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nbadraft;

public class User {
    public final String nickname; //u
    public String password;
    public final String realName;
    public final String surname;
    public int age;
    public String emailAddress; //u
    public String profilePhoto; // op

    // Constructor
    public User(String nickname, String password, String realName, String surname, int age, String emailAddress) {
        this.nickname = nickname;
        this.password = password;
        this.realName = realName;
        this.surname = surname;
        this.age = age;
        this.emailAddress = emailAddress;
        // Initialize with a default profile photo path or binary data
        this.profilePhoto = "default_profile_photo.jpg";
    }


    
}
