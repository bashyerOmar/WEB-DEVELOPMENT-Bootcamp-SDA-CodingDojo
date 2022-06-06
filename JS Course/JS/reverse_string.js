
function reverseS(string1){
    var reversedString ="";
    for(var i=string1.length-1; i>=0;i--){
        reversedString += string1[i];
    }

    return reversedString;
}

console.log(reverseS("abcd"));

function acrym(string1){

var words=string1.split(" "); // give us the words of the string1
var char1=[];
var acrym="";
for (i=0; i<words.length;i++){
     char1.push(words[i].charAt(0));
     
}

for(i=0; i<char1.length;i++){
    acrym += char1[i];
}
   
return acrym;
}

console.log(acrym("Bashayer Alghamdi"));