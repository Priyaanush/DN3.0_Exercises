import java.util.Scanner;

public class Mainn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create instances of payment gateways
        PayPal payPal = new PayPal();
        Stripe stripe = new Stripe();

        // Create adapters for the payment gateways
        PaymentProcessor payPalProcessor = new PayPalAdapter(payPal);
        PaymentProcessor stripeProcessor = new StripeAdapter(stripe);

        // Get user input for payment amounts
        System.out.print("Enter payment amount for PayPal: ");
        double payPalAmount = scanner.nextDouble();

        System.out.print("Enter payment amount for Stripe: ");
        double stripeAmount = scanner.nextDouble();

        // Process payments using the adapters
        System.out.println("Processing payments through adapters:");
        payPalProcessor.processPayment(payPalAmount);
        stripeProcessor.processPayment(stripeAmount);

        // Close the scanner
        scanner.close();
    }
}