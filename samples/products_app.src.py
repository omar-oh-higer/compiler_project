from flask import Flask, render_template, request, redirect, url_for
import json

app = Flask(__name__)

SEED_PRODUCTS = [
    {"id": 1, "name": "Keyboard", "price": 19.99, "description": "Mechanical keyboard", "image": "keyboard.png"},
    {"id": 2, "name": "Mouse", "price": 9.99, "description": "Wireless mouse", "image": "mouse.png"}
]

def load_products():
    with open("data/products.json", "r") as f:
        return json.load(f)["products"]

def save_products(products):
    with open("data/products.json", "w") as f:
        json.dump({"products": products}, f, indent=4)

def generate_new_id(products):
    i = 0
    max_id = 0
    while i < len(products):
        if products[i]["id"] > max_id:
            max_id = products[i]["id"]
        i += 1
    return max_id + 1

@app.route("/")
def index():
    return redirect(url_for("products"))

@app.route("/products")
def products():
    items = load_products()
    return render_template("products.html", products=items)

@app.route("/products/add", methods=["GET", "POST"])
def add_product():
    if request.method == "POST":
        name = request.form.get("name")
        price = request.form.get("price")
        description = request.form.get("description")
        image = request.form.get("image")
        if name is None or price is None:
            return render_template("add_product.html")
        elif name == "":
            return render_template("add_product.html")
        else:
            items = load_products()
            new_id = generate_new_id(items)
            items.append({"id": new_id, "name": name, "price": price, "description": description, "image": image})
            save_products(items)
            return redirect(url_for("products"))
    return render_template("add_product.html")

@app.route("/products/<int:id>")
def product_details(id):
    items = load_products()
    found = None
    for p in items:
        if p["id"] == id:
            found = p
            break
    if found is None:
        return redirect(url_for("products"))
    return render_template("product_details.html", product=found)

@app.route("/products/<int:id>/edit", methods=["GET", "POST"])
def edit_product(id):
    items = load_products()
    target = None
    for p in items:
        if p["id"] == id:
            target = p
            break
    if target is None:
        return redirect(url_for("products"))
    if request.method == "POST":
        target["name"] = request.form.get("name")
        target["price"] = request.form.get("price")
        target["description"] = request.form.get("description")
        target["image"] = request.form.get("image")
        save_products(items)
        return redirect(url_for("products"))
    return render_template("edit_product.html", product=target)

@app.route("/products/<int:id>/delete")
def delete_product(id):
    items = load_products()
    remaining = []
    for p in items:
        if p["id"] != id:
            remaining.append(p)
    save_products(remaining)
    return redirect(url_for("products"))

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000, debug=True)
