package model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    private static final String CAR_NAME_DELIMITER = ",";

    private CarFactory() {
    }

    public static List<Car> from(final String cars) {
        return Arrays.stream(cars.split(CAR_NAME_DELIMITER))
                     .map(Car::new)
                     .collect(Collectors.toUnmodifiableList());
    }
}
