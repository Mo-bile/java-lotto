package lotto.domain.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import lotto.domain.Match;

public class WinnerCount {
    private int threeMatch;
    private int fourMatch;
    private int fiveMatch;
    private int sixMatch;
    
    public WinnerCount() {
        this(0, 0, 0, 0);
    }
    
    public WinnerCount(int threeMatch, int fourMatch, int fiveMatch, int sixMatch) {
        this.threeMatch = threeMatch;
        this.fourMatch = fourMatch;
        this.fiveMatch = fiveMatch;
        this.sixMatch = sixMatch;
    }
    
    public String calculateTotalReturn(int cost) {
        BigDecimal profit = BigDecimal.ZERO;
        profit = profit.add(BigDecimal.valueOf(this.threeMatch).multiply(BigDecimal.valueOf(5_000)));
        profit = profit.add(BigDecimal.valueOf(this.fourMatch).multiply(BigDecimal.valueOf(50_000)));
        profit = profit.add(BigDecimal.valueOf(this.fiveMatch).multiply(BigDecimal.valueOf(1_500_000)));
        profit = profit.add(BigDecimal.valueOf(this.sixMatch).multiply(BigDecimal.valueOf(2_000_000_000L)));
        
        BigDecimal costBd = BigDecimal.valueOf(cost);
        
        BigDecimal rate = profit.divide(costBd, 2, RoundingMode.DOWN);
        return rate.toPlainString();
    }
    
    public void increaseMatch(Match match) {
        if (match == null) return;
        switch (match) {
            case THREE_MATCH -> this.threeMatch ++;
            case FOUR_MATCH -> this.fourMatch ++;
            case FIVE_MATCH -> this.fiveMatch ++;
            case SIX_MATCH -> this.sixMatch ++;
        }
    }
    
    public int getThreeMatch() {
        return threeMatch;
    }
    
    public int getFourMatch() {
        return fourMatch;
    }
    
    public int getFiveMatch() {
        return fiveMatch;
    }
    
    public int getSixMatch() {
        return sixMatch;
    }
    
    @Override
    public boolean equals(Object o) {
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        WinnerCount winnerCount = (WinnerCount) o;
        return threeMatch == winnerCount.threeMatch && fourMatch == winnerCount.fourMatch && fiveMatch == winnerCount.fiveMatch && sixMatch == winnerCount.sixMatch;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(threeMatch, fourMatch, fiveMatch, sixMatch);
    }
}
