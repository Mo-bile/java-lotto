package calculator.Accumulator;

import static calculator.Accumulator.Accumulator.accumulateNumber;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class AccumulatorTest {
    
    @Test
    void addTest() {
        assertThat(accumulateNumber("+", 5, 5)).isEqualTo(10);
    }
    
    @Test
    void subTest() {
        assertThat(accumulateNumber("-", 5, 0)).isEqualTo(5);
    }
    
    @Test
    void OperatorSetTest() {
        assertThat(accumulateNumber("*", 5, 3)).isEqualTo(15);
    }
    
}