package calculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionParser {

    // 기본 구분자: 쉼표, 콜론
    private static final String DEFAULT_DELIMITER = "[,:]";

    // 커스텀 구분자 패턴
    private static final Pattern CUSTOM_DELIMITER =
            Pattern.compile("//(.+)\n(.*)");

    public String[] parse(String input) {
        if (input == null || input.isEmpty()) {
            return new String[0];
        }

        Matcher matcher = CUSTOM_DELIMITER.matcher(input);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1); // //와 \n 사이 문자
            String numbers = matcher.group(2);         // 숫자 문자열
            return numbers.split(Pattern.quote(customDelimiter));
        }

        // 기본 구분자 처리
        return input.split(DEFAULT_DELIMITER);
    }
}