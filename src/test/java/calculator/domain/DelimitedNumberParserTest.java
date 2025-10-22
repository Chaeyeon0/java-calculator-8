package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class DelimitedNumberParserTest {

    private final DelimitedNumberParser parser = new DelimitedNumberParser();

    @Test
    @DisplayName("커스텀 구분자가 포함된 문자열을 올바르게 분리한다")
    void parse_with_custom_delimiter() {
        String input = "//;\n1;2;3";
        String[] result = parser.parse(input);
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("기본 구분자(쉼표, 콜론)가 포함된 문자열을 올바르게 분리한다")
    void parse_with_default_delimiters() {
        String input = "1,2:3";
        String[] result = parser.parse(input);
        assertThat(result).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("입력값이 null이거나 비어있으면 빈 배열을 반환한다")
    void parse_with_null_or_empty_input() {
        assertThat(parser.parse(null)).isEmpty();
        assertThat(parser.parse("")).isEmpty();
    }

    @Test
    @DisplayName("커스텀 구분자가 숫자일 경우 예외가 발생한다")
    void throw_when_custom_delimiter_is_number() {
        String input = "//1\n1,2,3";
        assertThatThrownBy(() -> parser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자를 사용할 수 없습니다");
    }

    @Test
    @DisplayName("두 글자 이상의 커스텀 구분자도 올바르게 동작한다")
    void parse_with_multi_char_custom_delimiter() {
        String input = "//;;\n1;;2;;3";
        String[] result = parser.parse(input);
        assertThat(result).containsExactly("1", "2", "3");
    }
}
