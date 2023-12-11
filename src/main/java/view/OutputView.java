package view;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String RESULT_TITLE = "실행 결과";
    private static final String CAR_NAME_POSITION_DELIMITER = " : ";

    public void printResult(final Map<String, Integer> results) {
        System.out.println(RESULT_TITLE);
        results.keySet()
               .forEach(carName -> {
                   final Integer position = results.get(carName);
                   final String positionBar = "-".repeat(position);
                   System.out.println(carName + CAR_NAME_POSITION_DELIMITER + positionBar);
               });
    }

    public void printWinners(final List<String> winnerCars) {
        final String joinedWinnerCars = String.join(", ", winnerCars);
        System.out.println(joinedWinnerCars + "가 최종 우승했습니다.");
    }
}
