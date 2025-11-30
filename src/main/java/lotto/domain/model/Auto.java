package lotto.domain.model;

import java.util.List;
import java.util.stream.IntStream;

public record Auto(List<Lotto> autoLottoList) {
    
    public Auto(int autoNumber) {
        this(generateLottos(autoNumber));
    }
    
    private static List<Lotto> generateLottos(int num) {
        return IntStream
            .range(0, num)
            .mapToObj(i -> new Lotto())
            .toList();
    }
    
}
