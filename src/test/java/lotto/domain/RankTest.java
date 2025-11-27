package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.model.Bonus;
import lotto.domain.model.Lotto;
import org.junit.jupiter.api.Test;

class RankTest {
    
    @Test
    void 매치된_숫자5를_제시하면_다섯개_일치를_반환한다() {
        assertThat(Rank.fromLottoNumber(5)).isEqualTo(Rank.THIRD);
    }
    
    @Test
    void 등수_2등과_3등이_아니면_거짓이다() {
        assertThat(Rank.FIFTH.isSecondOrThird()).isFalse();
    }
    
}