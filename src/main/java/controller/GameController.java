package controller;

import model.Car;
import model.CarFactory;
import model.Cars;
import view.InputView;
import view.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
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

        final Cars cars = startGame(carNames, numberOfRound);
        final List<String> winnerCars = cars.calculateWinners()
                                            .stream()
                                            .map(Car::getName)
                                            .collect(Collectors.toUnmodifiableList());
        outputView.printWinners(winnerCars);
    }

    private Cars startGame(final List<String> carNames, final int numberOfRound) {
        final List<Car> cars = CarFactory.from(carNames);
        for (int round = 0; round < numberOfRound; round++) {
            final Map<String, Integer> results = playGame(cars);
            outputView.printResult(results);
        }

        return new Cars(cars);
    }

    private Map<String, Integer> playGame(final List<Car> cars) {
        final Random random = new Random();
        final Map<String, Integer> result = new HashMap<>();
        cars.forEach(car -> {
            final int randomValue = random.nextInt(10);
            car.move(randomValue);
            result.put(car.getName(), car.getPosition());
        });

        return result;
    }
}
