package domain;

import java.util.Objects;

public class RacingCount {

    private final int racingCount;

    public RacingCount(final int racingCount) {
        this.racingCount = racingCount;
    }

    public RacingCount decrease() {
        return new RacingCount(racingCount - 1);
    }

    public boolean biggerThan(final int comparingCount) {
        return racingCount > comparingCount;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final RacingCount that = (RacingCount) o;
        return racingCount == that.racingCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(racingCount);
    }

    @Override
    public String toString() {
        return "RacingCount{" +
                "racingCount=" + racingCount +
                '}';
    }
}
