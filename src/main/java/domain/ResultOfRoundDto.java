package domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultOfRoundDto {

    private final Map<String, Integer> result;

    public ResultOfRoundDto(final Map<String, Integer> result) {
        this.result = result;
    }

    public static ResultOfRoundDto from(final List<Car> result) {
        final Map<String, Integer> resultView = new HashMap<>();
        result.forEach(car -> resultView.put(car.getName(), car.getPosition()));

        return new ResultOfRoundDto(resultView);
    }

    public Map<String, Integer> getResult() {
        return Collections.unmodifiableMap(result);
    }
}
