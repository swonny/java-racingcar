package model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarFactoryTest {

    @Test
    void 쉼표를_기준으로_자동차를_생성한다() {
        // given
        final String carNames = "첫번째,두번째,세번째";

        // when
        final List<Car> cars = CarFactory.from(carNames);

        // then
        assertThat(cars).hasSize(3);
    }
}
