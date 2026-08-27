package edu.dosw.lab.estructurales.reto8;

public abstract class PlayerDecorator extends Player {
    private Player player; // El jugador original que estamos envolviendo

    public PlayerDecorator(Player player) {
        // Extraemos los datos del jugador envuelto para satisfacer al constructor padre
        super(player.getName(), player.getAge(), player.getDorsal(),
                player.getSkilledFoot(), player.getWeight(), player.getHeight(),
                player.getFitnessLevel(), player.getCategory());

        this.player = player;
    }

    @Override
    public void kick() {
        player.kick(); // Delegación de la acción
    }

    @Override
    public void train() {
        player.train(); // Delegación de la acción
    }
}