package calculator.domain;

public class StringCalculator {

    private final DelimitedNumberParser parser = new DelimitedNumberParser();

    public int add(String inputLine) {

        if (inputLine == null || inputLine.isEmpty()) {
            return 0;
        }

        String[] numbers = parser.parse(inputLine);
        PositiveNumbers positiveNumbers = new PositiveNumbers(numbers);
        return positiveNumbers.sum();
    }
}