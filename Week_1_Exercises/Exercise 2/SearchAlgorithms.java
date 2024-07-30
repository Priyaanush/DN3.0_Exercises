import java.util.Arrays;

public class SearchAlgorithms {

    // Linear search
    public static Product linearSearch(Product[] products, String productName) {
        for (Product product : products) {
            if (product.getProductName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    // Binary search (Assuming array is sorted by productName)
    public static Product binarySearch(Product[] products, String productName) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductName().compareTo(productName);

            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Smartphone", "Electronics"),
            new Product(3, "Book", "Books"),
            new Product(4, "Pen", "Stationery")
        };

        // Linear Search
        System.out.println("Linear Search: " + linearSearch(products, "Book"));

        // Sorting products by name for binary search
        Arrays.sort(products, (p1, p2) -> p1.getProductName().compareTo(p2.getProductName()));

        // Binary Search
        System.out.println("Binary Search: " + binarySearch(products, "Book"));
    }
}

