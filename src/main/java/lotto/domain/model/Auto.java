package lotto.domain.model;

import java.util.List;
import java.util.stream.IntStream;

public class Auto {
    
    private final int autoNumber;
    private final List<Lotto> autoLottoList;
    
    public Auto(int autoNumber) {
        this(autoNumber, generateLottos(autoNumber));
    }
    
    public Auto(int autoNumber, List<Lotto> autoLottoList) {
        this.autoNumber = autoNumber;
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
