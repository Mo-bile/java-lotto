package lotto.domain.model.impl;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.business.LottoBuy;
import lotto.domain.model.LottoGenerator;
import org.junit.jupiter.api.Test;

class LottoAutoGeneratorTest {
    
    @Test
    void 자동으로_생성한_만큼_보여준다() {
        LottoGenerator lottoGenerator = new LottoAutoGenerator();
        LottoBuy lottoBuy = lottoGenerator.generate(5000);
        assertThat(lottoBuy.combineBuyCount().total()).isEqualTo(5);
    }
}