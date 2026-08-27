package edu.dosw.lab.estructurales.reto8;

import java.util.ArrayList;
import java.util.List;

public class Fan {
    private String name;
    private int age;
    private List<Player> favoritePlayers;
    private int shirts;

    public Fan(String name, int age, int shirts) {
        this.name = name;
        this.age = age;
        this.favoritePlayers = new ArrayList<>();
        this.shirts = shirts;
    }

    public void addFavoritePlayer(Player player) {
        this.favoritePlayers.add(player);
    }

    public void cheer(Player player) {
        System.out.println("Fan " + this.name + " is cheering loudly for " + player.getName() + "!");
    }

    public void askAutograph(Coach coach) {
        System.out.println("Fan " + this.name + " is asking for an autograph from coach " + coach.getName());
    }

    public void postPhoto(Player player) {
        System.out.println("Fan " + this.name + " posted a photo with " + player.getName() + " on social media.");
    }
}