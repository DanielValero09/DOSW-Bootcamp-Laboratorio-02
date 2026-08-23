package edu.dosw.lab.creacionales.reto2;

import java.util.HashMap;
import java.util.Map;

public class Tailor {
    private ISuitBuilder builder;
    private Map<String,Integer> clothes = new HashMap<>();
    private Map<String,Integer> coats = new HashMap<>();
    private Map<String,Integer> pants = new HashMap<>();
    private Map<String,Integer> vests = new HashMap<>();
    private Map<String,Integer> linings = new HashMap<>();
    public static final int EMBROIDERY_PRICE = 35000;

    public Tailor(ISuitBuilder builder){
        this.builder = builder;
        clothes.put("lana italiana", 320000);
        clothes.put("paño nacional", 150000);
        coats.put("cruzado", 250000);
        coats.put("recto", 200000);
        pants.put("corte slim", 180000);
        pants.put("corte clásico", 160000);
        vests.put("clásico", 90000);
        linings.put("seda", 70000);
    }

    public Suit makeSuit(String clothType, String coatType, String pantsType, String vestType, String liningType, String embroideryType){
        builder.buildCloth(clothType, clothes.get(clothType.toLowerCase()))
                .buildCoat(coatType, coats.get(coatType.toLowerCase()))
                .buildPants(pantsType, pants.get(pantsType.toLowerCase()));
        if (vestType != null){
            builder.buildVest(vestType, vests.get(vestType.toLowerCase()));
        }
        if (liningType != null){
            builder.buildLining(liningType, linings.get(liningType.toLowerCase()));
        }
        if (embroideryType != null){
            builder.buildEmbroidery(embroideryType, EMBROIDERY_PRICE);
        }
        return builder.build();
    }
}
