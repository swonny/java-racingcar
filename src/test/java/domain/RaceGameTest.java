package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

class RaceGameTest {

    @ParameterizedTest
    @CsvSource(value = {"1:false", "2:true"}, delimiter = ':')
    void 게임_진행할_때마다_게임_가능_횟수가_줄어든다(final int racingCount, final boolean expected) {
        // given
        final CustomNumberGenerator customNumberGenerator = new CustomNumberGenerator(1, 5, 2, 5);
        final List<String> carNames = List.of("-", "우승자");
        final RaceGame raceGame = RaceGame.of(customNumberGenerator, carNames, racingCount);

        // when
        raceGame.play();

        // then
        assertThat(raceGame.isOnGoing()).isEqualTo(expected);
    }

    @Test
    void 게임_우승자를_계산한다() {
        // given
        final CustomNumberGenerator customNumberGenerator = new CustomNumberGenerator(1, 5, 2, 5);
        final List<String> carNames = List.of("2등", "1등");
        final RaceGame raceGame = RaceGame.of(customNumberGenerator, carNames, 2);

        // when
        while (raceGame.isOnGoing()) {
            raceGame.play();
            System.out.println("raceGame = " + raceGame);
        }
        final List<Car> winners = raceGame.calculateWinners();

        // then
        assertSoftly(softAssertions -> {
            softAssertions.assertThat(winners).hasSize(1);
            softAssertions.assertThat(winners.get(0).getName()).isEqualTo("1등");
        });
    }

    static class CustomNumberGenerator implements MoveStrategy {

        private final Queue<Integer> numbers;

        public CustomNumberGenerator(final Integer... numbers) {
            final List<Integer> numberList = Arrays.stream(numbers)
                                                   .collect(Collectors.toUnmodifiableList());
            this.numbers = new LinkedList<>(numberList);
        }

        @Override
        public int generate() {
            return numbers.poll();
        }
    }
}
