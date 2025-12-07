package lotto.domain.model.impl;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.business.LottoBuy;
import lotto.domain.model.LottoGenerator;
import org.junit.jupiter.api.Test;

class LottoCombineGeneratorTest {
    
    @Test
    void 수동으로_생성한_만큼_보여준다() {
        LottoGenerator lottoGenerator = new LottoCombineGenerator(5000, "1,2,3,4,5,6");
        LottoBuy lottoBuy = lottoGenerator.generate();
        
        assertThat(lottoBuy.combineBuyCount().manual()).isEqualTo(1);
    }
    
    @Test
    void 자동으로_생성한_만큼_보여준다() {
        LottoGenerator lottoGenerator = new LottoCombineGenerator(5000, "1,2,3,4,5,6");
        LottoBuy lottoBuy = lottoGenerator.generate();
        assertThat(lottoBuy.combineBuyCount().auto()).isEqualTo(4);
    }
    
}