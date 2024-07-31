import java.util.Scanner;

public class DependencyInjectionTest {
    public static void main(String[] args) {
        // Create a CustomerRepository implementation
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        // Inject CustomerRepository into CustomerService using constructor injection
        CustomerService customerService = new CustomerService(customerRepository);

        // Get user input for customer ID
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter customer ID to find: ");
        String customerId = scanner.nextLine();

        // Find and display customer
        Customer customer = customerService.getCustomerById(customerId);
        System.out.println("Customer found: " + customer);

        scanner.close();
    }
}