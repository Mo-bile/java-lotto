package lotto.domain.model;

import java.util.List;
import java.util.stream.IntStream;

public class Auto {
    
    private final List<Lotto> autoLottoList;
    
    public Auto(int autoNumber) {
        this(generateLottos(autoNumber));
    }
    
    public Auto(List<Lotto> autoLottoList) {
        this.autoLottoList = autoLottoList;
    }
    
    private static List<Lotto> generateLottos(int num) {
        return IntStream
            .range(0, num)
            .mapToObj(i -> new Lotto())
            .toList();
    }
    
    public List<Lotto> getAutoLottoList() {
        return autoLottoList;
    }
    
}
