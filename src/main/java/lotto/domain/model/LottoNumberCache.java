package lotto.domain.model;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberCache {
    
    private final static Map<Integer, LottoNumber> cache;
    
    static {
        cache = getLottoNumberMap();
    }
    
    private static Map<Integer, LottoNumber> getLottoNumberMap() {
        return IntStream.range(1, 46)
            .boxed()
            .collect(
                Collectors.toMap(
                    Function.identity(),
                    LottoNumber::new)
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
