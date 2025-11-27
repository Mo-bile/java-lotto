package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusTest {
    
    @Test
    void Bonus와_일치한다() {
        Bonus bonus = new Bonus(45);
        assertThat(bonus.isBonusMatch(new Lotto(40, 41, 42, 43, 44, 45))).isTrue();
    }
    
    @ParameterizedTest
    @ValueSource(ints = {0,46})
    void 로또번호가_범위_밖이면_에러(int num) {
        assertThatThrownBy(() ->
            new Bonus(num)
        ).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("보너스 번호는 1~45사이 입력하시오");
    }
    
}