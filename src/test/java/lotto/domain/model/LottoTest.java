package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Rank;
import org.junit.jupiter.api.Test;

class LottoTest {
    
    @Test
    public void 로또_6_자리를_생성한다() {
        assertThat(new Lotto().numbers()).hasSize(6);
    }
    
    @Test
    public void 로또_6자리는_1에서45사이이다() {
        assertThat(new Lotto().numbers())
            .allMatch(num -> num >= 1 && num <= 45);
    }
    
    @Test
    public void 로또번호4개_일치하면_FOUR_MATCH가_반환된다 () {
        Lotto lotto = new Lotto(40, 41, 42, 43, 44, 45);
        Rank rank = lotto.rankDecide(new Lotto(42, 36, 37, 43, 44, 45));
        assertThat(rank).isEqualTo(Rank.FOURTH);
    }
    
    @Test
    public void 로또번호6개_일치하면_SIX_MATCH가_반환된다 () {
        Lotto lotto = new Lotto(40, 41, 42, 43, 44, 45);
        Rank rank = lotto.rankDecide(new Lotto(42, 41, 40, 43, 44, 45));
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    
}