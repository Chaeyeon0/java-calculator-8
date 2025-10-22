package calculator.domain;

public class StringCalculator {

    private final DelimitedNumberParser parser = new DelimitedNumberParser();

    public int add(String inputLine) {

        if (inputLine == null || inputLine.isEmpty()) {
            return 0;
        }

        String[] numbers = parser.parse(inputLine);
        ParsingNumbers parsingNumbers = new ParsingNumbers(numbers);
        return parsingNumbers.sum();
    }
}