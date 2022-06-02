

function secondLargestVal(arr){

   var firstLargestNum=Math.max(...arr);
   var secondLargestNum=0;
   for(var i=0; i<arr.length;i++){
       if (arr[i] > secondLargestNum && arr[i]<firstLargestNum){
           secondLargestNum = arr[i];
       }
   }

   return secondLargestNum;
}
var arr=[1,2,3,4,5];

console.log(secondLargestVal(arr));