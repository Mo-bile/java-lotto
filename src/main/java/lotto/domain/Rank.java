package lotto.domain;

public enum Rank {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 5_0000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);
    
    private final int matchNumber;
    private final long winnerReturn;
    
    Rank(int matchNumber, long winnerReturn) {
        this.matchNumber = matchNumber;
        this.winnerReturn = winnerReturn;
    }
    
    public static Rank fromLottoNumber(int lottoNumber) {
        for (Rank m : values()) {
            Rank third = getMatch(lottoNumber, m);
            if(third != null) {
                return third;
            }
        }
        return null;
    }
    
    private static Rank getMatch(int lottoNumber, Rank m) {
        if (m.matchNumber == lottoNumber){
            if(m.matchNumber == 5) {
                return THIRD;
            }
            return m;
        }
        return null;
    }  
    
    public long getWinnerReturn() {
        return winnerReturn;
    }
}