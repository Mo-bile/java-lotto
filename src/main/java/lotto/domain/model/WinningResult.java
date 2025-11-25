package lotto.domain.model;

import static lotto.domain.Match.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import lotto.domain.Match;

public class WinningResult {
    private final Map<Match, Integer> matchMap;
    
    public WinningResult() {
        this(initMatchMap(0, 0, 0, 0));
    }
    
    public WinningResult(int threeMatchCount, int fourMatchCount, int fiveMatchCount, int sixMatchCount) {
        this(initMatchMap(threeMatchCount, fourMatchCount, fiveMatchCount, sixMatchCount));
    }
    
    public WinningResult(Map<Match, Integer> matchMap) {
        this.matchMap = matchMap;
    }
    
    private static Map<Match, Integer> initMatchMap(int threeMatchCount, int fourMatchCount, int fiveMatchCount, int sixMatchCount) {
        Map<Match, Integer> matchMap = new HashMap<>();
        matchMap.put(Match.THREE_MATCH, threeMatchCount);
        matchMap.put(Match.FOUR_MATCH, fourMatchCount);
        matchMap.put(Match.FIVE_MATCH, fiveMatchCount);
        matchMap.put(Match.SIX_MATCH, sixMatchCount);
        return matchMap;
    }
    
    public String calculateTotalReturn(int pay) {
        BigDecimal profit = getProfit();
        BigDecimal costBd = BigDecimal.valueOf(pay);
        BigDecimal rate = profit.divide(costBd, 2, RoundingMode.DOWN);
        return rate.toPlainString();
    }
    
    private BigDecimal getProfit() {
        BigDecimal profit = BigDecimal.ZERO;
        profit = profit.add(BigDecimal.valueOf(this.matchMap.get(THREE_MATCH)).multiply(BigDecimal.valueOf(THREE_MATCH.getWinnerReturn())));
        profit = profit.add(BigDecimal.valueOf(this.matchMap.get(FOUR_MATCH)).multiply(BigDecimal.valueOf(FOUR_MATCH.getWinnerReturn())));
        profit = profit.add(BigDecimal.valueOf(this.matchMap.get(FIVE_MATCH)).multiply(BigDecimal.valueOf(FIVE_MATCH.getWinnerReturn())));
        profit = profit.add(BigDecimal.valueOf(this.matchMap.get(SIX_MATCH)).multiply(BigDecimal.valueOf(SIX_MATCH.getWinnerReturn())));
        return profit;
    }
    
    public void increaseMatch(Match match) {
        if (match == null) return;
        match.increase(this);
    }
    
    public void increaseThree() {
        this.matchMap.compute(THREE_MATCH, (k, threeMatch) -> threeMatch + 1);
    }
    
    public void increaseFour() {
        this.matchMap.compute(FOUR_MATCH, (k, FOUR_MATCH) -> FOUR_MATCH + 1);
    }
    
    public void increaseFive() {
        this.matchMap.compute(FIVE_MATCH, (k, FIVE_MATCH) -> FIVE_MATCH + 1);
    }
    
    public void increaseSix() {
        this.matchMap.compute(SIX_MATCH, (k, SIX_MATCH) -> SIX_MATCH + 1);
    }
    
    public int getMatchCount(Match match) {
        return this.matchMap.get(match);
    }
    
    @Override
    public boolean equals(Object o) {
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        WinningResult that = (WinningResult) o;
        return Objects.equals(matchMap, that.matchMap);
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(matchMap);
    }
}
