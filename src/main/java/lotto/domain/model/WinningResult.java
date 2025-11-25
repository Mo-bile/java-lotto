package lotto.domain.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import lotto.domain.Match;

public record WinningResult(Map<Match, Integer> matchMap) {
    
    public static final int INITIAL_MATCH_COUNT = 0;
    
    public WinningResult() {
        this(initMatchMap(INITIAL_MATCH_COUNT, INITIAL_MATCH_COUNT, INITIAL_MATCH_COUNT, INITIAL_MATCH_COUNT));
    }
    
    public WinningResult(int threeMatchCount, int fourMatchCount, int fiveMatchCount, int sixMatchCount) {
        this(initMatchMap(threeMatchCount, fourMatchCount, fiveMatchCount, sixMatchCount));
    }
    
    private static Map<Match, Integer> initMatchMap(int threeMatchCount, int fourMatchCount, int fiveMatchCount, int sixMatchCount) {
        Map<Match, Integer> matchMap = new HashMap<>();
        iteratorMatchMap(matchMap, List.of(threeMatchCount, fourMatchCount, fiveMatchCount, sixMatchCount));
        return matchMap;
    }
    
    private static void iteratorMatchMap(Map<Match, Integer> matchMap, List<Integer> count) {
        for(int i = 0; i < Match.values().length; i++) {
            matchMap.put(Match.values()[i], count.get(i));
        }
    }
    
    public String calculateTotalReturn(int pay) {
        BigDecimal profit = getProfit();
        BigDecimal costBd = BigDecimal.valueOf(pay);
        BigDecimal rate = profit.divide(costBd, 2, RoundingMode.DOWN);
        return rate.toPlainString();
    }
    
    private BigDecimal getProfit() {
        BigDecimal profit = BigDecimal.ZERO;
        for(Entry<Match, Integer> matchIntegerEntry: matchMap.entrySet()) {
            profit = profit.add(BigDecimal.valueOf(matchIntegerEntry.getValue()).multiply(BigDecimal.valueOf(matchIntegerEntry.getKey().getWinnerReturn())));
        }
        return profit;
    }
    
    public void increaseMatch(Match match) {
        if(match == null) {
            return;
        }
        this.increaseCount(match);
    }
    
    private void increaseCount(Match match) {
        this.matchMap.compute(match, (k, count) -> {
            if(count == null) {
                return INITIAL_MATCH_COUNT;
            }
            return count + 1;
        });
    }
    
    public int getMatchCount(Match match) {
        return this.matchMap.get(match);
    }
    
}
