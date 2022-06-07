# import the python testing framework
import unittest
from MathDojo import MathDojo



md=MathDojo() #instance

class MathTest(unittest.TestCase):

    
    def testAdd(self):
        self.assertEqual(md.add(2,3).result, 5)
        md.result=0
        self.assertEqual(md.add(2,3,50).result, 55)
        md.result=0
        self.assertEqual(md.add(2,100).result, 102)

        

    def testSub(self):
        md.result=0
        self.assertEqual(md.subtract(3,3).result, 0)
        md.result=0
        self.assertEqual(md.subtract(3,3,2).result, -2)
        md.result=0
        self.assertEqual(md.subtract(10,3,3).result, 4)
        
    

if __name__ == '__main__':
    unittest.main() # this runs our tests

