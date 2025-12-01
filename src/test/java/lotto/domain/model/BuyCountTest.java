package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class BuyCountTest {
    
    @Test
    void 지불금액으로_만드는로또수가_실제로또수와_다르면_에러전파() {
        
        assertThatThrownBy(() -> {
            new BuyCount(5, 1, 1);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("지불금액 대비 구매수가 일치하지 않습니다.");
        
    }
}