package com.springapp.mvc.rest;


//Класс для REST запросов.
//Реализовал не все HTTP методы.Только POST GET  и немного DELETE.
//Тут особой логики и нет.Только проверки на NULL и на 0.



import com.springapp.mvc.mashine.RealCoffeeMashine;
import com.springapp.mvc.models.Coffee;
import com.springapp.mvc.models.DeleteCoffee;
import com.springapp.mvc.models.ModelForAjax;
import com.springapp.mvc.models.Sugar;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest")
public class MyRest {
   
	Coffee coffee = new Coffee();
	Sugar sugar = new Sugar(); 
    RealCoffeeMashine realCoffeeMashine = new RealCoffeeMashine(coffee,sugar);

    DeleteCoffee deleteCoffee;




 //Метод для HTTP/GET запросов.Обьязательные параметры наименование кофе и оплата равный или больше цены кофе.
 // Иначе возвращает NULL.И деньги назад не отдает.

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Object httpGetCoffee(
    		@RequestParam(value="coffeeName") String coffeeName,
            @RequestParam(value="pay") int pay,
            @RequestParam(value="sugar") int sugar) {

        if(coffeeName!=null&&pay>=coffee.getPRICE_COFFEE()){
            if(sugar!=0){
                int zdachi = realCoffeeMashine.getPayCofWithSugar(pay);
                coffee = realCoffeeMashine.getCoffeeWithSugar(coffeeName);
                coffee.setZdachi(zdachi);
                return coffee;
            }else{
                int zdachi = realCoffeeMashine.getPayCofWithouthSugar(pay);
                coffee = realCoffeeMashine.getCoffeeWithoutSugar(coffeeName);
                coffee.setZdachi(zdachi);
                return coffee;
            }

        }
        return null;
    }









    //Метод для HTTP/POST запросов.Принимает класс сущность в котром поля оплата,наименование кофе и поле (int sugar) для храниения числа чтобы
    //включать кофе в покупку или нет.
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public Object httpPostCoffee(@RequestBody ModelForAjax modelForAjax) {
          
    	  String coffeeName;
          int pay,sugar;
        if(modelForAjax!=null){
            coffeeName = modelForAjax.getName_coffee();
            sugar = modelForAjax.getSugar();
            pay = modelForAjax.getPay();

            if(coffeeName!=null&&pay>=coffee.getPRICE_COFFEE()){

             //Если число не равна 0 , то к кофе добавляется сахар.
                if(sugar!=0){
                    int zdachi = realCoffeeMashine.getPayCofWithSugar(pay);
                    coffee = realCoffeeMashine.getCoffeeWithSugar(coffeeName);
                    coffee.setZdachi(zdachi);
                    return coffee;
                }else{
             //передача кофе без сахара.
                    int zdachi = realCoffeeMashine.getPayCofWithouthSugar(pay);
                    coffee = realCoffeeMashine.getCoffeeWithoutSugar(coffeeName);
                    coffee.setZdachi(zdachi);
                    return coffee;
                }

            }


        }
          
        return null;
    }



    /*========================================*/
    @RequestMapping(method = RequestMethod.DELETE)
    public Object httpDeleteCoffee(@RequestParam(value="warning") String warningr) {
                    if(warningr!=null){
                        if(warningr.equals("yes")){
                            coffee = null;
                            deleteCoffee = new DeleteCoffee();
                            deleteCoffee.setResult("DELETED");
                            return deleteCoffee;
                        }else if(warningr.equals("no")){
                            deleteCoffee.setResult("CANCELLING");
                            return deleteCoffee;
                        }
                    }

        return "hello";
    }






    /*========================================*/
    @RequestMapping(method = RequestMethod.PUT)
    public String httpPutCoffee( ) {
        return "hello";
    }

}