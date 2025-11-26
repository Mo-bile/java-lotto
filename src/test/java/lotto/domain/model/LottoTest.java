package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Match;
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
    public void 인자로들어온_로또번호가_3개_일치한다() {
        Lotto lotto = new Lotto(40, 41, 42, 43, 44, 45);
        assertThat(lotto.findMatchCount(new Lotto(35, 36, 37, 43, 44, 45)))
            .isEqualTo(3);
    }
    
    @Test
    public void 인자로들어온_로또번호가_4개_일치한다() {
        Lotto lotto = new Lotto(40, 41, 42, 43, 44, 45);
        assertThat(lotto.findMatchCount(new Lotto(42, 36, 37, 43, 44, 45)))
            .isEqualTo(4);
    }
    
    @Test
    public void 로또번호4개_일치하면_FOUR_MATCH가_반환된다 () {
        Lotto lotto = new Lotto(40, 41, 42, 43, 44, 45);
        Match match = lotto.match(new Lotto(42, 36, 37, 43, 44, 45));
        assertThat(match).isEqualTo(Match.FOURTH);
    }
    
    @Test
    public void 인자로들어온_로또번호가_5개_일치한다() {
        Lotto lotto = new Lotto(40, 41, 42, 43, 44, 45);
        assertThat(lotto.findMatchCount(new Lotto(42, 41, 37, 43, 44, 45)))
            .isEqualTo(5);
    }
    
    @Test
    public void 인자로들어온_로또번호가_6개_일치한다() {
        Lotto lotto = new Lotto(40, 41, 42, 43, 44, 45);
        assertThat(lotto.findMatchCount(new Lotto(42, 41, 40, 43, 44, 45)))
            .isEqualTo(6);
    }
    
    @Test
    public void 로또번호6개_일치하면_SIX_MATCH가_반환된다 () {
        Lotto lotto = new Lotto(40, 41, 42, 43, 44, 45);
        Match match = lotto.match(new Lotto(42, 41, 40, 43, 44, 45));
        assertThat(match).isEqualTo(Match.FIRST);
    }

}