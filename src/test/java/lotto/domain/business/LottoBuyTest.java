package lotto.domain.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.model.LottoGenerator;
import lotto.domain.model.impl.LottoAutoGenerator;
import lotto.domain.model.impl.LottoCombineGenerator;
import lotto.domain.model.impl.LottoManulGenerator;
import org.junit.jupiter.api.Test;

class LottoBuyTest {
    
    @Test
    void 수동생성에다가_자동생성을_합친_수는_같다() {
        LottoGenerator lottoGenerator = new LottoManulGenerator(1000, List.of("1,2,3,4,5,6"));
        LottoBuy lottoBuy = lottoGenerator.generate();
        assertThat(lottoBuy.combineLotto().tickets()).hasSize(1);
    }
    
    @Test
    void 혼합생성에다가_자동생성을_합친_수는_같다() {
        LottoGenerator lottoGenerator = new LottoCombineGenerator(5000, List.of("1,2,3,4,5,6"));
        LottoBuy lottoBuy = lottoGenerator.generate();
        assertThat(lottoBuy.combineLotto().tickets()).hasSize(5);
    }
    
    @Test
    void 자동생성에다가_자동생성을_합친_수는_같다() {
        LottoGenerator lottoGenerator = new LottoAutoGenerator(5000);
        LottoBuy lottoBuy = lottoGenerator.generate();
        assertThat(lottoBuy.combineLotto().tickets()).hasSize(5);
    }
    
}