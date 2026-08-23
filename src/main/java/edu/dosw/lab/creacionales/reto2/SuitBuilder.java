package edu.dosw.lab.creacionales.reto2;

import ch.qos.logback.core.encoder.EchoEncoder;

import java.util.ArrayList;
import java.util.List;

public class SuitBuilder implements ISuitBuilder{
    private Cloth cloth = null;
    private Coat coat = null;
    private Pants pants = null;
    private Vest vest = null;
    private Lining lining = null;
    private Embroidery embroidery = null;

    public SuitBuilder(){}

    public ISuitBuilder buildCloth(String kind, int price){
        cloth = new Cloth(kind, price);
        return this;
    }

    public ISuitBuilder buildCoat(String kind, int price){
        coat = new Coat(kind, price);
        return this;
    }

    public ISuitBuilder buildPants(String kind, int price){
        pants = new Pants(kind, price);
        return this;
    }

    public ISuitBuilder buildVest(String kind, int price){
        vest = new Vest(kind, price);
        return this;
    }

    public ISuitBuilder buildLining(String kind, int price){
        lining = new Lining(kind, price);
        return this;
    }

    public ISuitBuilder buildEmbroidery(String kind, int price){
        embroidery = new Embroidery(kind, price);
        return this;
    }

    public Suit build(){
        List<Piece> pieces = new ArrayList<>();

        // We make sure that all required pieces are provided
        if(cloth == null){
            throw new IllegalStateException("Faltan piezas obligatorias");
        }
        if(coat == null){
            throw new IllegalStateException("Faltan piezas obligatorias");
        }
        if(pants == null){
            throw new IllegalStateException("Faltan piezas obligatorias");
        }

        // If there's no exception, then we add the pieces into the arraylist
        pieces.add(cloth);
        pieces.add(coat);
        pieces.add(pants);

        // Then we check if an optional piece was ordered and add it
        if(vest != null){
            pieces.add(vest);
        }
        if(lining != null){
            pieces.add(lining);
        }
        if(embroidery != null){
            pieces.add(embroidery);
        }

        // Lastly we merge the pieces to build the complex object and return it
        return new Suit(pieces);
    }
}
