package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {

    private final StringCalculator calculator = new StringCalculator();

    @Test
    @DisplayName("기본 구분자(쉼표, 콜론)로 구분된 문자열의 합을 계산한다")
    void add_with_default_delimiters() {
        int result = calculator.add("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자(//;)가 포함된 문자열의 합을 계산한다")
    void add_with_custom_delimiter() {
        int result = calculator.add("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("빈 문자열을 입력하면 0을 반환한다")
    void add_with_empty_input_returns_zero() {
        int result = calculator.add("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("음수가 포함된 경우 예외를 발생시킨다")
    void throws_exception_when_negative_number() {
        assertThatThrownBy(() -> calculator.add("1,-2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("음수는 계산할 수 없습니다");
    }

    @Test
    @DisplayName("숫자가 아닌 값이 포함된 경우 예외를 발생시킨다")
    void throws_exception_when_non_numeric_value() {
        assertThatThrownBy(() -> calculator.add("1,a,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 아닌 값이 포함되어 있습니다");
    }
}
