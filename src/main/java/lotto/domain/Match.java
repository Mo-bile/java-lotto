package lotto.domain;

import lotto.domain.model.WinningResult;

public enum Match {
    THREE_MATCH(3, 5_000),
    FOUR_MATCH(4, 50_000),
    FIVE_MATCH(5, 1_500_000),
    SIX_MATCH(6, 2_000_000_000);
    
    private final int matchNumber;
    private final long winnerReturn;
    
    Match(int matchNumber, long winnerReturn) {
        this.matchNumber = matchNumber;
        this.winnerReturn = winnerReturn;
    }
    
    public static Match fromLottoNumber(int lottoNumber) {
        for (Match m : values()) {
            if (m.matchNumber == lottoNumber) return m;
        }
        return null;
    }
    
    public long getWinnerReturn() {
        return winnerReturn;
    }
}