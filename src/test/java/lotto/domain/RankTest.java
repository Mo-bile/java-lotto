package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.model.LottoNumber;
import lotto.domain.model.Lotto;
import org.junit.jupiter.api.Test;

class RankTest {
    
    @Test
    void 매치된_숫자5를_제시하면_다섯개_일치를_반환한다() {
        assertThat(Rank.fromLottoNumber(5)).isEqualTo(Rank.THIRD);
    }
    
    @Test
    void 매치가_3미만이면_MISS를_반환한다() {
        assertThat(Rank.fromLottoNumber(1)).isEqualTo(Rank.MISS);
    }
    
    @Test
    public void 랭크3등인데_보너스_번호를_맞아서_2등을_결정한다() {
        assertThat(Rank.THIRD.rankDecideByBonusNumber(new Lotto(40, 41, 42, 43, 44, 45), new LottoNumber(40))).isEqualTo(Rank.SECOND);
    }
    
    @Test
    public void 랭크2등인데_보너스_번호가_틀려서_3등을_결정한다() {
        assertThat(Rank.SECOND.rankDecideByBonusNumber(new Lotto(40, 41, 42, 43, 44, 45), new LottoNumber(39))).isEqualTo(Rank.THIRD);
    }
    
}