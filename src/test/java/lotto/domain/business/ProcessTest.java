package lotto.domain.business;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProcessTest {
    
    @Test
    void 천단위로_돈을_안받으면_에러를_뱉는다() {
        assertThatThrownBy(() ->
            new Process(10100)
        ).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("입력은 천원단위로 하시오");
    }
    
    @Test
    void 받은_금액을_로또n개로변환하여_생성한다() {
        Process process = new Process(10000);
        System.out.println("process = " + process.getLottos());
        assertThat(process.getLottos()).hasSize(10);
    }
    
}