import controller.GameController;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        final GameController gameController = new GameController(new InputView(), new OutputView());

        gameController.run();
    }
}
