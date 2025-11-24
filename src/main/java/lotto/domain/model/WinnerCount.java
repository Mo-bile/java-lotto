package lotto.domain.model;

import static lotto.domain.Match.*;

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
        BigDecimal profit = getProfit();
        BigDecimal costBd = BigDecimal.valueOf(cost);
        BigDecimal rate = profit.divide(costBd, 2, RoundingMode.DOWN);
        return rate.toPlainString();
    }
    
    private BigDecimal getProfit() {
        BigDecimal profit = BigDecimal.ZERO;
        profit = profit.add(BigDecimal.valueOf(this.threeMatch).multiply(BigDecimal.valueOf(THREE_MATCH.getWinnerReturn())));
        profit = profit.add(BigDecimal.valueOf(this.fourMatch).multiply(BigDecimal.valueOf(FOUR_MATCH.getWinnerReturn())));
        profit = profit.add(BigDecimal.valueOf(this.fiveMatch).multiply(BigDecimal.valueOf(FIVE_MATCH.getWinnerReturn())));
        profit = profit.add(BigDecimal.valueOf(this.sixMatch).multiply(BigDecimal.valueOf(SIX_MATCH.getWinnerReturn())));
        return profit;
    }
    
    public void increaseMatch(Match match) {
        if (match == null) return;
        match.increase(this);
    }
    
    public void increaseThree() {
        this.threeMatch ++;
    }
    
    public void increaseFour() {
        this.fourMatch ++;
    }
    
    public void increaseFive() {
        this.fiveMatch ++;
    }
    
    public void increaseSix() {
        this.sixMatch ++;
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
