
from flask import Flask , render_template , request


app = Flask(__name__)



@app.route('/')
def form():
    return render_template("dojo_survey.html") 

@app.route('/result' , methods=['POST']) 
def result():
    print("Got Post Info")
    print(request.form)
    
    return render_template("dojo_survey_result.html", name=request.form['name'] , location=request.form['location']
    , lang=request.form['lang'] , comment=request.form['comment'] ) 




if __name__ == "__main__":   
    app.run(debug=True)