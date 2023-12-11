import controller.GameController;
import view.InputView;

public class Application {

    public static void main(String[] args) {
        final GameController gameController = new GameController(new InputView());

        gameController.run();
    }
}
