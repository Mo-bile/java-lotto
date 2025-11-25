package lotto.domain.business;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.model.Lotto;
import lotto.domain.model.Lottos;
import lotto.domain.model.Pay;
import lotto.domain.model.WinningResult;

public class LottoGame {
    
    private final Pay pay;
    private final Lottos lottos;
    
    public LottoGame(int pay) {
        this(new Pay(pay), generateLottos(new Pay(pay)));
    }
    
    public LottoGame(Pay pay, Lottos lottos) {
        this.pay = pay;
        this.lottos = lottos;
    }
    
    private static Lottos generateLottos(Pay pay) {
        return new Lottos(pay.convertToBuyCount());
    }
    
    public List<Lotto> getLottos() {
        return this.lottos.getLottoList();
    }
    
    public WinningResult showWinners(String winnerLottoNumber) {
        return this.lottos.findWinners(new Lotto(winnerLottoNumber));
    }
}
