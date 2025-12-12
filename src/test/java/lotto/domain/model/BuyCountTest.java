package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThat;
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
    
    @Test
    void 구매갯수를_누적해서_만든다() {
        BuyCount buyCountBase = BuyCount.empty();
        BuyCount buyCountFirstAdd = buyCountBase.add(new BuyCount(5, 3, 2));
        BuyCount buyCountSecondAdd = buyCountFirstAdd.add(new BuyCount(15, 5, 10));
        
        BuyCount expected = new BuyCount(20, 8, 12);
        assertThat(buyCountSecondAdd).isEqualTo(expected);
        
    }
}