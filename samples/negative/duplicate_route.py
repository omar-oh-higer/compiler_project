from flask import Flask

app = Flask(__name__)

@app.route("/products")
def products_list():
    return "ok"

@app.route("/products")
def products_list_again():
    return "ok"
