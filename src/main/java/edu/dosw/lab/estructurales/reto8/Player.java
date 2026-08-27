package edu.dosw.lab.estructurales.reto8;

public abstract class Player {
    private String name;
    private int age;
    private int dorsal;
    private String skilledFoot;
    private double weight;
    private double height;
    private int fitnessLevel;
    private String category;

    public Player(String name, int age, int dorsal, String skilledFoot, double weight, double height, int fitnessLevel, String category) {
        this.name = name;
        this.age = age;
        this.dorsal = dorsal;
        this.skilledFoot = skilledFoot;
        this.weight = weight;
        this.height = height;
        this.fitnessLevel = fitnessLevel;
        this.category = category;
    }

    public abstract void kick();
    public abstract void train();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getSkilledFoot() {
        return skilledFoot;
    }

    public void setSkilledFoot(String skilledFoot) {
        this.skilledFoot = skilledFoot;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getFitnessLevel() {
        return fitnessLevel;
    }

    public void setFitnessLevel(int fitnessLevel) {
        this.fitnessLevel = fitnessLevel;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
