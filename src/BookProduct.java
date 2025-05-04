public class BookProduct extends product {
    
    private String author;
    private String publisher;
    
    
    public BookProduct(int productId, String name, double price, String author, String publisher) {
        
        super(productId, name, price);
        this.author = author;
        this.publisher = publisher;
    }
    
   
    
    private void setAuthor(String author) {
        this.author = author;
    }
    
    
    
    private void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public String getAuthor() {
        return author;
    }
    public String getPublisher() {
        return publisher;
    }
    

    @Override
    public String toString() {
        return super.toString() + ", Author: " + author + ", Publisher: " + publisher;
    }
}