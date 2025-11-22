package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {

//    "2 + 3 * 4 / 2"
//    @ParameterizedTest
//    @CsvSource(value = {"2 + 3:'5'", "2 + 3 * 4:20", "2 + 3 * 4 / 2:10"}, delimiter = ':')
    
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