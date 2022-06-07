

class MathDojo:
    def __init__(self):
        self.result = 0

    def add(self, num, *nums):
        for n in nums:
           self.result += n
        
        self.result+=num
        return self

    def subtract(self, num, *nums):
        if self.result != 0:  
            self.result-=num
        else:
            self.result=num
        for n in nums:
            self.result-=n
        
        return self


MD1 = MathDojo()
x=MD1.add(2).add(2,5,1).subtract(3,2).result  
print(x) #print 5 


