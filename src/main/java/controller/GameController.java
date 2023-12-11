package controller;

import view.InputView;

public class GameController {

    private final InputView inputView;

    public GameController(final InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        final int numberOfRound = inputView.readNumberOfRound();
    }
}
