package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.Rank;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {
    
    @Test
    public void 로또_6_자리를_생성한다() {
        assertThat(new Lotto().numbers()).hasSize(6);
    }
    
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 로또번호가_범위_밖이면_에러(int num) {
        assertThatThrownBy(() ->
            new Lotto(num, 1, 2, 3, 4, 5)
        ).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("보너스 번호는 1~45사이 입력하시오");
    }
    
}