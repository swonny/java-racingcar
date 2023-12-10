package model;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Nested
    class 자동차의_전진기능은 {

        @ParameterizedTest
        @ValueSource(ints = {4, 5, 8, 9})
        void random_값이_4에서_9_사이인_경우_전진한다(final int random) {
            // given
            final Car car = new Car("자동차");

            // when
            car.move(random);

            // then
            assertThat(car.getPosition()).isEqualTo(new Position(1));
        }

        @ParameterizedTest
        @ValueSource(ints = {0, 2, 3})
        void random_값이_0_이상_3_이하인_경우_멈춘다(final int random) {
            // given
            final Car 자동차 = new Car("자동차");

            // when
            자동차.move(random);

            // then
            assertThat(자동차.getPosition()).isEqualTo(new Position(0));
        }
    }
}
