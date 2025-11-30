package lotto.domain.model;

public record Pay(int pay) {
    
    public static final int LOTTO_PRICE = 1000;
    
    public Pay(String pay) {
        this(Integer.parseInt(pay));
    }
    
    public Pay {
        validate(pay);
        positiveValidate(pay);
    }
    
    public int convertToBuyCount() {
        return this.pay / LOTTO_PRICE;
    }
    
    private static void validate(int pay) {
        if(pay % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("입력은 천원단위로 하시오");
        }
    }
    
    private static void positiveValidate(int pay) {
        if(pay <= 0) {
            throw new IllegalArgumentException("금액은 양수로 입력하시오");
        }
    }
}
