import java.util.Scanner;

class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    // Constructor
    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    // Getters
    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "EmployeeId: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: $" + salary;
    }
}

public class EmployeeManagementSystem {
    private Employee[] employees;
    private int size;

    // Constructor
    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    // Add an employee
    public void addEmployee(Employee employee) {
        if (size < employees.length) {
            employees[size++] = employee;
            System.out.println("Employee added successfully.");
        } else {
            System.out.println("Array is full. Cannot add more employees.");
        }
    }

    // Search for an employee by ID
    public Employee searchEmployeeById(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse and print all employees
    public void traverseEmployees() {
        if (size == 0) {
            System.out.println("No employees to display.");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete an employee by ID
    public void deleteEmployeeById(int employeeId) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Employee not found.");
            return;
        }

        // Shift elements to the left
        for (int i = index; i < size - 1; i++) {
            employees[i] = employees[i + 1];
        }
        employees[size - 1] = null; // Clear the last element
        size--;
        System.out.println("Employee deleted successfully.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the maximum number of employees: ");
        int capacity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        EmployeeManagementSystem ems = new EmployeeManagementSystem(capacity);

        while (true) {
            System.out.println("\n1. Add Employee");
            System.out.println("2. Search Employee by ID");
            System.out.println("3. Traverse Employees");
            System.out.println("4. Delete Employee by ID");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter position: ");
                    String position = scanner.nextLine();
                    System.out.print("Enter salary: ");
                    double salary = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline

                    Employee employee = new Employee(id, name, position, salary);
                    ems.addEmployee(employee);
                    break;

                case 2:
                    System.out.print("Enter employee ID to search: ");
                    int searchId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Employee foundEmployee = ems.searchEmployeeById(searchId);
                    if (foundEmployee != null) {
                        System.out.println("Employee found: " + foundEmployee);
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 3:
                    System.out.println("Listing all employees:");
                    ems.traverseEmployees();
                    break;

                case 4:
                    System.out.print("Enter employee ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    ems.deleteEmployeeById(deleteId);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}