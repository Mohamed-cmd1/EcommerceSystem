        public class clothingProduct extends product{


 String size;
            String fabric;
            
            public clothingProduct(int productId, String name, double price, String size, String fabric)
            {
        
                super(productId, name, price);
                this.size = size;
                this.fabric = fabric;
            }
            
        
            
            public void setSize(String size) {
                this.size = size;
            }
            
        
            
            public void setFabric(String fabric) {
                this.fabric = fabric;
            }
            public String getSize() {
                return size;
            }
            public String getFabric() {
                return fabric;
            }
            
            
        @Override
            public String toString() {
                return super.toString() + ", Size: " + size + ", Fabric: " + fabric;
            }
        }

