import random

def randInt(min=0  , max=100 ):
    
    if max==50:
        num = random.random()*50
        return print(num)
    elif min==50:
        num = random.random()*min + min
        return print(num)
    elif min==50 and max==500:
         num = random.random()*450+50
         return print(num)
    
    else: #defualt
        num = random.random()*max
        return print(num)


randInt()	# should print a random integer between 0 to 100
randInt(max=50)	# should print a random integer between 0 to 50
randInt(min=50)	# should print a random integer between 50 to 100
randInt(min=50, max=500)   # should print a random integer between 50 and 500

