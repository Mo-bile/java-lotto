package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RankTest {
    
    @Test
    void 매치4에_해당하면_FOURTH를_준다() {
        assertThat(Rank.getRank(4)).isEqualTo(Rank.FOURTH);
    }
    
    @Test
    void 매치2에_해당하면_miss를_준다() {
        assertThat(Rank.getRank(2)).isEqualTo(Rank.MISS);
    }
    
    @Test
    void 매치5에_해당하면_참이다() {
        assertThat(Rank.isSecondOrThird(5)).isTrue();
    }
    
}