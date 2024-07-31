import java.util.HashMap;

public class InventoryManagement {
    private HashMap<Integer, Product> products;

    public Inventory() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    public void updateProduct(int productId, Product updatedProduct) {
        products.put(productId, updatedProduct);
    }

    public void deleteProduct(int productId) {
        products.remove(productId);
    }

    public Product getProduct(int productId) {
        return products.get(productId);
    }
}

