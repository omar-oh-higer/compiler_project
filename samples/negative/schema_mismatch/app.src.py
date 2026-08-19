from flask import Flask, render_template

app = Flask(__name__)

SEED_ITEMS = [
    {"id": 1, "name": "Widget"}
]

@app.route("/item")
def show_item():
    product = SEED_ITEMS[0]
    return render_template("item.html", product=product)

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000, debug=True)
