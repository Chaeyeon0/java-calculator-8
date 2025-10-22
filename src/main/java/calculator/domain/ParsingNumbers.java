package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class ParsingNumbers {

    private final List<Integer> numbers;

    public ParsingNumbers(String[] stringNumbers) {
        List<Integer> parsedNumbers = parseAndValidate(stringNumbers);
        this.numbers = new ArrayList<>(parsedNumbers);
    }

    private List<Integer> parseAndValidate(String[] stringNumbers) {
        List<Integer> tempNumbers = new ArrayList<>();

        for (String numberStr : stringNumbers) {
            int number = parseToInt(numberStr);
            validateIsPositive(number);
            tempNumbers.add(number);
        }
        return tempNumbers;
    }

    private int parseToInt(String numberStr) {
        if (numberStr == null || numberStr.isEmpty()) {
            return 0;
        }

        try {
            return Integer.parseInt(numberStr.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: \"" + numberStr + "\"");
        }
    }

    private void validateIsPositive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 계산할 수 없습니다: " + number);
        }
    }

    public int sum() {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}