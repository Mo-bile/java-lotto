package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class PayTest {
    
    @Test
    void 천원단위로_입력안하면_에러전파() {
        assertThatThrownBy(() ->
            new Pay(10100)
        ).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("입력은 천원단위로 하시오");
    }
    
    @Test
    void 입력된_금액을_필요한_구매갯수로_반환한다() {
        Pay pay = new Pay(10000);
        assertThat(pay.convertToBuyCount())
            .isEqualTo(10);
    }
}