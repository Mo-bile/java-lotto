package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoTest {
    
    @Test
    public void 로또_6_자리를_생성한다() {
        assertThat(new Lotto().getNumbers()).hasSize(6);
    }
    
    @Test
    public void 로또_6자리는_1에서45사이이다() {
        assertThat(new Lotto().getNumbers())
            .allMatch(num -> num >= 1 && num <= 45);
    }

}