import java.util.Arrays;
import java.util.Scanner;

// Step 2: Create a class Product
class Product {
    int productId;
    String productName;
    String category;

    // Constructor
    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    // Getters for attributes
    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "ProductId: " + productId + ", ProductName: " + productName + ", Category: " + category;
    }
}

// Step 3: Implement linear search and binary search algorithms
public class ECommerceSearch {

    // Linear Search
    public static Product linearSearch(Product[] products, int searchId) {
        for (Product product : products) {
            if (product.getProductId() == searchId) {
                return product;
            }
        }
        return null; // Product not found
    }

    // Binary Search (assumes products array is sorted by productId)
    public static Product binarySearch(Product[] products, int searchId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (products[mid].getProductId() == searchId) {
                return products[mid];
            } else if (products[mid].getProductId() < searchId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; // Product not found
    }

    public static void main(String[] args) {
        
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Smartphone", "Electronics"),
            new Product(3, "Coffee Maker", "Home Appliances"),
            new Product(4, "Desk Chair", "Furniture"),
            new Product(5, "Washing Machine", "Home Appliances")
        };


        Arrays.sort(products, (a, b) -> Integer.compare(a.getProductId(), b.getProductId()));

        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter product ID to search: ");
        int searchId = scanner.nextInt();

        // Test linear search
        Product foundProductLinear = linearSearch(products, searchId);
        System.out.println("Linear Search Result:");
        System.out.println(foundProductLinear != null ? foundProductLinear : "Product not found");

        // Test binary search
        Product foundProductBinary = binarySearch(products, searchId);
        System.out.println("Binary Search Result:");
        System.out.println(foundProductBinary != null ? foundProductBinary : "Product not found");

        
        scanner.close();

        // Analysis of time complexity
        System.out.println("\nAnalysis:");
        System.out.println("1. Linear Search Time Complexity: O(n)");
        System.out.println("   - Best Case: O(1) (item is the first in the array)");
        System.out.println("   - Average Case: O(n/2)");
        System.out.println("   - Worst Case: O(n) (item is not found or is the last item)");

        System.out.println("2. Binary Search Time Complexity: O(log n)");
        System.out.println("   - Best Case: O(1) (item is at the middle of the array)");
        System.out.println("   - Average Case: O(log n)");
        System.out.println("   - Worst Case: O(log n) (item is not found)");

        System.out.println("\nWhich algorithm is more suitable?");
        System.out.println("Binary search is more suitable for large datasets, given that the array is sorted.");
        System.out.println("It has a better time complexity of O(log n) compared to O(n) of linear search, making it more efficient for large arrays.");
    }
}