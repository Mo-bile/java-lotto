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
    void 등수_2등과_3등중_보너스번호에_해당하면_2등으로바꾼다() {
        assertThat(Rank.SECOND.decideSecond(new Lotto(10, 40, 41, 42, 43, 44), new Bonus(10))).isTrue();
        assertThat(Rank.THIRD.decideSecond(new Lotto(10, 40, 41, 42, 43, 44), new Bonus(10))).isTrue();
    }
    
}