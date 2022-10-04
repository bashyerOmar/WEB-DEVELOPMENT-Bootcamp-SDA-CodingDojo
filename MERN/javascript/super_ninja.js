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



class Sensi extends Ninja{

    constructor(name){
        super(name);
        this.wisdom=20;
        super.health=200;
        super.speed=10;
        super.strength=10;
    }


    speakWisdom(){
        super.drinkSake();
        console.log("What one programmer can do in one month, two programmers can do in two months.");
    }
 
}

// example output
const superSensei = new Sensi("Master Splinter");
superSensei.speakWisdom();
//What one programmer can do in one month, two programmers can do in two months.
superSensei.showStats();
//Sensi name is: Master Splinter ,  Strength : 10 ,  speed :  10 ,  health :  210

