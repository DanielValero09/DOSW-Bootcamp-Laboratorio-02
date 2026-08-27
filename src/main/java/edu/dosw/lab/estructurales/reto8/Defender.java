package edu.dosw.lab.estructurales.reto8;

public class Defender extends Player {
    public Defender(String name, int age, int dorsal, String skilledFoot, double weight, double height, int fitnessLevel, String category) {
        super(name, age, dorsal, skilledFoot, weight, height, fitnessLevel, category);
    }

    @Override
    public void kick() {
        System.out.println(getName() + " passes the ball safely to the midfield.");
    }

    @Override
    public void train() {
        System.out.println(getName() + " is practicing tackles and positioning.");
    }
}
