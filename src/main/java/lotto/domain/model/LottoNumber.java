package lotto.domain.model;

public record LottoNumber(int value) {
    
    public LottoNumber(String value) {
        this(Integer.parseInt(value));
    }
    
    public LottoNumber {
        validate(value);
    }
    
    private void validate(int value) {
        if(value < 1 || value > 45) {
            throw new IllegalArgumentException("보너스 번호는 1~45사이 입력하시오");
        }
    }
}
