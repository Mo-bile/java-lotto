package lotto.view;

import java.util.List;
import lotto.domain.Match;
import lotto.domain.model.Lotto;
import lotto.domain.model.WinningResult;

public class ResultView {
    public static void printLottos(List<Lotto> lottoList) {
        System.out.println(lottoList.size() + "개를 구매했습니다.");
        
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.numbers());
        }
    }
    
    public static void printResult(WinningResult winningResult, String totalReturnRate) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.printf("3개 일치 (5000원)- %d개%n", winningResult.getMatchCount(Match.THREE_MATCH));
        System.out.printf("4개 일치 (50000원)- %d개%n", winningResult.getMatchCount(Match.FOUR_MATCH));
        System.out.printf("5개 일치 (1500000원)- %d개%n", winningResult.getMatchCount(Match.FIVE_MATCH));
        System.out.printf("6개 일치 (2000000000원)- %d개%n", winningResult.getMatchCount(Match.SIX_MATCH));
        if (Double.parseDouble(totalReturnRate) < 1.0) {
            System.out.printf("총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)%n", totalReturnRate);
        } else {
            System.out.printf("총 수익률은 %s입니다.%n", totalReturnRate);
        }
    }
}
