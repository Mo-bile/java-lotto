package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoTest {
    
    @Test
    public void 로또_6_자리를_생성한다() {
        assertThat(new Lotto().getNumbers()).hasSize(6);
    }
    
    @Test
    public void 로또_6자리는_1에서45사이이다() {
        assertThat(new Lotto().getNumbers())
            .allMatch(num -> num >= 1 && num <= 45);
    }
    
    @Test
    public void 인자로들어온_로또번호가_3개_일치한다() {
        Lotto lotto = new Lotto(40, 41, 42, 43, 44, 45);
        assertThat(lotto.findMatchNumbers(List.of(35, 36, 37, 43, 44, 45)))
            .isEqualTo(3);
    }
    
    @Test
    public void 인자로들어온_로또번호가_4개_일치한다() {
        Lotto lotto = new Lotto(40, 41, 42, 43, 44, 45);
        assertThat(lotto.findMatchNumbers(List.of(42, 36, 37, 43, 44, 45)))
            .isEqualTo(4);
    }
    
    @Test
    public void 인자로들어온_로또번호가_5개_일치한다() {
        Lotto lotto = new Lotto(40, 41, 42, 43, 44, 45);
        assertThat(lotto.findMatchNumbers(List.of(42, 41, 37, 43, 44, 45)))
            .isEqualTo(5);
    }
    
    @Test
    public void 인자로들어온_로또번호가_6개_일치한다() {
        Lotto lotto = new Lotto(40, 41, 42, 43, 44, 45);
        assertThat(lotto.findMatchNumbers(List.of(42, 41, 40, 43, 44, 45)))
            .isEqualTo(6);
    }

}