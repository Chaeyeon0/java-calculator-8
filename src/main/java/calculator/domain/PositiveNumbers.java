package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class PositiveNumbers {

    private final List<Integer> numbers;

    public PositiveNumbers(String[] stringNumbers) {

        List<Integer> paresdNumbers = parseAndValidate(stringNumbers);

        this.numbers = new ArrayList<>(paresdNumbers);
    }

    private List<Integer> parseAndValidate(String[] stringNumbers) {

        List<Integer> tempnumbers = new ArrayList<>();
        for (String numberStr : stringNumbers) {
            int number = parseToInt(numberStr);
            validateIsPositive(number);
            tempnumbers.add(number);
        }
        return tempnumbers;
    }

    private int parseToInt(String numberStr) {
        try {
            return Integer.parseInt(numberStr);

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