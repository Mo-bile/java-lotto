package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringInputTest {
    
    @Test
    void nullOrEmptyTest() {
        assertThatThrownBy(
            () -> new StringInput(null)
        ).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("입력 값이 null이거나 빈 공백 문자");
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void nullOrEmptyTest(String input) {
        assertThatThrownBy(
            () -> new StringInput(input)
        ).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("입력 값이 null이거나 빈 공백 문자");
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"2 & 3 +", "2 & 3"})
    void operationsNonSymbolTest(String input) {
        assertThatThrownBy(
            () -> new StringInput(input)
        ).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("숫자, 공백, 사칙연산만 포함해야 합니다.");
    }
    
    @Test
    void extractArithmeticQueueTest() {
        StringInput stringInput = new StringInput("2 + 3 * 4 / 2");
        assertThat(stringInput.extractArithmeticQueue())
            .hasSize(7);
        assertThat(stringInput.extractArithmeticQueue().getFirst())
            .isEqualTo("2");
    }
    
}