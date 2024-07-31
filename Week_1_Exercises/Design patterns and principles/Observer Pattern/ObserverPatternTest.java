import java.util.Scanner;

public class ObserverPatternTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the stock name from user input
        System.out.print("Enter the stock name: ");
        String stockName = scanner.nextLine();
        
        // Create a stock market instance with user-provided stock name
        StockMarket stockMarket = new StockMarket(stockName);

        // Get observer names from user input
        System.out.print("Enter the name for the first observer (e.g., Mobile App): ");
        String mobileAppName = scanner.nextLine();
        System.out.print("Enter the name for the second observer (e.g., Web App): ");
        String webAppName = scanner.nextLine();

        // Create observer instances with user-provided names
        Observer mobileApp = new MobileApp(mobileAppName);
        Observer webApp = new WebApp(webAppName);

        // Register observers with the stock market
        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        // Get stock prices from user input and notify observers
        System.out.print("Enter the new stock price to set: ");
        double stockPrice = scanner.nextDouble();
        System.out.println("Setting stock price to " + stockPrice);
        stockMarket.setStockPrice(stockPrice);

        // Notify observers with a different stock price
        System.out.print("Enter another stock price to set: ");
        stockPrice = scanner.nextDouble();
        System.out.println("Setting stock price to " + stockPrice);
        stockMarket.setStockPrice(stockPrice);

        // Deregister one observer
        System.out.println("Deregistering the first observer.");
        stockMarket.deregisterObserver(mobileApp);

        // Notify observers with a final stock price
        System.out.print("Enter the final stock price to set after deregistering an observer: ");
        stockPrice = scanner.nextDouble();
        System.out.println("Setting stock price to " + stockPrice);
        stockMarket.setStockPrice(stockPrice);

        // Close the scanner
        scanner.close();
    }
}