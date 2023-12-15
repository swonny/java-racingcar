package domain;

import java.util.List;

public class RaceGame {

    private static final int ZERO = 0;
    private final MoveStrategy moveStrategy;
    private final Cars cars;
    private RacingCount racingCount;

    private RaceGame(final MoveStrategy moveStrategy, final Cars cars, final RacingCount racingCount) {
        this.moveStrategy = moveStrategy;
        this.cars = cars;
        this.racingCount = racingCount;
    }

    public static RaceGame of(final MoveStrategy moveStrategy, final List<String> carNames, final int racingCount) {
        return new RaceGame(
                moveStrategy,
                new Cars(CarFactory.from(carNames)),
                new RacingCount(racingCount)
        );
    }

    public List<Car> play() {
        cars.moveAll(moveStrategy);
        racingCount = racingCount.decrease();
        return cars.getCars();
    }

    public boolean isOnGoing() {
        return racingCount.biggerThan(ZERO);
    }

    public List<Car> calculateWinners() {
        return cars.calculateWinners();
    }

    @Override
    public String toString() {
        return "RaceGame{" +
                "moveStrategy=" + moveStrategy +
                ", cars=" + cars +
                ", racingCount=" + racingCount +
                '}';
    }
}
