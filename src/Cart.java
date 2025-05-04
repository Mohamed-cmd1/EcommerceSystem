
class cart {
    private int customerId;
    private int nProducts;
    private product[] products;

   
    public cart(int customerId, int nProducts) {
        this.customerId = Math.abs(customerId); 
        this.nProducts = 0;
        this.products = new product[nProducts];
    }

    
    

    public void setCustomerId(int customerId) {
        this.customerId = Math.abs(customerId); 
    }

    

    public void setnProducts(int nProducts) {
        this.nProducts = Math.abs(nProducts);
    }

    

    public void setProducts( product[] products) {
        this.products = products;
    }
    public int getCustomerId() {
        return customerId;
    }
    public int getnProducts() {
        return nProducts;
    }
    public product[] getProducts() {
        return products;
    }

   
    public void addProduct(product product) {
        
        if (nProducts < products.length) {
            products[nProducts] = product;
            nProducts++;
        }
        
    }


    public void removeProduct(int productId) {
        for (int i = 0; i < nProducts; i++) {
            if (products[i].productId == productId) {
                for (int a = i; a < nProducts - 1; a++) {
                    products[a] = products[a+ 1];
                }
                nProducts--;
                break;
            }
        }
    }

    
    public float  calculatePrice() {
        float total = 0;
        for (int i = 0; i < nProducts; i++) {
            total += products[i].price;
        }
        return total;
    }

  
    public void placeOrder() {
        
           
            System.out.println("Order placed successfully!");
            System.out.println("Total Price: " + calculatePrice());
       
    }
}
