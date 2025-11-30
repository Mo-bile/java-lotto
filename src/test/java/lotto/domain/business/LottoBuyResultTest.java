package lotto.domain.business;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoBuyResultTest {
    
    @Test
    void 수동으로_생성한_만큼_보여준다() {
        LottoBuyResult lottoBuyResult = new LottoBuyResult(5000, List.of("1,2,3,4,5,6"));
        assertThat(lottoBuyResult.combineBuyCount().getManual()).isEqualTo(1);
    }
    
    @Test
    void 자동으로_생성한_만큼_보여준다() {
        LottoBuyResult lottoBuyResult = new LottoBuyResult(5000, List.of("1,2,3,4,5,6"));
        assertThat(lottoBuyResult.combineBuyCount().getAuto()).isEqualTo(4);
    }
    
    @Test
    void 수동생성에다가_자동생성을_합친것을_보여준다() {
        LottoBuyResult lottoBuyResult = new LottoBuyResult(5000, List.of("1,2,3,4,5,6"));
        assertThat(lottoBuyResult.combineLotto().tickets()).hasSize(5);
    }
    
}