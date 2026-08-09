def demo(items):
    for item in items:
        if item["id"] > 0:
            while item["id"] > 10:
                item["id"] -= 1
                if item["id"] == 5:
                    break
    return items
