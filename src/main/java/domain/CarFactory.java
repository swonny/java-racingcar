package domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    private CarFactory() {
    }

    public static List<Car> from(final List<String> carNames) {
        return carNames.stream()
                       .map(Car::new)
                       .collect(Collectors.toUnmodifiableList());
    }
}
