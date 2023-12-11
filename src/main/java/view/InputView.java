package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    private static final String CAR_NAME_DELIMITER = ",";
    private final BufferedReader reader;

    public InputView() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public int readNumberOfRound() {
        // TODO: 2023/12/11 로그 바꾸기
        System.out.println("시도할 회수는 몇회인가요?");
        final CallBack<Integer> execution = () -> {
            final String readNumber = reader.readLine();
            return Integer.parseInt(readNumber);
        };

        return read(execution);
    }

    public List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        final CallBack<List<String>> execution = () -> {
            final String carNames = reader.readLine();
            return Arrays.stream(carNames.split(CAR_NAME_DELIMITER))
                         .collect(Collectors.toUnmodifiableList());
        };

        return read(execution);
    }

    public <T> T read(final CallBack<T> callback) {
        try {
            return callback.execute();
        } catch (final IOException exception) {
            // TODO: 2023/12/11 개선 필요
            throw new IllegalArgumentException();
        }
    }
}
