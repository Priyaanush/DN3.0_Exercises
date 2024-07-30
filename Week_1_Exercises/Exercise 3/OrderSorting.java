import java.util.Scanner;

// Step 2: Create a class Order
class Order {
    int orderId;
    String customerName;
    double totalPrice;

    // Constructor
    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    // Getters
    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "OrderId: " + orderId + ", CustomerName: " + customerName + ", TotalPrice: $" + totalPrice;
    }
}

// Step 3: Implement sorting algorithms
public class OrderSorting {

    // Bubble Sort
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    // Swap orders[j] and orders[j + 1]
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = (low - 1); // Index of smaller element
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivot) {
                i++;
                // Swap orders[i] and orders[j]
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        // Swap orders[i + 1] and orders[high] (or pivot)
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of orders: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Order[] orders = new Order[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for order " + (i + 1) + ":");
            System.out.print("Order ID: ");
            int orderId = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Customer Name: ");
            String customerName = scanner.nextLine();
            System.out.print("Total Price: ");
            double totalPrice = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            orders[i] = new Order(orderId, customerName, totalPrice);
        }

        // Bubble Sort
        Order[] bubbleSortedOrders = orders.clone();
        long startTimeBubble = System.currentTimeMillis();
        bubbleSort(bubbleSortedOrders);
        long endTimeBubble = System.currentTimeMillis();

        System.out.println("\nOrders sorted by Bubble Sort:");
        for (Order order : bubbleSortedOrders) {
            System.out.println(order);
        }
        System.out.println("Bubble Sort Time: " + (endTimeBubble - startTimeBubble) + " ms");

        // Quick Sort
        Order[] quickSortedOrders = orders.clone();
        long startTimeQuick = System.currentTimeMillis();
        quickSort(quickSortedOrders, 0, quickSortedOrders.length - 1);
        long endTimeQuick = System.currentTimeMillis();

        System.out.println("\nOrders sorted by Quick Sort:");
        for (Order order : quickSortedOrders) {
            System.out.println(order);
        }
        System.out.println("Quick Sort Time: " + (endTimeQuick - startTimeQuick) + " ms");

        // Close the scanner
        scanner.close();

        // Analysis of time complexity
        System.out.println("\nAnalysis:");
        System.out.println("1. Bubble Sort Time Complexity: O(n^2)");
        System.out.println("   - Best Case: O(n) (if already sorted)");
        System.out.println("   - Average Case: O(n^2)");
        System.out.println("   - Worst Case: O(n^2) (if sorted in reverse)");

        System.out.println("2. Quick Sort Time Complexity: O(n log n)");
        System.out.println("   - Best Case: O(n log n) (balanced partitioning)");
        System.out.println("   - Average Case: O(n log n)");
        System.out.println("   - Worst Case: O(n^2) (if already sorted or bad pivot)");

        System.out.println("\nWhich algorithm is more suitable?");
        System.out.println("Quick Sort is generally preferred over Bubble Sort for large datasets due to its better time complexity of O(n log n) compared to O(n^2) for Bubble Sort.");
        System.out.println("Quick Sort performs faster on average and is more efficient for larger datasets.");
    }
}