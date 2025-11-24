package lotto.domain.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Objects;

public class Winner {
    private int threeMatch;
    private int fourMatch;
    private int fiveMatch;
    private int sixMatch;
    
    public Winner(int threeMatch, int fourMatch, int fiveMatch, int sixMatch) {
        this.threeMatch = threeMatch;
        this.fourMatch = fourMatch;
        this.fiveMatch = fiveMatch;
        this.sixMatch = sixMatch;
    }
    
    public String calculateTotalReturn(int cost) {
        float lottoProfit = 0;
        if(this.threeMatch != 0) {
            lottoProfit = this.threeMatch * 5000;
        } else if(this.fourMatch != 0) {
            lottoProfit = this.fourMatch * 50000;
        } else if(this.fiveMatch != 0) {
            lottoProfit = this.fiveMatch * 1500000;
        } else if(this.sixMatch != 0) {
            lottoProfit = this.sixMatch * 2000000000;
        }
        float result = lottoProfit / cost;
        BigDecimal bd = BigDecimal.valueOf(result).
            setScale(2, RoundingMode.DOWN);
        return bd.toPlainString();
    }
    
    @Override
    public boolean equals(Object o) {
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        Winner winner = (Winner) o;
        return threeMatch == winner.threeMatch && fourMatch == winner.fourMatch && fiveMatch == winner.fiveMatch && sixMatch == winner.sixMatch;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(threeMatch, fourMatch, fiveMatch, sixMatch);
    }
}
