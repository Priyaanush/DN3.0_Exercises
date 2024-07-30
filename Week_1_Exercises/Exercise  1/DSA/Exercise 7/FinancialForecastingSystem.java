import java.util.Scanner;

public class FinancialForecastingSystem {

    /**
     * Recursive method to calculate future value.
     *
     * @param currentValue The initial value of the investment.
     * @param growthRate   The growth rate per period (as a decimal, e.g., 0.05 for 5%).
     * @param periods      The number of periods into the future.
     * @return The future value of the investment.
     */
    public static double calculateFutureValue(double currentValue, double growthRate, int periods) {
        // Base case: If no periods remain, return the current value
        if (periods == 0) {
            return currentValue;
        }
        // Recursive case: Compute future value by growing the current value
        return calculateFutureValue(currentValue * (1 + growthRate), growthRate, periods - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter the initial investment amount: ");
        double initialValue = scanner.nextDouble();

        System.out.print("Enter the growth rate per period (as a decimal):");
        double growthRate = scanner.nextDouble();

        System.out.print("Enter the number of periods: ");
        int periods = scanner.nextInt();

        // Calculate future value
        double futureValue = calculateFutureValue(initialValue, growthRate, periods);

        // Display the result
        System.out.printf("The future value after %d periods is: %.2f%n", periods, futureValue);

        scanner.close(); // Close the scanner
    }
}