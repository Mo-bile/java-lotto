package lotto.domain.business;

import java.util.List;
import lotto.domain.model.*;

public record LottoGame(Pay pay, LottoTickets lottoTickets) {
    
    public LottoGame(String pay, LottoTickets lottoTickets) {
        this(new Pay(pay), generateLottos(new Pay(pay)));
    }
    
    public LottoGame(int pay) {
        this(new Pay(pay), generateLottos(new Pay(pay)));
    }
    
    public LottoGame(int pay, LottoTickets lottoTickets) {
        this(new Pay(pay), lottoTickets);
    }
    
    private static LottoTickets generateLottos(Pay pay) {
        return new LottoTickets(pay.convertToBuyCount());
    }
    
    public List<Lotto> getLottos() {
        return List.copyOf(this.lottoTickets.tickets());
    }
    
    public WinningResult calculateWinningResult(String winnerLottoNumber, int bonus) {
        return this.lottoTickets.identifyWinners(new WinningLotto(bonus, winnerLottoNumber));
    }
    
    public WinningResult calculateWinningResult(String winnerLottoNumber, String bonus) {
        return calculateWinningResult(winnerLottoNumber, Integer.parseInt(bonus));
    }
}
