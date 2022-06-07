
class animal:

    def __init__(self,name):
        self.name=name
        self.health_level=0
        self.happiness_level=0


    def feed(self):
        self.health_level+=10
        self.happiness_level+=10
        return self

    def display_info(self):
            print(f"The animal is {type(self)} -- name:{self.name} -- happiness_level: {self.happiness_level} --  health level: {self.health_level}")


class cat(animal):
    Age=5
    def __init__(self,name):
        super().__init__(name)
        self.name=name
        self.family="Felidae"
        super().feed().feed()


class dog(animal):
    Age=7
    def __init__(self,name):
        super().__init__(name)
        self.name=name
        self.family="Canidae"
        super().feed()
        

class tiger(animal):
    Age=9
    def __init__(self,name):
        super().__init__(name)
        self.name=name
        self.family="Felidae"
        super().feed().feed().feed()
        
        

class Zoo:
    def __init__(self, zoo_name):
        self.animals =[]
        self.name = zoo_name

    def add_dog(self, name):
        self.animals.append( dog(name) )

    def add_tiger(self, name):
        self.animals.append( tiger(name) )

    def add_cat(self,name):
        self.animals.append(cat(name))

    def print_all_info(self):
        print("-"*30, self.name, "-"*30)
        for animal in self.animals:
            animal.display_info()
        


zoo1 = Zoo("John's Zoo")
zoo1.add_dog("Nala")
zoo1.add_dog("Simba")
zoo1.add_tiger("Rajah")
zoo1.add_tiger("Shere Khan")
zoo1.add_cat("possy")
zoo1.add_cat("lily")
zoo1.print_all_info()