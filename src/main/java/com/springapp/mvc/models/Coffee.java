package com.springapp.mvc.models;

//класс суцщность для класса RealCoffeeMashine

public class Coffee {
    private String coffeeName;
    private  final int PRICE_COFFEE = 5;
    private Sugar sugar;
    private int zdachi;

    public int getZdachi() {
        return zdachi;
    }

    public void setZdachi(int zdachi) {
        this.zdachi = zdachi;
    }

    public Sugar getSugar() {
        return sugar;
    }

    public void setSugar(Sugar sugar) {
        this.sugar = sugar;
    }

    public String getCoffeeName() {
        return coffeeName;
    }

    public void setCoffeeName(String coffeeName) {
        this.coffeeName = coffeeName;
    }

    public int getPRICE_COFFEE() {
        return PRICE_COFFEE;
    }
}
