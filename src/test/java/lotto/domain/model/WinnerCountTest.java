package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class WinnerCountTest {
    
    @Test
    void 수익과_3개_일치_갯수로_수익률을_계산한다_() {
        WinnerCount winnerCount = new WinnerCount(1, 0, 0, 0);
        assertThat(winnerCount.calculateTotalReturn(14000)).isEqualTo("0.35");
    }
    
    @Test
    void 수익과_4개_일치_갯수로_수익률을_계산한다() {
        WinnerCount winnerCount = new WinnerCount(0, 1, 0, 0);
        assertThat(winnerCount.calculateTotalReturn(14000)).isEqualTo("3.57");
    }
    
    @Test
    void 수익과_3개_4개_일치_갯수로_수익률을_계산한다() {
        WinnerCount winnerCount = new WinnerCount(1, 1, 0, 0);
        assertThat(winnerCount.calculateTotalReturn(14000)).isEqualTo("3.92");
    }
    
    @Test
    void 수익과_3개_6개_일치_갯수로_수익률을_계산한다() {
        WinnerCount winnerCount = new WinnerCount(1, 0, 0, 1);
        assertThat(winnerCount.calculateTotalReturn(200000)).isEqualTo("10000.02");
    }
    
}