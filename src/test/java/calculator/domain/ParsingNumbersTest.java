package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParsingNumbersTest {

    @Test
    @DisplayName("양수 문자열 배열의 합을 계산한다")
    void sum_with_positive_numbers() {
        String[] input = {"1", "2", "3"};
        ParsingNumbers numbers = new ParsingNumbers(input);
        int result = numbers.sum();
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수가 포함된 경우 예외를 발생시킨다")
    void throws_exception_when_negative_number() {
        String[] input = {"1", "-2", "3"};

        assertThatThrownBy(() -> new ParsingNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("음수는 계산할 수 없습니다");
    }

    @Test
    @DisplayName("숫자가 아닌 문자가 포함된 경우 예외를 발생시킨다")
    void throws_exception_when_non_numeric_value() {
        String[] input = {"1", "a", "3"};

        assertThatThrownBy(() -> new ParsingNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 아닌 값이 포함되어 있습니다");
    }

    @Test
    @DisplayName("빈 문자열 요소는 0으로 처리된다")
    void empty_string_treated_as_zero() {
        String[] input = {"1", "", "2"};
        ParsingNumbers numbers = new ParsingNumbers(input);

        int result = numbers.sum();

        assertThat(result).isEqualTo(3);
    }
}
