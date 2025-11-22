package calculator.prepare;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ExpressionAccumulatorTest {
    
    @Test
    void baseTest() {
        ExpressionAccumulator accumulator =
            new ExpressionAccumulator(null, 0, 0, true);
        assertThat(accumulator.accumulateNum("5")).isEqualTo(5);
    }
    
    @Test
    void addTest() {
        ExpressionAccumulator accumulator =
            new ExpressionAccumulator("+", 5, 0, false);
        assertThat(accumulator.accumulateNum("5")).isEqualTo(10);
    }
    
    @Test
    void subTest() {
        ExpressionAccumulator accumulator =
            new ExpressionAccumulator("-", 10, 0, false);
        assertThat(accumulator.accumulateNum("5")).isEqualTo(5);
    }
    
    @Test
    void OperatorSetTest() {
        ExpressionAccumulator accumulator = new ExpressionAccumulator();
        accumulator.accumulateNum("5");
        accumulator.extractOperator("+");
        assertThat(accumulator.accumulateNum("10")).isEqualTo(15);
    }
    
}