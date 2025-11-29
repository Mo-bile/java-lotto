package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.Rank;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    
    @Test
    void 당첨번호와_보너스번호는_같으면_에러전파() {
        assertThatThrownBy(() ->
            new WinningLotto(new LottoNumber(1), new Lotto(1, 2, 3, 4, 5, 6))
        ).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("당첨번호 일부가 보너스 번호가 같습니다");
    }
    
    @Test
    public void 로또번호4개_일치하면_FOURTH가_반환된다() {
        WinningLotto winningLotto = new WinningLotto(new LottoNumber(20), new Lotto(42, 36, 37, 43, 44, 45));
        Rank rank = winningLotto.rankDecide(new Lotto(40, 41, 42, 43, 44, 45));
        assertThat(rank).isEqualTo(Rank.FOURTH);
    }
    
    @Test
    public void 로또번호6개_일치하면_FIRST가_반환된다() {
        WinningLotto winningLotto = new WinningLotto(new LottoNumber(20), new Lotto(42, 41, 40, 43, 44, 45));
        Rank rank = winningLotto.rankDecide(new Lotto(40, 41, 42, 43, 44, 45));
        assertThat(rank).isEqualTo(Rank.FIRST);
    }
    
}
