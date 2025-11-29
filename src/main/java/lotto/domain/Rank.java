package lotto.domain;

import java.util.Arrays;
import lotto.domain.model.Lotto;
import lotto.domain.model.LottoNumber;

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
    
    public static Rank fromLottoNumber(int matchCount, boolean bonusMatch) {
        if(matchCount == 5) {
            if(bonusMatch) {
                return SECOND;
            }
            return THIRD;
        }
        for(Rank r: values()) {
            if(r.matchCount == matchCount) {
                return r;
            }
        }
        return MISS;
    }
    
    public long getWinnerReturn() {
        return winnerReturn;
    }
    
}