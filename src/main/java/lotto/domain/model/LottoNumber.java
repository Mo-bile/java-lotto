package lotto.domain.model;

import java.util.Objects;

public class LottoNumber{
    
    private final int value;
    
    private LottoNumber(String value) {
        this(Integer.parseInt(value));
    }
    
    private LottoNumber(int value) {
        validate(value);
        this.value = value;
    }
    
    public static LottoNumber of(int value) {
        return new LottoNumber(value);
    }
    
    public static LottoNumber of(String value) {
        return of(Integer.parseInt(value));
    }
    
    public int getValue() {
        return value;
    }
    
    private void validate(int value) {
        if(value < 1 || value > 45) {
            throw new IllegalArgumentException("로또 번호는 1~45사이 입력하시오");
        }
    }
    
    @Override
    public boolean equals(Object o) {
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
