package edu.dosw.lab.estructurales.reto8;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private String name;
    private int age;
    private String specialty;
    private List<Player> assignedPlayers;

    public Coach(String name, int age, String specialty) {
        this.name = name;
        this.age = age;
        this.specialty = specialty;
        this.assignedPlayers = new ArrayList<>();
    }

    public void assignPlayer(Player player) {
        this.assignedPlayers.add(player);
    }

    public void manage(Player player) {
        System.out.println("Coach " + this.name + " is managing player " + player.getName());
    }

    public void evaluate(Player player) {
        System.out.println("Coach " + this.name + " is evaluating the performance of " + player.getName());
    }

    public void planSession(Player player) {
        System.out.println("Coach " + this.name + " plans a specific training session for " + player.getName());
    }

    public String getName() {
        return name;
    }
}