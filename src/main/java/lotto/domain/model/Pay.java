package lotto.domain.model;

public class Pay {
    
    private final int pay;
    
    public Pay(int pay) {
        validate(pay);
        this.pay = pay;
    }
    
    public int convertToBuyCount() {
        return this.pay / 1000;
    }
    
    private static void validate(int pay) {
        if(pay % 1000 != 0) {
            throw new IllegalArgumentException("입력은 천원단위로 하시오");
        }
    }
}
