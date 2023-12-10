package model;

public class Car {

    private static final int MINIMUM_VALUE_OF_MOVING = 4;
    private static final int MAXIMUM_VALUE_OF_MOVING = 9;

    private final String name;
    private Position position = new Position();

    public Car(final String name) {
        this.name = name;
    }

    public void move(final int random) {
        if (random >= MINIMUM_VALUE_OF_MOVING && random <= MAXIMUM_VALUE_OF_MOVING) {
            position = position.addOne();
        }
    }

    public Position getPosition() {
        return position;
    }
}
