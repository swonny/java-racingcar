package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Nested
    class 자동차의_전진기능은 {

        @ParameterizedTest
        @ValueSource(ints = {0, 3, 5, 9})
        void random_값이_0에서_9_사이인_경우_전진한다(final int random) {
            final Car car = new Car("자동차");

            car.move(random);

            assertThat(car.getPosition()).isEqualTo(new Position(1));

            System.out.println( + car.getPosition().getValue());
        }
    }
}
