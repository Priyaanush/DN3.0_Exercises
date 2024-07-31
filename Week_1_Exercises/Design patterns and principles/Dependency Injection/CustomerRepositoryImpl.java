public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findCustomerById(String id) {
        // Simulate a database fetch
        return new Customer(id, "John Doe");
    }
}