package lotto.domain.model;

public record BuyCount(int total, int manual, int auto) {
    
    public BuyCount {
        validate(total, manual, auto);
    }
    
    void validate(int total, int manual, int auto) {
        if(total != (manual + auto)) {
            throw new IllegalArgumentException("지불금액 대비 구매수가 일치하지 않습니다.");
        }
    }
}
