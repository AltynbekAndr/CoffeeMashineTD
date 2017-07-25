package com.springapp.mvc.models;

//Класс суцщность для Рест контроллера.
//Класс используется в ajax запросе от клиента

public class ModelForAjax {
    private String name_coffee;
    private int pay;
    private int sugar;

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    public String getName_coffee() {
        return name_coffee;
    }

    public void setName_coffee(String name_coffee) {
        this.name_coffee = name_coffee;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }
}
