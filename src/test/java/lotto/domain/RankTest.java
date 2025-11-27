package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RankTest {
    
    @Test
    void 매치된_숫자5를_제시하면_다섯개_일치를_반환한다() {
        assertThat(Rank.fromLottoNumber(5)).isEqualTo(Rank.THIRD);
    }
    
}