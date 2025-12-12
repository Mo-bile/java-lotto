package lotto.domain.model.LottoGenertor;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.model.LottoTickets;
import org.junit.jupiter.api.Test;

class LottoAutoGeneratorTest {
    
    @Test
    void 자동으로_생성한_만큼_보여준다() {
        LottoGenerator lottoGenerator = new LottoAutoGenerator(5000);
        
        LottoTickets lottoTickets = lottoGenerator.generateTickets();
        assertThat(lottoTickets.getLottoTicketCount()).isEqualTo(5);
        assertThat(lottoGenerator.getBuyCount().total()).isEqualTo(5);
    }
}