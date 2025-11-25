package lotto.domain.model;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Match;

public class Lottos {
    
    private final List<Lotto> lottoList;
    
    public Lottos(int num) {
        this(generateLottos(num));
    }
    
    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }
    
    public List<Lotto> getLottoList() {
        return this.lottoList;
    }
    
    private static List<Lotto> generateLottos(int num) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < num; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }
    
    public WinningResult findWinners(Lotto winnerLotto) {
        WinningResult winningResult = new WinningResult();
        for(Lotto lotto: this.lottoList) {
            Match match = Match.fromLottoNumber(lotto.findMatchNumbers(winnerLotto.getNumbers()));
            winningResult.increaseMatch(match);
        }
        return winningResult;
    }
    
}
