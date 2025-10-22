package calculator.domain;

public class CustomDelimiterValidator {

    public void validate(String delimiter) {
        if (delimiter == null || delimiter.isEmpty()) {
            throw new IllegalArgumentException("커스텀 구분자가 비어 있습니다.");
        }
        if (Character.isDigit(delimiter.charAt(0))) {
            throw new IllegalArgumentException("커스텀 구분자는 숫자를 사용할 수 없습니다: " + delimiter);
        }
    }
}
