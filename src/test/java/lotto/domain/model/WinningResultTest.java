package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Rank;
import org.junit.jupiter.api.Test;

class WinningResultTest {
    
    @Test
    void 수익과_3개_일치_갯수로_수익률을_계산한다_() {
        WinningResult winningResult = new WinningResult();
        winningResult.recordRank(Rank.FIFTH);
        assertThat(winningResult.calculateTotalReturn(14_000)).isEqualTo("0.35");
    }
    
    @Test
    void 수익과_4개_일치_갯수로_수익률을_계산한다() {
        WinningResult winningResult = new WinningResult();
        winningResult.recordRank(Rank.FOURTH);
        assertThat(winningResult.calculateTotalReturn(14_000)).isEqualTo("3.57");
    }
    
    @Test
    void 수익과_3개_4개_일치_갯수로_수익률을_계산한다() {
        WinningResult winningResult = new WinningResult();
        winningResult.recordRank(Rank.FIFTH);
        winningResult.recordRank(Rank.FOURTH);
        assertThat(winningResult.calculateTotalReturn(14_000)).isEqualTo("3.92");
    }
    
    @Test
    void 수익과_3개_6개_일치_갯수로_수익률을_계산한다() {
        WinningResult winningResult = new WinningResult();
        winningResult.recordRank(Rank.FIFTH);
        winningResult.recordRank(Rank.FIRST);
        assertThat(winningResult.calculateTotalReturn(200_000)).isEqualTo("10000.02");
    }
    
    @Test
    void 일치하는_정보가_있으면_해당하는_일치갯수1을_증가시킨다() {
        WinningResult winningResult = new WinningResult();
        winningResult.recordRank(Rank.valueOf(5, false));
        
        WinningResult expectedResult = new WinningResult();
        expectedResult.recordRank(Rank.THIRD);
        assertThat(winningResult).isEqualTo(expectedResult);
    }
    
}