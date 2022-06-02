console.log("page loaded...");

function remove(element){

    // get id of the desired <li> to remove it 
    var idOftheietmToRemove=element.parentNode.parentNode.id
     // get the item by its id 
    var itemToRemove = document.getElementById(idOftheietmToRemove);
    itemToRemove.remove();

   // decrease the connection requests number 
   var requestNum=document.querySelector(".badge");
   var requestcounter=parseInt(requestNum.innerHTML)-1;
   requestNum.innerHTML=requestcounter;
   //increase the your connections badges
   var YourConnectionNum = document.getElementById("connectionNum");
   YourConnectionNum.innerHTML=parseInt(YourConnectionNum.innerHTML)+1;
}


function imgClick(){
    // replace card body h1 
    var name = document.querySelector(".card-body h1");
    name.innerHTML="Bashayer Alghamdi";
    
}

