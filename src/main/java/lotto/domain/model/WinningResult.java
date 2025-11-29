package lotto.domain.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import lotto.domain.Rank;

public record WinningResult(Map<Rank, Integer> winningRankCounts) {
    
    public static final int INIT_COUNT = 0;
    
    public WinningResult() {
        this(createInitMap());
    }
    
    private static Map<Rank, Integer> createInitMap() {
        Map<Rank, Integer> map = new HashMap<>();
        for(Rank rank: Rank.values()) {
            map.put(rank, INIT_COUNT);
        }
        return map;
    }
    
    public String calculateTotalReturn(int pay) {
        BigDecimal profit = getProfit();
        BigDecimal costBd = BigDecimal.valueOf(pay);
        BigDecimal rate = profit.divide(costBd, 2, RoundingMode.DOWN);
        return rate.toPlainString();
    }
    
    private BigDecimal getProfit() {
        BigDecimal profit = BigDecimal.ZERO;
        for(Entry<Rank, Integer> matchIntegerEntry: winningRankCounts.entrySet()) {
            profit = profit.add(BigDecimal.valueOf(matchIntegerEntry.getValue()).multiply(BigDecimal.valueOf(matchIntegerEntry.getKey().getWinnerReturn())));
        }
        return profit;
    }
    
    public void recordRank(Rank rank) {
        this.winningRankCounts.compute(rank, (k, count) -> {
            if(count == null) {
                return INIT_COUNT;
            }
            return count + 1;
        });
    }
    
    public int getMatchCount(Rank rank) {
        return this.winningRankCounts.get(rank);
    }
    
}
