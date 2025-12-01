package lotto.domain.business;

import java.util.stream.Stream;
import lotto.domain.model.Auto;
import lotto.domain.model.BuyCount;
import lotto.domain.model.LottoTickets;
import lotto.domain.model.Manual;

public record LottoBuy(BuyCount buyCount, Manual manual, Auto auto) {
    
    public LottoTickets combineLotto() {
        return new LottoTickets(Stream.concat(
                this.manual.manualLottoList().stream(),
                this.auto.autoLottoList().stream())
            .toList());
    }
    
    public BuyCount combineBuyCount() {
        return this.buyCount;
    }
}
