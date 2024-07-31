import java.util.Scanner;

public class MVCPatternTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a student model
        Student student = new Student("Priya", "12345", "A");

        // Create a student view
        StudentView view = new StudentView();

        // Create a student controller
        StudentController controller = new StudentController(student, view);

        // Display the initial student details
        System.out.println("Initial student details:");
        controller.updateView();

        // Get user input to update the student details
        System.out.print("\nEnter new student name: ");
        String newName = scanner.nextLine();
        controller.setStudentName(newName);

        System.out.print("Enter new student ID: ");
        String newId = scanner.nextLine();
        controller.setStudentId(newId);

        System.out.print("Enter new student grade: ");
        String newGrade = scanner.nextLine();
        controller.setStudentGrade(newGrade);

        // Display the updated student details
        System.out.println("\nUpdated student details:");
        controller.updateView();

        scanner.close();
    }
}