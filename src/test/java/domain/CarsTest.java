package domain;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

class CarsTest {

    @Nested
    class 우승자가 {

        @Test
        void 한_명인_경우를_판별한다() {
            // given
            final Car 일등_자동차 = new Car("1등자동차");
            final Car 공동_일등_자동차 = new Car("자동차");
            final Car 이등_자동차 = new Car("자동차");

            일등_자동차.move(4);

            final Cars cars = new Cars(List.of(일등_자동차, 공동_일등_자동차, 이등_자동차));

            // when
            final List<Car> result = cars.calculateWinners();

            // then
            assertSoftly(softAssertions -> {
                softAssertions.assertThat(result).hasSize(1);
                softAssertions.assertThat(result.get(0)).isEqualTo(일등_자동차);
            });
        }

        @Test
        void 우승자를_판별한다() {
            // given
            final Car 일등_자동차 = new Car("1등자동차");
            final Car 공동_일등_자동차 = new Car("1등자동차");
            final Car 이등_자동차 = new Car("2등자동차");

            일등_자동차.move(4);
            공동_일등_자동차.move(4);

            final Cars cars = new Cars(List.of(일등_자동차, 공동_일등_자동차, 이등_자동차));

            // when
            final List<Car> result = cars.calculateWinners();

            // then
            assertSoftly(softAssertions -> {
                softAssertions.assertThat(result).hasSize(2);
                softAssertions.assertThat(result.get(0)).isEqualTo(일등_자동차);
                softAssertions.assertThat(result.get(1)).isEqualTo(공동_일등_자동차);
            });
        }
    }
}
