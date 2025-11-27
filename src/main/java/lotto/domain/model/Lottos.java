package lotto.domain.model;

import java.util.ArrayList;
import java.util.List;

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
    
    public WinningResult identifyWinners(Lotto winnerLotto, Bonus bonusNumber) {
        WinningResult winningResult = new WinningResult();
        for(Lotto lotto: this.lottoList) {
            winningResult.increaseMatch(lotto.rankDecideByBonusNumber(bonusNumber, lotto.rankDecide(winnerLotto)));
        }
        return winningResult;
    }
    
}
