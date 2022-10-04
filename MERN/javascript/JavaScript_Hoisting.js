// ########### 1 #############
console.log(hello);                                   
var hello = 'world';                                 
//how interpreter seen :
//var hello;               // the declaration gets hoisted to the top
//console.log(hello);      // log undefined 
//hello = 'world'; 


// ########### 2 #############
var needle = 'haystack';
test();
function test(){
    var needle = 'magnet';
    console.log(needle);
}
//how interpreter seen :
//var needle;              // global scope and the declaration gets hoisted to the top
//function test(){         // test func hoisted to the top 
//var needle;             // function scoped 
//console.log(needle);   // log magnet
//}
//neddle = 'haystack';   // assign value to global needle
//test();               // call test func and run log magnet


// ########### 3 #############
var brendan = 'super cool';
function print(){
    brendan = 'only okay';
    console.log(brendan);
}
console.log(brendan);
//how interpreter seen :
//var brendan;                // global scope and the declaration gets hoisted to the top
//function print(){
//brendan = 'only okay';     //assign value to the function scoped brendan
//console.log(brendan);     // log 'only okay' if the print func called !!
//}
//brendan = 'super cool';   // assign value to brendan global scoped 
//console.log(brendan);    // log super cool

// ########### 4 #############
var food = 'chicken';
console.log(food);
eat();
function eat(){
    food = 'half-chicken';
    console.log(food);
    var food = 'gone';
}
//how interpreter seen :
//var food;                // global scope and the declaration gets hoisted to the top
//food='chicken';
//console.log(food);       //log chicken 
//function eat(){          //func hoisted 
//var food;                // function scoped food declaration gets hoisted to the top
//food = 'half-chicken';     //assign value to the function scoped food 
//console.log(food);     // log half-chicken 
//food='gone';           //assign new value to the func scoped food 
//}
//eat();                // call eat() and log will excute


// ########### 5 #############
mean();
console.log(food);
var mean = function() {
    food = "chicken";
    console.log(food);
    var food = "fish";
    console.log(food);
}
console.log(food);
// TypeError: mean is not a function


// ########### 6 #############
console.log(genre);
var genre = "disco";
rewind();
function rewind() {
    genre = "rock";
    console.log(genre);
    var genre = "r&b";
    console.log(genre);
}
console.log(genre);

//how interpreter seen :
//var genre;              //global scope
//console.log(genre);     // log undefined 
// function rewind() {
// var genre;             // func scoped genre hoisted 
//  genre = "rock";       // assign value to func scoped genre 
//  console.log(genre);   // log rock 
//  genre = "r&b";       // re-assign value to func scoped genre 
//  console.log(genre);  // log r&b
//     }
//rewind();             // call rewind
//genre="disco";        //assign value to global genre
//console.log(genre);   // log disco


// ########### 7 #############
dojo = "san jose";
console.log(dojo);
learn();
function learn() {
    dojo = "seattle";
    console.log(dojo);
    var dojo = "burbank";
    console.log(dojo);
}
console.log(dojo);
//how interpreter seen :
//var dojo;                  // dojo decalration get hoisted to top   
//dojo = "san jose";        //assign value to global scoped dojo
//console.log(dojo);       //log san jose
//function learn() {      //func declaration get hoisted to top  
//var dojo;               // func scoped dojo
 // dojo = "seattle";     //asssign value to func scoped dojo
// console.log(dojo);      //log seattle
//dojo = "burbank";       //re-assign value to dojo 
// console.log(dojo);     //log burbank
 // }
//learn();              // func call
//console.log(dojo);    //log san jose








