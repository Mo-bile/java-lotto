package lotto.domain.model;

public class BuyCount {
    private final int total;
    private final int auto;
    private final int manual;
    
    public BuyCount(int total, int manual, int auto) {
        this.total = total;
        this.manual = manual;
        this.auto = auto;
    }
    
    public int getAuto() {
        return auto;
    }
    
    public int getManual() {
        return manual;
    }
}
