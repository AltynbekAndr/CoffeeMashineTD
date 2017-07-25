package com.springapp.mvc.mashine;
//Класс для бизнес логики кофе машины.


import com.springapp.mvc.models.Coffee;
import com.springapp.mvc.models.Sugar;

public class RealCoffeeMashine implements CoffeeMashineInterface {
	Coffee coffee = null;
	Sugar sugar = null ;

	public RealCoffeeMashine(Coffee coffee , Sugar sugar){
		this.coffee = coffee;
		this.sugar = sugar;

	}

//Метод для расчета денег.
//Методы вызывается в покупке кофе без сахара и отдает здачи,если денег(параметр (int pay)) больше цены кофе.
//Ничего не возвращает если входной параметр равна нулю.
	@Override
	public int getPayCofWithSugar(int pay) {
      if(pay>=(coffee.getPRICE_COFFEE()+sugar.getPrice())){
		  if(pay>(coffee.getPRICE_COFFEE()+sugar.getPrice())){
			  coffee.setSugar(sugar);
			  return pay - (coffee.getPRICE_COFFEE()+sugar.getPrice());
		  }else{
			  coffee.setSugar(sugar);
			  return 0;
		  }
	  }
		return 0;
	}
//Метод для расчета денег.
//Методы вызывается в покупке кофе c сахаром и отдает здачи,если денег(параметр (int pay)) больше цены кофе.
//Ничего не возвращает если входной параметр равна нулю.
	@Override
	public int getPayCofWithouthSugar(int pay) {
		if(pay>=coffee.getPRICE_COFFEE()){
			if(pay>coffee.getPRICE_COFFEE()){
				coffee.setSugar(null);
				return pay - coffee.getPRICE_COFFEE();
			}else{
				coffee.setSugar(null);
				return 0;
			}

		}

		return 0;
	}
//Метод для получения кофе без сахара.В качестве параметра принимает наименование кофе (String coffeeName)...
	@Override
	public Coffee getCoffeeWithoutSugar(String coffeeName) {
		if(coffeeName!=null && coffeeName!=""){
			coffee.setCoffeeName(coffeeName);
			return coffee;
		}
		return null;
	}
//Метод для получения кофе с сахаром.В качестве параметра принимает наименование кофе (String coffeeName)...
	@Override
	public Coffee getCoffeeWithSugar(String coffeeName) {
		if(coffeeName!=null && coffeeName!=""){
			coffee.setCoffeeName(coffeeName);
			return coffee;
		}
		return null;
	}
}
