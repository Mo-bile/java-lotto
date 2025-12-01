package lotto.domain.model;

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {
    
    private final int value;
    private final static Map<Integer, LottoNumber> cache;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    
    static {
        cache = getLottoNumberMap();
    }
    
    private static Map<Integer, LottoNumber> getLottoNumberMap() {
        return IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
            .boxed()
            .collect(
                Collectors.toMap(
                    Function.identity(),
                    LottoNumber::new)
            );
    }
    
    private LottoNumber(String value) {
        this(Integer.parseInt(value));
    }
    
    private LottoNumber(int value) {
        this.value = value;
    }
    
    public static LottoNumber of(int value) {
        LottoNumber cachedLottoNumber = cache.get(value);
        validate(cachedLottoNumber);
        return cachedLottoNumber;
    }
    
    public static LottoNumber of(String value) {
        return of(Integer.parseInt(value));
    }
    
    public int getValue() {
        return value;
    }
    
    private static void validate(LottoNumber result) {
        if(result == null) {
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
