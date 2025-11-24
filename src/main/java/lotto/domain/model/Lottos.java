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
    
    public WinnerCount findWinners(Lotto winnerLotto) {
        WinnerCount winnerCount = new WinnerCount(0, 0, 0, 0);
        for(Lotto lotto: this.lottoList) {
            Match match = Match.fromCount(lotto.findMatchNumbers(winnerLotto.getNumbers()));
            if (match == null) continue;
            switch (match) {
                case THREE_MATCH -> winnerCount.increaseThree();
                case FOUR_MATCH -> winnerCount.increaseFour();
                case FIVE_MATCH -> winnerCount.increaseFive();
                case SIX_MATCH -> winnerCount.increaseSix();
            }
        }
        return winnerCount;
    }
    
}
