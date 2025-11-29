package lotto.domain.model;

import java.util.ArrayList;
import java.util.List;

public record LottoTickets(List<Lotto> tickets) {
    
    public LottoTickets(int num) {
        this(generateLottos(num));
    }
    
    private static List<Lotto> generateLottos(int num) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < num; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }
    
    public WinningResult identifyWinners(WinningLotto winningLotto) {
        WinningResult winningResult = new WinningResult();
        for(Lotto lotto: this.tickets) {
            winningResult.recordRank(winningLotto.rankDecide(lotto));
        }
        return winningResult;
    }
    
}
