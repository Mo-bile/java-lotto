package lotto.domain.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.Map.Entry;
import lotto.domain.Rank;

public record WinningResult(Map<Rank, Integer> matchMap) {
    
    public static final int INIT_COUNT = 0;
    
    public WinningResult() {
        this(createInitMap());
    }
    
    public WinningResult(int... ints) {
        this(initMatchMap(winningNumberArgsBuilder(ints)));
    }
    
    private static Map<Rank, Integer> createInitMap() {
        Map<Rank, Integer> map = new HashMap<>();
        for (Rank rank: Rank.values()) {
            map.put(rank, INIT_COUNT);
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
    
    private static Map<Rank, Integer> initMatchMap(List<Integer> winningNumberList) {
        Map<Rank, Integer> matchMap = new HashMap<>();
        iteratorMatchMap(matchMap, winningNumberList);
        return matchMap;
    }
    
    private static void iteratorMatchMap(Map<Rank, Integer> matchMap, List<Integer> count) {
        for(int i = 0; i < Rank.values().length; i++) {
            matchMap.put(Rank.values()[i], count.get(i));
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
        for(Entry<Rank, Integer> matchIntegerEntry: matchMap.entrySet()) {
            profit = profit.add(BigDecimal.valueOf(matchIntegerEntry.getValue()).multiply(BigDecimal.valueOf(matchIntegerEntry.getKey().getWinnerReturn())));
        }
        return profit;
    }
    
    public void increaseRankCount(Rank rank) {
        this.matchMap.compute(rank, (k, count) -> {
            if(count == null) {
                return INIT_COUNT;
            }
            return count + 1;
        });
    }
    
    public int getMatchCount(Rank rank) {
        return this.matchMap.get(rank);
    }
    
}
