
from flask import Flask 


app = Flask(__name__)


#localhost:5000/ - have it say "Hello World!"
@app.route('/')
def hello_world():
    return 'Hello World!' 

#localhost:5000/dojo - have it say "Dojo!"
@app.route('/dojo')
def say_dojo():
    return 'Dojo!' 

#localhost:5000/say/flask - have it say "Hi Flask!"
@app.route('/say/<name>')
def say_name(name):
    return 'Hi, ' + name 

#localhost:5000/repeat/35/hello - have it say "hello" 35 times
@app.route('/repeat/<int:num>/<name>')
def repeat(num,name):
    names={}
    for i in range(num+1):
        names[i]=name
    return names # we can use name*num also

if __name__ == "__main__":   # Ensure this file is being run directly and not from a different module
    app.run(debug=True)