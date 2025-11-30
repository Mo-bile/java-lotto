package lotto.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberCache {
    
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
                    LottoNumber::of)
            );
    }
    
    public static LottoNumber getLottoNumber(String lottoNumber) {
        return getLottoNumber(Integer.parseInt(lottoNumber));
    }
    
    public static LottoNumber getLottoNumber(int lottoNumber) {
        LottoNumber cachedLottoNumber = cache.get(lottoNumber);
        validate(cachedLottoNumber);
        return cachedLottoNumber;
    }
    
    private static void validate(LottoNumber result) {
        if(result == null) {
            throw new IllegalArgumentException("로또 번호는 1~45사이 입력하시오");
        }
    }
}
