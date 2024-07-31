import java.util.Scanner;

public class BuilderPatternTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a Builder object
        Computer.Builder builder = new Computer.Builder();

        // Get user input for each attribute
        System.out.print("Enter CPU: ");
        String CPU = scanner.nextLine();
        builder.setCPU(CPU);

        System.out.print("Enter RAM: ");
        String RAM = scanner.nextLine();
        builder.setRAM(RAM);

        System.out.print("Enter Storage: ");
        String storage = scanner.nextLine();
        builder.setStorage(storage);

        System.out.print("Enter GPU (optional): ");
        String GPU = scanner.nextLine();
        if (!GPU.isEmpty()) {
            builder.setGPU(GPU);
        }

        System.out.print("Enter Power Supply (optional): ");
        String powerSupply = scanner.nextLine();
        if (!powerSupply.isEmpty()) {
            builder.setPowerSupply(powerSupply);
        }

        System.out.print("Enter Motherboard (optional): ");
        String motherboard = scanner.nextLine();
        if (!motherboard.isEmpty()) {
            builder.setMotherboard(motherboard);
        }

        // Build the Computer object
        Computer computer = builder.build();

        // Display the configuration
        System.out.println("Computer configuration:");
        System.out.println(computer);

        // Close the scanner
        scanner.close();
    }
}