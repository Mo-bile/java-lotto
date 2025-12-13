package lotto.domain.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import lotto.domain.Rank;

public record WinningResult(Map<Rank, Integer> winningRankCounts) {
    
    public static final int INIT_COUNT = 0;
    
    public WinningResult() {
        this(createInitMap());
    }
    
    private static Map<Rank, Integer> createInitMap() {
        return Arrays.stream(Rank.values())
            .collect(Collectors.toMap(rank -> rank, rank -> INIT_COUNT));
    }
    
    public String calculateTotalReturn(int pay) {
        BigDecimal profit = getProfit();
        BigDecimal costBd = BigDecimal.valueOf(pay);
        BigDecimal rate = profit.divide(costBd, 2, RoundingMode.DOWN);
        return rate.toPlainString();
    }
    
    public String calculateTotalReturn(String pay) {
        return calculateTotalReturn(Integer.parseInt(pay));
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
