package edu.dosw.lab.estructurales.reto8;

public class Forward extends Player {
    public Forward(String name, int age, int dorsal, String skilledFoot, double weight, double height, int fitnessLevel, String category) {
        super(name, age, dorsal, skilledFoot, weight, height, fitnessLevel, category);
    }

    @Override
    public void kick() {
        System.out.println(getName() + " shoots directly at the goal!");
    }

    @Override
    public void train() {
        System.out.println(getName() + " is practicing finishing and sprints.");
    }
}
