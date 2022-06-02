

function cityMsg(){
alert("Loading Weather Report.....");
}

function remove(){
    var cookie_card=document.querySelector(".cookie-card");
    cookie_card.remove();
}

function changeTemp(){
    var selectedItem=document.getElementById("temp");
    var card_temp_1=document.querySelector("#c1 .red");
    var card_temp_1_1=document.querySelector("#c1 .blue");
    var card_temp_2=document.querySelector("#c2 .red");
    var card_temp_2_1=document.querySelector("#c2 .blue");
    var card_temp_3=document.querySelector("#c3 .red");
    var card_temp_3_1=document.querySelector("#c3 .blue");
    var card_temp_4=document.querySelector("#c4 .red");
    var card_temp_4_1=document.querySelector("#c4 .blue");

    if (selectedItem.value=="F"){
       card_temp_1.innerHTML=75;
       card_temp_1_1.innerHTML=65;
       card_temp_2.innerHTML=80;
       card_temp_2_1.innerHTML=66;
       card_temp_3.innerHTML=69;
       card_temp_3_1.innerHTML=61;
       card_temp_4.innerHTML=78;
       card_temp_4_1.innerHTML=70;
    }

    
}