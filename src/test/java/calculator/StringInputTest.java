package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringInputTest {
    
    @Test
    void nullOrEmptyTest() {
        assertThatThrownBy(
            () -> new StringInput(null)
        ).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("입력 값이 null이거나 빈 공백 문자");
    }
    
    @Test
    void operationsNonSymbolTest() {
        assertThatThrownBy(
            () -> new StringInput("2 & 3")
        ).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("사칙연산 기호가 아닙니다.");
    }
    
    @Test
    void operationsSymbolTest() {
        assertThatThrownBy(
            () -> new StringInput("+ * /")
        ).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("숫자가 없습니다");
    }
    
}