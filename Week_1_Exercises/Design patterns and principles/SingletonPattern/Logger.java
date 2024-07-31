public class Logger {
    // Step 2: Define a private static instance of Logger
    private static Logger instance;
    
    // Step 2: Make the constructor private to prevent instantiation from outside
    private Logger() {
        // Private constructor to prevent instantiation
    }
    
    // Step 2: Provide a public static method to get the instance of Logger
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }
    
    // Method to log messages
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}