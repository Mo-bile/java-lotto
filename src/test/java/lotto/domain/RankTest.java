package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.model.LottoNumber;
import lotto.domain.model.Lotto;
import org.junit.jupiter.api.Test;

class RankTest {
    
    @Test
    void 매치된_숫자5를_제시하면_다섯개_일치를_반환한다() {
        assertThat(Rank.fromLottoNumber(5, false)).isEqualTo(Rank.THIRD);
    }
    
    @Test
    void 매치가_3미만이면_MISS를_반환한다() {
        assertThat(Rank.fromLottoNumber(1, false)).isEqualTo(Rank.MISS);
    }
    
}