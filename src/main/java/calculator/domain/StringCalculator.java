package calculator.domain;

public class StringCalculator {

    public int add(String inputLine) {
        int sum = 0;

        if (inputLine == null || inputLine.isEmpty()) {

            return 0;
        }

        String[] numbers = inputLine.split("[,:]");
        PositiveNumbers positiveNumbers = new PositiveNumbers(numbers);
        return positiveNumbers.sum();
    }
}