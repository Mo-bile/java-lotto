package lotto.domain;

import lotto.domain.model.Bonus;
import lotto.domain.model.Lotto;

public enum Rank {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 5_0000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);
    
    private final int matchCount;
    private final long winnerReturn;
    
    Rank(int matchCount, long winnerReturn) {
        this.matchCount = matchCount;
        this.winnerReturn = winnerReturn;
    }
    
    public static Rank fromLottoNumber(int lottoNumber) {
        for (Rank r : values()) {
            if (r.matchCount == lottoNumber) return r;
        }
        return null;
    }
    
    public long getWinnerReturn() {
        return winnerReturn;
    }
    
    public boolean decideSecond(Lotto lotto, Bonus bonus) {
        if(this.isSecondOrThird()) {
            return bonus.isBonusMatch(lotto);
        }
        return false;
    }
    
    private boolean isSecondOrThird() {
        return this == THIRD || this == SECOND;
    }
    
}