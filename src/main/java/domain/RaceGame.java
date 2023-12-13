package domain;

import java.util.List;

public class RaceGame {

    private final MoveStrategy moveStrategy;
    private final Cars cars;
    private int numberOfRace;

    private RaceGame(final MoveStrategy moveStrategy, final Cars cars, final int numberOfRace) {
        this.moveStrategy = moveStrategy;
        this.cars = cars;
        this.numberOfRace = numberOfRace;
    }

    public static RaceGame of(final MoveStrategy moveStrategy, final List<String> carNames, final int numberOfRace) {
        return new RaceGame(
                moveStrategy,
                new Cars(CarFactory.from(carNames)),
                numberOfRace
        );
    }

    public List<Car> play() {
        cars.moveAll(moveStrategy);
        numberOfRace--;
        return cars.getCars();
    }

    public boolean isOnGoing() {
        return numberOfRace > 0;
    }

    public List<Car> calculateWinners() {
        return cars.calculateWinners();
    }
}
