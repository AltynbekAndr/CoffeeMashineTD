package com.springapp.mvc.mashine;


import com.springapp.mvc.models.Coffee;
import com.springapp.mvc.models.Sugar;

public interface CoffeeMashineInterface {

    public int getPayCofWithSugar(int pay);
    public int getPayCofWithouthSugar(int pay);

    public Coffee getCoffeeWithoutSugar(String coffeeName);
    public Coffee getCoffeeWithSugar(String coffeeName);



}
