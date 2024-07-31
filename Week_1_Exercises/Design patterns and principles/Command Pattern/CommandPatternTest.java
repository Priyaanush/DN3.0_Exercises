import java.util.Scanner;

public class CommandPatternTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create the receiver object
        Light livingRoomLight = new Light();

        // Create command objects
        Command lightOnCommand = new LightOnCommand(livingRoomLight);
        Command lightOffCommand = new LightOffCommand(livingRoomLight);

        // Create the invoker object
        RemoteControl remoteControl = new RemoteControl();

        while (true) {
            System.out.println("\n1. Turn ON the light");
            System.out.println("2. Turn OFF the light");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    remoteControl.setCommand(lightOnCommand);
                    remoteControl.pressButton();
                    break;
                case 2:
                    remoteControl.setCommand(lightOffCommand);
                    remoteControl.pressButton();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }
    }
}