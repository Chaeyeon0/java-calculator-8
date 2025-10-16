package calculator.domain;

public class StringCalculator {

    public int add(String inputLine) {
        int sum = 0;

        if(inputLine != null) {
            String[] numbers = inputLine.split("[,:]");
            for(String numberstr : numbers) {
                sum += Integer.parseInt(numberstr.trim());
            }
        }
        return sum;
    }
}