
function pizzaOven(crustType , sauceType, cheeses , toppings){
    var pizza ={}; // JS object 
    pizza.crustType = crustType;
    pizza.sauceType = sauceType;
    pizza.cheeses = cheeses;
    pizza.toppings = toppings;

    return pizza;
}




function randomPizza(){
    var Pizza1 = pizzaOven ("deep dish", "traditional1" , ["mozzarella"] , ["pepperoni", "sausage"]);
    var Pizza2 =pizzaOven("hand tossed", "traditional", ["mozzarella", "feta"], ["mushrooms", "olives", "onions"]);
    var Pizza3 =pizzaOven("deep dish", "marinara", ["mozzarella", "feta"],["beef", "onions"]);
    var Pizza4 =pizzaOven("hand tossed", "marinara", ["mozzarella", "feta"], ["chicken", "ranch", "onions"]);
    
    var randomPizza ={
        
        1:{Pizza1 }
        ,
        2:{Pizza2 }
        ,
        3:{ Pizza3 }
        ,
        4:{Pizza4}
    }

    // pick random pizza between 1 to 4 
    var pickPizza = Math.floor((Math.random() * 4) + 1);
    return console.log(randomPizza[pickPizza]);
}


randomPizza();


