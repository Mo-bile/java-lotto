package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Rank;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {
    
    @Test
    void 당첨번호를_입력받으면_당첨번호와_몇개_당첨인지_알린다() {
        LottoTickets lottoTickets = new LottoTickets(new Lotto(1, 2, 3, 4, 5, 6), new Lotto(40, 41, 42, 43, 44, 45));
        
        WinningResult winningResult = lottoTickets.identifyWinners(new WinningLotto(1, 35, 36, 37, 43, 44, 45));
        WinningResult expectedWinner = new WinningResult();
        expectedWinner.recordRank(Rank.MISS);
        expectedWinner.recordRank(Rank.FIFTH);
        assertThat(winningResult).isEqualTo(expectedWinner);
    }
    
    @Test
    void 당첨2등과_3등이면_무엇인지_알려준다() {
        LottoTickets lottoTickets = new LottoTickets(new Lotto(10, 41, 42, 43, 44, 45), new Lotto(20, 41, 42, 43, 44, 45));
        
        WinningResult winningResult = lottoTickets.identifyWinners(new WinningLotto(LottoNumber.of(20), new Lotto(35, 41, 42, 43, 44, 45)));
        WinningResult expectedWinner = new WinningResult();
        expectedWinner.recordRank(Rank.SECOND);
        expectedWinner.recordRank(Rank.THIRD);
        assertThat(winningResult).isEqualTo(expectedWinner);
    }
}
