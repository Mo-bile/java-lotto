package calculator.prepare;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class AccumulatorControllerTest {
    
    @Test
    void baseTest() {
        AccumulatorController accumulator =
            new AccumulatorController(null, 0, 0, true);
        assertThat(accumulator.accumulateNum("5")).isEqualTo(5);
    }
    
}