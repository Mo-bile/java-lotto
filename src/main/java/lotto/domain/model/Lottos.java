package lotto.domain.model;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Rank;

public record Lottos(List<Lotto> lottoList) {
    
    public Lottos(int num) {
        this(generateLottos(num));
    }
    
    private static List<Lotto> generateLottos(int num) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < num; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }
    
    public WinningResult identifyWinners(Lotto winnerLotto, Bonus bonus) {
        WinningResult winningResult = new WinningResult();
        for(Lotto lotto: this.lottoList) {
            Rank match = lotto.match(winnerLotto);
            if(match.decideSecond(lotto, bonus)) {
                match = Rank.SECOND;
            }
            winningResult.increaseMatch(match);
        }
        return winningResult;
    }
    
}
