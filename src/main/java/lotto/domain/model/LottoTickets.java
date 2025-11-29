package lotto.domain.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public record LottoTickets(List<Lotto> tickets) {
    
    public LottoTickets(Lotto... lottos) {
        this(generateLottos(lottos));
    }
    
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
    
    private static List<Lotto> generateLottos(Lotto... lottos) {
        return Arrays.asList(lottos);
    }
    
    public WinningResult identifyWinners(WinningLotto winningLotto) {
        WinningResult winningResult = new WinningResult();
        for(Lotto lotto: this.tickets) {
            winningResult.recordRank(winningLotto.rankDecide(lotto));
        }
        return winningResult;
    }
    
}
