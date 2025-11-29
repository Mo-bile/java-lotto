package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {
    
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 로또번호가_범위_밖이면_에러(int num) {
        assertThatThrownBy(() ->
            new Lotto(num, 1, 2, 3, 4, 5)
        ).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("보너스 번호는 1~45사이 입력하시오");
    }
    
    @Test
    void 로또_번호는_6자리가_아니면_에러() {
        assertThatThrownBy(() ->
            new Lotto(1, 2, 3, 4, 5)
        ).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("로또 번호는 6자리여야한다");
    }
    
    @Test
    void 로또_번호는_서로가_다르지않으면_에러() {
        assertThatThrownBy(() ->
            new Lotto(1, 1, 3, 4, 5, 6)
        ).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("로또번호는 서로 달라야한다");
    }
    
}