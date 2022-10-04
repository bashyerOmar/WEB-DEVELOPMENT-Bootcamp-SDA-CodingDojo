class Ninja{


    constructor(name) {
        this.name = name;
        this.speed=3;
        this.strength=3;
        this.health=0;
        
    }

    sayName(){
        console.log("ninja name is: "+this.name);
    }

    showStats(){
        console.log(this.constructor.name+" name is: "+this.name+" ,  Strength : "+this.strength+" ,  speed :  "+this.speed+" ,  health :  "+this.health);
    }

    drinkSake(){
        this.health += 10;
    }
}


const ninja1 = new Ninja("Hyabusa");
ninja1.sayName();
ninja1.showStats();
///Output 
//ninja name is: Hyabusa
//Ninja name is: Hyabusa ,  Strength : 3 ,  speed :  3 ,  health :  0

