package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

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

    public <T> T read(final CallBack<T> callback) {
        try {
            return callback.execute();
        } catch (final IOException exception) {
            // TODO: 2023/12/11 개선 필요
            throw new IllegalArgumentException();
        }
    }
}
