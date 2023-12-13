package controller;

import domain.Car;
import domain.RaceGame;
import domain.RandomMoveStrategy;
import domain.ResultOfRoundDto;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;

    public GameController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        final List<String> carNames = inputView.readCarNames();
        final int numberOfRound = inputView.readNumberOfRound();

        final RaceGame raceGame = RaceGame.of(new RandomMoveStrategy(), carNames, numberOfRound);
        startGame(raceGame);
    }

    private void startGame(final RaceGame raceGame) {
        while (raceGame.isOnGoing()) {
            final List<Car> result = raceGame.play();
            final ResultOfRoundDto resultOfRoundDto = ResultOfRoundDto.from(result);
            outputView.printResult(resultOfRoundDto);
        }

        calculateWinners(raceGame);
    }

    private void calculateWinners(final RaceGame raceGame) {
        final List<String> winnerCarNames = raceGame.calculateWinners()
                                                    .stream()
                                                    .map(Car::getName)
                                                    .collect(Collectors.toUnmodifiableList());
        outputView.printWinners(winnerCarNames);
    }
}
