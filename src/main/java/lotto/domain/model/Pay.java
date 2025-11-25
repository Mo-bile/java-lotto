package lotto.domain.model;

public class Pay {
    
    public static final int LOTTO_PRICE = 1000;
    private final int pay;
    
    public Pay(int pay) {
        validate(pay);
        this.pay = pay;
    }
    
    public int convertToBuyCount() {
        return this.pay / LOTTO_PRICE;
    }
    
    private static void validate(int pay) {
        if(pay % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("입력은 천원단위로 하시오");
        }
    }
}
