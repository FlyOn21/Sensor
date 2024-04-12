import controllers.SensorsController;

public class App {
    private final SensorsController startApp = new SensorsController();

    public void run() {
        startApp.sensorControllerProcessing();
    }

    public static void main(String[] args) {
        new App().run();
    }
}
