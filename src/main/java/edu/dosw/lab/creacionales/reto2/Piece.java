package edu.dosw.lab.creacionales.reto2;

public abstract class Piece {
    protected String kind;
    protected int price;

    public Piece (String kind, int price){
        this.kind = kind;
        this.price = price;
    }

    public String getKind() {
        return kind;
    }

    public int getPrice() {
        return price;
    }
}
