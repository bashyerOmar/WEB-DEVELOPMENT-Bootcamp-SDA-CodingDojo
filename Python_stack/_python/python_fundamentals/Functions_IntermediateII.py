#Update Values in Dictionaries and Lists

x = [ [5,2,3], [10,8,9] ] 
students = [
     {'first_name':  'Michael', 'last_name' : 'Jordan'},
     {'first_name' : 'John', 'last_name' : 'Rosales'}
]
sports_directory = {
    'basketball' : ['Kobe', 'Jordan', 'James', 'Curry'],
    'soccer' : ['Messi', 'Ronaldo', 'Rooney']
}
z = [ {'x': 10, 'y': 20} ]

############################ Solutions ########################

x[1][0]=15  #change value 10 in x to 15

students[0]["last_name"]="Bryant"      #Change the last_name of the first student from 'Jordan' to 'Bryant'

sports_directory["soccer"][0]="Andres" #In the sports_directory, change 'Messi' to 'Andres'
z[0]["y"]=30                            #Change the value 20 in z to 30



#Iterate Through a List of Dictionaries

def iterateDictionary(Thelist):
    for i in range(0,len(Thelist)):
       print(list(Thelist[i].keys())[0]+" - "+list(Thelist[i].values())[0]+" , "
       +list(Thelist[i].keys())[1]+" - "+list(Thelist[i].values())[1])


#Get Values From a List of Dictionaries
def iterateDictionary2(key_name, Thelist):
    for i in range(0,len(Thelist)):
        print(Thelist[i][key_name])

#Iterate Through a Dictionary with List Values
def printInfo(dict):
    for i in range(0,len(dict)):
        values=list(dict.values())[i]
        keys=(list(dict.keys()))[i]
        print(str(len(values))+" "+keys)

        for j in range(0,len(values)):
            print(values[j])






