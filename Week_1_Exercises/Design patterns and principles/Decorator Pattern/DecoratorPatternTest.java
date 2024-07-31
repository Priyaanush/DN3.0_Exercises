public class DecoratorPatternTest {
    public static void main(String[] args) {
        // Create a basic notifier
        Notifier notifier = new EmailNotifier();

        // Decorate the notifier with SMS functionality
        Notifier smsNotifier = new SMSNotifierDecorator(notifier);

        // Decorate the notifier with Slack functionality
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);

        // Send a notification
        slackNotifier.send("Hello, this is a test message!");
    }
}