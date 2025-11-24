package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinnerTest {
    
    @Test
    void 수익과_일치_갯수로_수익률을_계산한다() {
        Winner winner = new Winner(1, 0, 0, 0);
        assertThat(winner.calculateTotalReturn(14000)).isEqualTo("0.35");
    }
    
}