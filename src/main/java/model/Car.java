package model;

import java.util.Objects;

public class Car {

    private static final int MINIMUM_VALUE_OF_MOVING = 4;
    private static final int MAXIMUM_VALUE_OF_MOVING = 9;
    private static final int MAXIMUM_VALUE_OF_NAME = 5;
    private static final int MINIMUM_VALUE_OF_RANDOM = 0;
    private static final int MAXIMUM_VALUE_OF_RANDOM = 9;

    private final String name;
    private Position position = new Position();

    public Car(final String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(final String name) {
        if (Objects.isNull(name) || name.isBlank() || name.length() > MAXIMUM_VALUE_OF_NAME) {
            throw new IllegalArgumentException(String.format("자동차 이름은 %s 이하로 입력해야 합니다.", MAXIMUM_VALUE_OF_NAME));
        }
    }

    public void move(final int random) {
        validate(random);
        if (random >= MINIMUM_VALUE_OF_MOVING && random <= MAXIMUM_VALUE_OF_MOVING) {
            position = position.addOne();
        }
    }

    private void validate(final int random) {
        if (random < MINIMUM_VALUE_OF_RANDOM || random > MAXIMUM_VALUE_OF_RANDOM) {
            throw new IllegalArgumentException(
                    String.format("랜덤 값은 %d 이상, %d 이하여야 합니다.", MINIMUM_VALUE_OF_RANDOM, MAXIMUM_VALUE_OF_RANDOM)
            );
        }
    }

    public Position getPosition() {
        return position;
    }
}
