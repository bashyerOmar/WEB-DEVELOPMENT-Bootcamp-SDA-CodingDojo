#Biggie Size - 
# Given a list, write a function that changes all positive numbers in the list to "big".

def biggie_size(list):
    for x in range(0,len(list)):
        if list[x] >0:
            list[x]="big"
    return list

print(biggie_size([1,2,3,-1]))

#Count Positives - 
# Given a list of numbers, create a function to replace the last value with the number of positive values. 
# (Note that zero is not considered to be a positive number).

def count_positive(list):
    counter=0
    for x in range(0,len(list)):
        if list[x] > 0:
            counter+=1
    list[len(list)-1]=counter # replace last value with number of the positive values 
    return list

print(count_positive([1,2,3,4,-1]))


# Sum Total - Create a function that takes a list and returns the sum of all the values in the list.
def sum(list):
    sum=0
    for x in range(0,len(list)):
        sum+=list[x]
    return sum

print(sum([1,1,1,1,1]))

#Average - Create a function that takes a list and returns the average of all the values.x
def average(list):
    sum=0
    avrg=0
    for x in range(0,len(list)):
        sum+=list[x]
    avrg=sum/len(list)
    return avrg

print(average([1,2,3,4]))
        
#Length - Create a function that takes a list and returns the length of the list.
def length_list(list):
    return len(list)

#Minimum - Create a function that takes a list of numbers and returns the minimum value in the list. 
# If the list is empty, have the function return False
def min(list):
    min=list[0]
    if len(list) ==0:
        return False
    for x in range(1,len(list)):
        if list[x] < min:
            min=list[x]
    return min

print(min([1,2,3,4,-1]))

#Maximum - Create a function that takes a list and returns the maximum value in the list.
#  If the list is empty, have the function return False.

def max(list):
    max=list[0]
    if len(list) ==0:
        return False
    for x in range(1,len(list)):
        if list[x] > max:
            max=list[x]
    return max

print(max([1,2,3,4,-1]))


#Ultimate Analysis - 
# Create a function that takes a list and returns a dictionary that has the sumTotal,
#  average, minimum, maximum and length of the list.

def dictionary(list):
    dict={}
    dict['sumTotal']=sum(list)
    dict['average']=average(list)
    dict['minimum']=min(list)
    dict['maximum']=max(list)
    dict['length']=length_list(list)
    return dict

print(dictionary([2,1,3,4]))

    
#Reverse List - Create a function that takes a list and return that list with values reversed. 
# Do this without creating a second list. (This challenge is known to appear during basic technical interviews.)

def reverse(list):
    firstElement=list[0]
    lastelement=list[len(list)-1]
    c=1
    for x in range(len(list)-2,1,-1):
        list[x]=list[c]
        c+=1
    list[0]=lastelement
    list[len(list)-1]=firstElement
    return list


print(reverse([1,2,3,4,5]))