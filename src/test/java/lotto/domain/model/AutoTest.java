package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AutoTest {
    
    @Test
    void 갯수를_입력받으면_로또를_생성한다() {
        Auto auto = new Auto(5);
        assertThat(auto.getAutoLottoList()).hasSize(5);
    }
    
}