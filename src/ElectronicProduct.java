
public class ElectronicProduct extends product {

    

 private String brand;
 private int warrantyPeriod;

 public ElectronicProduct(int productId, String name, double price, String brand, int warrantyPeriod) {
     
     super(productId, name, price);
     this.brand=brand;
     this.warrantyPeriod=warrantyPeriod;
 }
 

 
 private void setBrand(String brand) {
     this.brand = brand;
 }
 
 
 
 private void setwarrantyPeriod(int warrantyPeriod) {
    
     this.warrantyPeriod = warrantyPeriod;
     if (warrantyPeriod < 0) {
         this.warrantyPeriod = Math.abs(warrantyPeriod);
     }
 }
 public String getBrand() {
    return brand;
}
public int getWarrantyPeriod() {
    return warrantyPeriod;
}

 


 
@Override
public String toString() {
    return super.toString() + ", Brand: " + brand + ", Warranty: " + warrantyPeriod + " years";
}
}