package lotto.domain;

import java.util.Arrays;

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
    
    public static Rank getRank(int matchCount) {
        return Arrays.stream(values())
            .filter(rank -> rank.matchCount == matchCount)
            .findFirst()
            .orElse(MISS);
    }
    
    public static boolean isSecondOrThird(int matchCount) {
        return SECOND.matchCount == matchCount || THIRD.matchCount == matchCount;
    }
    
    public long getWinnerReturn() {
        return winnerReturn;
    }
    
}