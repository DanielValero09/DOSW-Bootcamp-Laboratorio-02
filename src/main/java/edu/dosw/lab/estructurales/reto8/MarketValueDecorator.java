package edu.dosw.lab.estructurales.reto8;

public class MarketValueDecorator extends PlayerDecorator{
    private double marketValue;
    public MarketValueDecorator(Player player, double marketValue){
        super(player);
        this.setMarketValue(marketValue);
    }

    public double getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(double marketValue) {
        this.marketValue = marketValue;
    }
}
