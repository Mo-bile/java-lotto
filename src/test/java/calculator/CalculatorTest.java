package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void calculateAddTest() {
        Calculator calculator = new Calculator(new StringInput("2 + 3"));
        assertThat(calculator.calculate())
            .isEqualTo(5);
    }
    
    @Test
    void calculateSubTest() {
        Calculator calculator = new Calculator(new StringInput("2 - 3"));
        assertThat(calculator.calculate())
            .isEqualTo(-1);
    }
    
    @Test
    void calculateMulTest() {
        Calculator calculator = new Calculator(new StringInput("2 * 3"));
        assertThat(calculator.calculate())
            .isEqualTo(6);
    }
    
    @Test
    void calculateDivTest() {
        Calculator calculator = new Calculator(new StringInput("3 / 3"));
        assertThat(calculator.calculate())
            .isEqualTo(1);
    }
    
    @Test
    void calculateTest() {
        Calculator calculator = new Calculator(new StringInput("2 + 3 * 4 / 2"));
        assertThat(calculator.calculate())
            .isEqualTo(10);
    }
    
}