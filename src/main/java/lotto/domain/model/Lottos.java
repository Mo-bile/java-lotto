package lotto.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    
    private final List<Lotto> lottoList;
    
    public Lottos(int num) {
        this(generateLottos(num));
    }
    
    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }
    
    public List<Lotto> getLottoList() {
        return this.lottoList;
    }
    
    private static List<Lotto> generateLottos(int num) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < num; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }
    
    public Winner findWinners(List<Lotto> lottoList) {
        int threeMatch = 0;
        int fourMatch = 0;
        int fiveMatch = 0;
        int sixMatch = 0;
        for(Lotto lotto: lottoList) {
            int matchNumbers = lotto.findMatchNumbers(lotto.getNumbers());
            if(matchNumbers == 2) {
                threeMatch ++;
            } else if(matchNumbers == 3) {
                fourMatch ++;
            } else if(matchNumbers == 4) {
                fiveMatch ++;
            } else if(matchNumbers == 5) {
                sixMatch++;
            }
        }
        return new Winner(threeMatch, fourMatch, fiveMatch, sixMatch);
    }
    
}
