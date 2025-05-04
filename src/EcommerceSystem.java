/*team name: Ecommerce System

محمد علي محمد علي    51355
مصطفى ابراهيم السيد احمد	26911
يوسف سالم عبد الخالق محمد	26908
26992     مرام محمود مساعد هيبة
51363      اسماء خالد حسن حسنين
51405      اميره عاطف مبروك احمد
26949	  سلوي خالد محمد جادالله
زياد اسلام احمد مصطفى عطا	51416
احمد سامح محمد    	26987	   
51423    محمود يسري عاطف محمود 
*/

import java.util.*;


public class EcommerceSystem {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("^_^ ^_^ ^_^    Welcome to Ecommerce System    ^_^ ^_^ ^_^ ");
        System.out.println(" please Enter your Id: ");
        int id = sc.nextInt();
        System.out.println(" please Enter your name: ");
        String name = sc.next();
        System.out.println(" please Enter your Address: ");
        String address = sc.next();
        System.out.println("How many products you want to add: ");
        int num = sc.nextInt();
        
        
        cart cart = new cart(id, num);

        
        for (int i = 0; i < num; i++) {
            System.out.println("^_^ ^_^ ^_^    What type of product you want to add?  1. Book  2. Clothing  3. Electronic    ^_^ ^_^ ^_^");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    
                    BookProduct b1 = new BookProduct(3, "OOP", 39.99, "O’Reilly", "X Publications");
                    cart.addProduct(b1);
                    break; 

                case 2:
                    
                    clothingProduct c3 = new clothingProduct(2, "T-shirt", 19.99, "Medium", "Cotton");            
                        cart.addProduct(c3);
                    break; 

                case 3:
                    
                    ElectronicProduct e1 = new ElectronicProduct(1, "Smartphone", 599.99, "Samsung", 1);
                    cart.addProduct(e1);
                    break; 

            
            }
        }
        System.out.println("\nYour total price is " + cart.calculatePrice());
       
        System.out.println("^_^ ^_^ ^_^    Would you like to place an order? 1-Yes 2-No    ^_^ ^_^ ^_^ ");
        int choice1 = sc.nextInt();
        if (choice1 == 1) {
            cart.placeOrder();
        }
        else {
            System.out.println("Goodbye!");
            System.exit(0);
        }
        
      order o1= new order(id, 1, cart.getProducts(), (float) cart.calculatePrice());
      o1.printOrderInfo();
    }
}