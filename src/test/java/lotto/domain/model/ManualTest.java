package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class ManualTest {
    
    @Test
    void 로또의_생성갯수는_수동갯수보다_같지않으면_에러전파() {
        assertThatThrownBy(() ->
            new Manual(3, List.of(new Lotto(), new Lotto()))
        ).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("수동 구매 갯수와 수동 입력 로또 수가 다르다.");
    }
    
    @Test
    void 수동구매_갯수가_구매가능갯수보다_많으면_에러전파() {
        Manual manual = new Manual(3, List.of(new Lotto(), new Lotto(), new Lotto()));
        assertThatThrownBy(() ->
            manual.validateLimit(1)
        ).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("수동구매 갯수가 구매가능갯수보다 많다.");
    }
}