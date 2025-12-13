package lotto.domain.model;

public record BuyCount(int total, int manual, int auto) {
    
    public BuyCount {
        validate(total, manual, auto);
    }
    
    private void validate(int total, int manual, int auto) {
        if(total != (manual + auto)) {
            throw new IllegalArgumentException("지불금액 대비 구매수가 일치하지 않습니다.");
        }
    }
    
    public BuyCount add(BuyCount other) {
        return new BuyCount(
            this.total + other.total,
            this.manual + other.manual,
            this.auto + other.auto
        );
    }
    
    public static BuyCount empty() {
        return new BuyCount(0, 0, 0);
    }
    
}
