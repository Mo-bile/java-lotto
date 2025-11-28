package lotto.domain.model;

public class Bonus {
    
    private final int bonusNumber;
    
    public Bonus(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }
    
    public boolean isSameNumber(Integer number) {
        return number == this.bonusNumber;
    }
    
    private void validate(int bonusNumber) {
        if(bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("보너스 번호는 1~45사이 입력하시오");
        }
    }
}
