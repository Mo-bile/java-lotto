package lotto.domain.model.LottoGenertor;

import lotto.domain.model.BuyCount;
import lotto.domain.model.LottoTickets;

public interface LottoGenerator {
    
    LottoTickets generateTickets();
    
    BuyCount getBuyCount();
}
