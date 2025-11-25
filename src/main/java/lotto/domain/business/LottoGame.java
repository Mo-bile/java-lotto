package lotto.domain.business;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.model.Lotto;
import lotto.domain.model.Lottos;
import lotto.domain.model.WinningResult;

public class LottoGame {
    
    private final int pay;
    private final Lottos lottos;
    
    public LottoGame(int pay) {
        this(pay, generateLottos(pay));
    }
    
    public LottoGame(int pay, Lottos lottos) {
        validate(pay);
        this.pay = pay;
        this.lottos = lottos;
    }
    
    private static Lottos generateLottos(int pay) {
        return new Lottos(pay / 1000);
    }
    
    public List<Lotto> getLottos() {
        return this.lottos.getLottoList();
    }
    
    public WinningResult showWinners(String winnerLottoNumber) {
        return this.lottos.findWinners(new Lotto(winnerLottoNumber));
    }
    
    private void validate(int pay) {
        if(pay % 1000 != 0) {
            throw new IllegalArgumentException("입력은 천원단위로 하시오");
        }
    }
}
