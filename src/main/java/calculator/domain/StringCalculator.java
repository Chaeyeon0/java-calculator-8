package calculator.domain;

public class StringCalculator {

    private final ExpressionParser parser = new ExpressionParser();

    public int add(String inputLine) {

        String[] numbers = parser.parse(inputLine);
        PositiveNumbers positiveNumbers = new PositiveNumbers(numbers);
        return positiveNumbers.sum();
    }
}