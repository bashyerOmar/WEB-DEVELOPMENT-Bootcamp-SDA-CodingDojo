
#Countdown - 
# Create a function that accepts a number as an input. Return a new list that counts down by one, 
# from the number (as the 0th element) down to 0 (as the last element).

def countDown(number):
    list=[]
    for x in range(number+1,-1,-1):
        list.append(x)
    print(list)

countDown(9)

#Print and Return 
# Create a function that will receive a list with two numbers. Print the first value and return the second.

def PrintFirst_Return_Second(list):
        print(list[0])
        return list[1]

secondNum=PrintFirst_Return_Second([1,2])
print(secondNum)

#First Plus Length - 
# Create a function that accepts a list and returns the sum of the first value in the list plus the list's length.

def First_plus_len(list):
    return print(list[0]+len(list))

First_plus_len([1,2,3])

#Values Greater than Second - 
# Write a function that accepts a list 
# and creates a new list containing only the values from the original list that are greater than its 2nd value. 
# Print how many values this is and then return the new list. 
# If the list has less than 2 elements, have the function return False

def greater_than_second(list):
    counter=0 # for count the values which greater than 2nd value 
    newlist=[]
    if len(list) < 2:
        return False
    
    for x in range(0,len(list)):
        if list[1] < list[x]: # second element in the list smaller than list[x]
           newlist.append(list[x])
           counter+=1 
    print("the number values that greater than {} are {} numbers ".format(list[1],counter)) # we can replace counter with len(newlist)
    return print(newlist)

greater_than_second([5,2,3,2,1,4])


#This Length, That Value -
#  Write a function that accepts two integers as parameters: size and value. 
# The function should create and return a list whose length is equal to the given size, and whose values are all the given value.

def length_value(size,value):
    list=[value]*size
    print(list)

length_value(4,7);

