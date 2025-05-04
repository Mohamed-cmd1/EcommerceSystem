
public class order {
    private int customerId;
    private int orderId;
    private product[] products;
    private float   totalPrice;

 
    public order(int customerId,int orderId, product[] products, float  totalPrice) {
        this.customerId = Math.abs(customerId);
        this.orderId = Math.abs(orderId);
        this.products = products;
        this.totalPrice = Math.abs(totalPrice);
    }

    
   

    public void setCustomerId(int customerId) {
        this.customerId = Math.abs(customerId);
    }

    

    public void setOrderId(int orderId) {
        this.orderId = Math.abs(orderId);
    }

    

    public void setProducts(product[] products) {
        this.products = products;
    }

    

    public void setTotalPrice(float   totalPrice) {
        this.totalPrice = Math.abs(totalPrice);
    }
    public int getCustomerId() {
        return customerId;
    }
    public int getOrderId() {
        return orderId;
    }
    public product[] getProducts() {
        return products;
    }
    public float   getTotalPrice() {
        return totalPrice;
    }

   
    public void   printOrderInfo() {
        System.out.println("Here's your order's summary:");
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer ID: " + customerId);
        System.out.println("Products:");
        
        for (product product : products) {
            if (product != null) {
                System.out.println(product.getName() + " " + product.getPrice());
            }
        }
        System.out.println("Total Price: " + totalPrice);
    }
    // ^-^ ^-^ ^-^ Override the toString() method to use in gui ^-^ ^-^ ^-^
    @Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Here's your order's summary:\n");
    sb.append("Order ID: ").append(orderId).append("\n");
    sb.append("Customer ID: ").append(customerId).append("\n");
    sb.append("Products:\n");

    for (product product : products) {
        if (product != null) {
            sb.append("- ").append(product.getName())
              .append(" : ").append(product.getPrice()).append("\n");
        }
    }

    sb.append("Total Price: ").append(totalPrice).append("\n");
    return sb.toString();
}

}