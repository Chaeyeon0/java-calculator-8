package calculator;

import calculator.domain.StringCalculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        //기본 입출력
        try{
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String inputLine = readLine();

            StringCalculator calculator = new StringCalculator();
            int result = calculator.add(inputLine);

            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}