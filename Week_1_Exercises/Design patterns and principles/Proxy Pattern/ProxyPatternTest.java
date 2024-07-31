import java.util.Scanner;

public class ProxyPatternTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for image filenames
        System.out.print("Enter the filename for the first image: ");
        String filename1 = scanner.nextLine();

        System.out.print("Enter the filename for the second image: ");
        String filename2 = scanner.nextLine();

        // Create instances of ProxyImage with the user-provided filenames
        Image image1 = new ProxyImage(filename1);
        Image image2 = new ProxyImage(filename2);

        // The first call to display will load the image
        System.out.println("First call to display image1:");
        image1.display();

        System.out.println("\nSecond call to display image1:");
        image1.display();

        System.out.println("\nFirst call to display image2:");
        image2.display();

        System.out.println("\nSecond call to display image2:");
        image2.display();

        // Close the scanner
        scanner.close();
    }
}