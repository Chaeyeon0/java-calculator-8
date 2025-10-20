package calculator.controller;

import calculator.domain.StringCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

public class CalculatorController {

    private final StringCalculator calculator = new StringCalculator();

    public void run() {
        try {
            String input = InputView.readInput();
            int result = calculator.add(input);
            OutputView.printResult(result);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            throw e;
        } finally {
            Console.close();
        }
    }
}