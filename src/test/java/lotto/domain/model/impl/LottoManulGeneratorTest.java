package lotto.domain.model.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.business.LottoBuy;
import lotto.domain.model.LottoGenerator;
import org.junit.jupiter.api.Test;

class LottoManulGeneratorTest {
    
    @Test
    void 수동으로_생성한_만큼_보여준다() {
        LottoGenerator lottoGenerator = new LottoManulGenerator();
        LottoBuy lottoBuy = lottoGenerator.generate(3000, List.of("1,2,3,4,5,6", "1,2,3,4,5,7", "1,2,3,4,5,9"));
        assertThat(lottoBuy.combineBuyCount().total()).isEqualTo(3);
    }
}