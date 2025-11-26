package lotto.domain.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.Map.Entry;
import lotto.domain.Match;

public record WinningResult(Map<Match, Integer> matchMap) {
    
    public static final int INIT_COUNT = 0;
    
    public WinningResult() {
        this(createInitMap());
    }
    
    public WinningResult(int... ints) {
        this(initMatchMap(winningNumberArgsBuilder(ints)));
    }
    
    private static Map<Match, Integer> createInitMap() {
        Map<Match, Integer> map = new HashMap<>();
        for (Match match : Match.values()) {
            map.put(match, INIT_COUNT);
        }
        return map;
    }
    
    private static List<Integer> winningNumberArgsBuilder(int[] ints) {
        List<Integer> integerList = new ArrayList<>();
        for(int anInt: ints) {
            integerList.add(anInt);
        }
        return integerList;
    }
    
    private static Map<Match, Integer> initMatchMap(List<Integer> winningNumberList) {
        Map<Match, Integer> matchMap = new HashMap<>();
        iteratorMatchMap(matchMap, winningNumberList);
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
                return INIT_COUNT;
            }
            return count + 1;
        });
    }
    
    public int getMatchCount(Match match) {
        return this.matchMap.get(match);
    }
    
}
