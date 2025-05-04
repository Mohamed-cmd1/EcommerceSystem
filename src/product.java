public class product {
    int productId;
     String name;
    double price;

    public product(int productId, String name, double price) {
       this.productId = productId;
       this.name = name;
       this.price = price;
    }

    private void setProductId(int productId) {
        if (productId < 0) {
            this.productId = Math.abs(productId);
        } 
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setPrice(double price) {
        if (price < 0) {
            this.price = Math.abs(price);
        } 
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ID: " + productId + ", Name: " + name + ", Price: $" + price;
    }
}
