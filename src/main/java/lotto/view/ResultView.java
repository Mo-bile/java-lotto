package lotto.view;

import java.util.List;
import lotto.domain.model.Lotto;

public class ResultView {
    public static void printLottos(List<Lotto> lottoList) {
        System.out.println(lottoList.size() + "개를 구매했습니다.");
        
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
    }
}
