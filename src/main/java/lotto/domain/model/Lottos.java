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
    
//    public List<Lotto> findWinners(Lotto winlotto) {
//        List<Lotto> winLottoList = new ArrayList<>();
//        boolean contains = this.lottoList.contains(winlotto);
//
//        if(contains) {
//            for(Lotto lotto: lottoList) {
//                if(lotto.equals(winlotto)) {
//                    winLottoList.add(lotto);
//                }
//            }
//            return winLottoList;
//        }
//        return winLottoList;
//    }
    
    private static List<Lotto> generateLottos(int num) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < num; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }
}
