
import java.util.Scanner;

public class Customer {
    private int id;
    private String name;
    private String address;
    
    public Customer(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
    
    public void setId(int id) {
        this.id = id;
    }
   
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    public int getId() {
        return  + id;
    }
    public String getName() {
        return "Name: " + name;
    }
    public String getAddress() {
        return address;
    }
    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
    }
  
}
