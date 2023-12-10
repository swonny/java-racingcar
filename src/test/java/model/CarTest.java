package model;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

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

        @ParameterizedTest
        @ValueSource(ints = {-1, 10})
        void 유효하지_않은_값이_입력될_경우_예외를_던진다(final int random) {
            // given
            final Car 자동차 = new Car("자동차");

            // when & then
            assertThatThrownBy(() -> 자동차.move(random))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class 자동차의_이름은 {

        @Test
        void 다섯_글자_이하의_경우_정상_입력_된다() {
            assertDoesNotThrow(() -> new Car("정상입력값"));
        }

        @ParameterizedTest
        @ValueSource(strings = {"", " ", "여섯글자이름"})
        void 유효하지_않은_입력값의_경우_예외를_던진다(final String name) {
            assertThatThrownBy(() -> new Car(name))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
