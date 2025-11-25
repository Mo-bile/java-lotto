package lotto.domain.business;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class LottoGameTest {
    
    @Test
    void 받은_금액을_로또n개로변환하여_생성한다() {
        LottoGame lottoGame = new LottoGame(10000);
        System.out.println("process = " + lottoGame.getLottos());
        assertThat(lottoGame.getLottos()).hasSize(10);
    }
    
}