package edu.dosw.lab.creacionales.reto2;

import java.util.List;

public class Suit {
    private final List<Piece> pieces;

    public Suit(List<Piece> pieces){
        this.pieces = pieces;
    }

    public List<Piece> getPieces(){
        return pieces;
    }

    public int getTotalPrice(){
        return pieces.stream().mapToInt(Piece::getPrice).sum();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n-------- Tu Traje --------\n");

        for (Piece piece : pieces) {
            // Formateamos para que quede alineado como en la imagen
            sb.append(String.format("%-10s %-10s $%d\n",
                    piece.getClass().getSimpleName() + ":",
                    piece.getKind(),
                    piece.getPrice()));
        }

        sb.append("\nTotal:     $").append(getTotalPrice()).append("\n");
        return sb.toString();
    }
}
