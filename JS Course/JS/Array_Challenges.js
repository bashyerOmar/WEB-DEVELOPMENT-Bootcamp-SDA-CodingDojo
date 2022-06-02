
// Write a function that is given an array and each time the value is "food" it should console log "yummy".
// If "food" was not present in the array console log "I'm hungry" once.
function alwaysHungry(arr) {
    var foodCounter = 0;
    for (var i = 0; i < arr.length; i++) {
        if (arr[i] == "food") {
            console.log("yummy");
            foodCounter++;
        }
    }
    if (foodCounter == 0)
        console.log("Iam hungry");

}

// Given an array and a value cutoff, return a new array containing only the values larger than cutoff.
function highPass(arr, cutoff) {
    var filteredArr = [];
    for (var i = 0; i < arr.length; i++) {
        if (arr[i] > cutoff) {
            filteredArr.push(arr[i]);
        }
    }
    return filteredArr;
}

//Given an array of numbers return a count of how many of the numbers are larger than the average.
function betterThanAverage(arr) {
    var sum = 0;
    var count = 0
    //sum all the values in the array
    for (var i = 0; i < arr.length; i++) {
        sum += arr[i];
    }
    //calculate average 
    var avrg = sum / arr.length;

    //count how many valuse greater than average
    for (var i = 0; i < arr.length; i++) {
        if (arr[i] > avrg) {
            count++
        }
    }

    return count;
}

//Write a function that will reverse the values an array and return them.
function reverse(arr) {
    var reversedaArr = [];
    for (var i = arr.length - 1; i >= 0; i--) {
        reversedaArr.push(arr[i]);
    }

    return reversedaArr;
}

// Fibonacci numbers are calculated by adding the last two values in the sequence together. 
//So if the 4th value is 2 and the 5th value is 3 then the next value in the sequence is 5.

function fibonacciArray(n) {
    // the [0, 1] are the starting values of the array to calculate the rest from

    var fibArr = [0, 1];
    for (var i = 0; i < n-2; i++) {
        
         fibArr.push(fibArr[i] + fibArr[i+1]);     
    }

    return fibArr;
}

