package domain;

import java.util.Objects;

public class Position {

    private final int START_POSITION = 0;
    private final int value;

    public Position() {
        this.value = START_POSITION;
    }

    public Position(final int value) {
        this.value = value;
    }

    public Position addOne() {
        return new Position(this.value + 1);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Position{" +
                "START_POSITION=" + START_POSITION +
                ", value=" + value +
                '}';
    }
}
