package lotto.domain.business;

import java.util.List;
import lotto.domain.model.Lotto;
import lotto.domain.model.Lottos;
import lotto.domain.model.Pay;
import lotto.domain.model.WinningResult;

public record LottoGame(Pay pay, Lottos lottos) {
    
    public LottoGame(int pay) {
        this(new Pay(pay), generateLottos(new Pay(pay)));
    }
    
    private static Lottos generateLottos(Pay pay) {
        return new Lottos(pay.convertToBuyCount());
    }
    
    public List<Lotto> getLottos() {
        return this.lottos.lottoList();
    }
    
    public WinningResult displayWinners(String winnerLottoNumber) {
        return this.lottos.identifyWinners(new Lotto(winnerLottoNumber));
    }
}
