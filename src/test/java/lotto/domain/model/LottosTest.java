package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottosTest {
    
    @Test
    void 갯수를_입력받으면_로또를_생성한다() {
        Lottos lottos = new Lottos(10);
        assertThat(lottos.lottoList()).hasSize(10);
    }
    
    @Test
    void 당첨번호를_입력받으면_당첨번호와_몇개_당첨인지_알린다() {
        Lottos lottos = new Lottos(List.of(
            new Lotto(1, 2, 3, 4, 5, 6), new Lotto(40, 41, 42, 43, 44, 45)));
        
        WinningResult winningResult = lottos.identifyWinners(new Lotto(List.of(35, 36, 37, 43, 44, 45)));
        WinningResult expectedWinner = new WinningResult(1, 1, 0, 0, 0, 0);
        assertThat(winningResult).isEqualTo(expectedWinner);
    }
}