package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.Rank;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    
    @Test
    void 당첨번호와_보너스번호는_같으면_에러전파() {
        assertThatThrownBy(() ->
            new WinningLotto(new Lotto(1, 2, 3, 4, 5, 6), new LottoNumber(1))
        ).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("당첨번호 일부가 보너스 번호가 같습니다");
    }
    
}