package lotto.view;

import java.util.List;
import lotto.domain.model.Lotto;
import lotto.domain.model.Winner;

public class ResultView {
    public static void printLottos(List<Lotto> lottoList) {
        System.out.println(lottoList.size() + "개를 구매했습니다.");
        
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
    }
    
    public static void printResult(Winner winner, String totalReturnRate) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.printf("3개 일치 (5000원)- %d개%n", winner.getThreeMatch());
        System.out.printf("4개 일치 (50000원)- %d개%n", winner.getFourMatch());
        System.out.printf("5개 일치 (1500000원)- %d개%n", winner.getFiveMatch());
        System.out.printf("6개 일치 (2000000000원)- %d개%n", winner.getSixMatch());
        System.out.printf("총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)%n",
            totalReturnRate);
    }
}
