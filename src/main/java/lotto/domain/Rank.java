package lotto.domain;

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
    
    public static Rank fromMatchCount(int matchCount) {
        for (Rank r : values()) {
            Rank result = getMatch(matchCount, r);
            if(result != null) {
                return result;
            }
        }
        return null;
    }
    
    private static Rank getMatch(int matchCount, Rank rank) {
        if (rank.matchCount == matchCount){
            if(rank.matchCount == 5) {
                return THIRD;
            }
            return rank;
        }
        return null;
    }  
    
    public long getWinnerReturn() {
        return winnerReturn;
    }
}