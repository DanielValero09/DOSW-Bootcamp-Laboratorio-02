package edu.dosw.lab.creacionales.reto2;

public interface ISuitBuilder {
    ISuitBuilder buildCloth(String kind, int price);
    ISuitBuilder buildCoat(String kind, int price);
    ISuitBuilder buildPants(String kind, int price);
    ISuitBuilder buildVest(String kind, int price);
    ISuitBuilder buildLining(String kind, int price);
    ISuitBuilder buildEmbroidery(String kind, int price);
    Suit build();
}
