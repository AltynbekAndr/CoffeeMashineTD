package com.springapp.mvc;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import com.springapp.mvc.mashine.RealCoffeeMashine;
import com.springapp.mvc.models.Coffee;
import com.springapp.mvc.models.ModelForAjax;
import com.springapp.mvc.models.Sugar;
import com.springapp.mvc.rest.MyRest;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
public class AppTests {
   
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;
    
    MyRest myrest = null;    
    RealCoffeeMashine realCoffeeMashine = null;
    Coffee coffee = null;
    Sugar sugar = null;
    
    @Before
    public void setup() {
    	myrest = new MyRest();
    	coffee = new Coffee();
    	sugar = new Sugar();
    	realCoffeeMashine = new RealCoffeeMashine(coffee , sugar);
   }

    
  


     @Test(expected = ClassCastException.class)
     public void testhttpGetCoffee() throws Exception {
	 
    	Object obj = myrest.httpGetCoffee((String)new Object(), 1, 1);
        if(obj!=null){
        	fail();
        }
  	    
        Object obj2 = myrest.httpGetCoffee("KOFE", 0, -10);
  	    if(obj2!=null){
  	    	fail();
  	    }
  	   
  	    Object obj3 = myrest.httpGetCoffee("", -100, -1000);
	    if(obj3!=null){
	    	fail();
	    }
        
	    Object obj4 = myrest.httpGetCoffee("", 0, 0); 
        if(obj4!=null){
	    	fail();
	    }
      }
 
     
     
     @Test(expected = ClassCastException.class)
     public void testhttpPostCoffee() throws Exception {
	 
    	Object obj = myrest.httpPostCoffee((ModelForAjax)new Object());
        if(obj!=null){
        	fail();
        }
  	  
        Object obj2 = myrest.httpPostCoffee(null);
  	    if(obj2!=null){
  	    	fail();
  	    }
  	 
      }
     
     @Test
     public void testgetPayCofWithSugar() throws Exception {
    	 
         int i = realCoffeeMashine.getPayCofWithSugar(0);
          if(i!=0){
        	  fail();
          }
          
          int i2 = realCoffeeMashine.getPayCofWithSugar(-10);
          if(i2!=0){
        	  fail();
          }
         
          int i3 = realCoffeeMashine.getPayCofWithSugar(100);
          if(i3==0){
        	  fail();
          }
  	 
          }
	     @Test
	     public void testgetPayCofWithouthSugar() throws Exception {
	    	 
	         int i = realCoffeeMashine.getPayCofWithouthSugar(0);
	          if(i!=0){
	        	  fail();
	          }
	          
	          int i2 = realCoffeeMashine.getPayCofWithouthSugar(-10);
	          if(i2!=0){
	        	  fail();
	          }
	         
	          int i3 = realCoffeeMashine.getPayCofWithouthSugar(100);
	          if(i3==0){
	        	  fail();
	          }
	  	 
	      }
	     
	     @Test(expected = ClassCastException.class)
	     public void testgetCoffeeWithoutSugar() throws Exception {
	    	 
	        
	    	 Coffee c = realCoffeeMashine.getCoffeeWithoutSugar("");
	         if(c!=null){
	        	 fail();
	         }
	         
	         Coffee c2 = realCoffeeMashine.getCoffeeWithoutSugar((String) new Object());
	         if(c2!=null){
	        	 fail();
	         }
	         
	         Coffee c3 = realCoffeeMashine.getCoffeeWithoutSugar(null);
	         if(c3!=null){
	        	 fail();
	         }
	      }
	     
	     @Test(expected = ClassCastException.class)
	     public void testgetCoffeeWithSugar() throws Exception {
	    	 
	        
	    	 Coffee c = realCoffeeMashine.getCoffeeWithSugar("");
	         if(c!=null){
	        	 fail();
	         }
	         
	         Coffee c2 = realCoffeeMashine.getCoffeeWithSugar((String) new Object());
	         if(c2!=null){
	        	 fail();
	         }
	         
	         Coffee c3 = realCoffeeMashine.getCoffeeWithSugar(null);
	         if(c3!=null){
	        	 fail();
	         }
	      }
    
    
}
