import java.util.Scanner;

public class StrategyPatternTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PaymentContext paymentContext = new PaymentContext();

        // Select payment method
        System.out.println("Select payment method:");
        System.out.println("1. Credit Card");
        System.out.println("2. PayPal");
        System.out.print("Enter choice (1 or 2): ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        // Get payment amount
        System.out.print("Enter payment amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();  // Consume newline

        // Process payment based on user choice
        switch (choice) {
            case 1:
                // Credit Card Payment
                System.out.print("Enter card number: ");
                String cardNumber = scanner.nextLine();
                System.out.print("Enter card holder name: ");
                String cardHolderName = scanner.nextLine();
                paymentContext.setPaymentStrategy(new CreditCardPayment(cardNumber, cardHolderName));
                break;

            case 2:
                // PayPal Payment
                System.out.print("Enter PayPal email: ");
                String email = scanner.nextLine();
                paymentContext.setPaymentStrategy(new PayPalPayment(email));
                break;

            default:
                System.out.println("Invalid choice. No payment method selected.");
                return;
        }

        // Execute payment
        paymentContext.executePayment(amount);

        // Close the scanner
        scanner.close();
    }
}