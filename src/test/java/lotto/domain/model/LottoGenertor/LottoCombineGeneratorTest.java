package lotto.domain.model.LottoGenertor;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.model.LottoTickets;
import org.junit.jupiter.api.Test;

class LottoCombineGeneratorTest {
    
    @Test
    void 수동으로_생성한_만큼_보여준다() {
        LottoGenerator lottoGenerator = new LottoCombineGenerator(5000, "1,2,3,4,5,6");
        LottoTickets lottoTickets = lottoGenerator.generateTickets();
        
        assertThat(lottoTickets).isNotNull();
        assertThat(lottoGenerator.getBuyCount().manual()).isEqualTo(1);
    }
    
    @Test
    void 자동으로_생성한_만큼_보여준다() {
        LottoGenerator lottoGenerator = new LottoCombineGenerator(5000, "1,2,3,4,5,6");
        LottoTickets lottoTickets = lottoGenerator.generateTickets();
        
        assertThat(lottoTickets).isNotNull();
        assertThat(lottoGenerator.getBuyCount().auto()).isEqualTo(4);
    }
    
}