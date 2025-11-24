package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinnerTest {
    
    @Test
    void 수익과_3개_일치_갯수로_수익률을_계산한다_() {
        Winner winner = new Winner(1, 0, 0, 0);
        assertThat(winner.calculateTotalReturn(14000)).isEqualTo("0.35");
    }
    
    @Test
    void 수익과_4개_일치_갯수로_수익률을_계산한다() {
        Winner winner = new Winner(0, 1, 0, 0);
        assertThat(winner.calculateTotalReturn(14000)).isEqualTo("3.57");
    }
    
    @Test
    void 수익과_3개_4개_일치_갯수로_수익률을_계산한다() {
        Winner winner = new Winner(1, 1, 0, 0);
        assertThat(winner.calculateTotalReturn(14000)).isEqualTo("3.92");
    }
    
    @Test
    void 수익과_3개_6개_일치_갯수로_수익률을_계산한다() {
        Winner winner = new Winner(1, 0, 0, 1);
        assertThat(winner.calculateTotalReturn(200000)).isEqualTo("10000.02");
    }
    
}