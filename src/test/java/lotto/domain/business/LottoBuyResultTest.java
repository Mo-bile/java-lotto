package lotto.domain.business;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.model.Lotto;
import lotto.domain.model.Manual;
import org.junit.jupiter.api.Test;

class LottoBuyResultTest {
    
    @Test
    void pay한만큼_로또_생성을_했다() {
    
    }
    
    @Test
    void 수동생성에다가_자동생성을_합친것을_보여준다() {
    
    }
    
    @Test
    void 수동구매_갯수가_구매가능갯수보다_많으면_에러전파() {
        Manual manual = new Manual(2, List.of(new Lotto(), new Lotto()));
        assertThatThrownBy(() ->
            manual.validateLimit(1)
        ).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("수동구매 갯수가 구매가능갯수보다 많다.");
    }
}