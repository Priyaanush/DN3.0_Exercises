public class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadImageFromServer();
    }

    private void loadImageFromServer() {
        System.out.println("Loading image " + filename + " from remote server...");
        // Simulate the time taken to load an image
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Image " + filename + " loaded.");
    }

    @Override
    public void display() {
        System.out.println("Displaying image " + filename);
    }
}