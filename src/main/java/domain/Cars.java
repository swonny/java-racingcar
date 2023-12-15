package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final int START_POSITION = 0;
    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public void moveAll(final MoveStrategy moveStrategy) {
        cars.forEach(car -> car.move(moveStrategy.generate()));
    }

    public List<Car> calculateWinners() {
        final int maxPosition = cars.stream()
                                    .mapToInt(Car::getPosition)
                                    .max()
                                    .orElse(START_POSITION);
        return cars.stream()
                   .filter(car -> car.getPosition() == maxPosition)
                   .collect(Collectors.toUnmodifiableList());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    @Override
    public String toString() {
        return "Cars{" +
                "cars=" + cars +
                '}';
    }
}
