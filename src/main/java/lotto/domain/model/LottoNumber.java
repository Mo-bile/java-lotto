package lotto.domain.model;

public record LottoNumber(int value) {
    
    public LottoNumber {
        validate(value);
    }
    
    public boolean isSameNumber(Integer number) {
        return number == this.value;
    }
    
    private void validate(int bonusNumber) {
        if(bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("보너스 번호는 1~45사이 입력하시오");
        }
    }
}
