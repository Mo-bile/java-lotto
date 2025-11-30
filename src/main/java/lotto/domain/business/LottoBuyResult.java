package lotto.domain.business;

import java.util.List;
import lotto.domain.model.Lotto;
import lotto.domain.model.Manual;
import lotto.domain.model.Pay;

public class LottoBuyResult {
    
    private final Pay pay;
    private final Manual manual;
    
    public LottoBuyResult(int pay, int manualNumber, List<String> lottoNumbers) {
        this(new Pay(pay), new Manual(manualNumber, toLottoList(lottoNumbers)));
    }
    
    public LottoBuyResult(Pay pay, Manual manual) {
        validate(pay, manual);
        this.pay = pay;
        this.manual = manual;
    }
    
    private static List<Lotto> toLottoList(List<String> lottoNumbers) {
        return lottoNumbers.stream()
            .map(Lotto::new)
            .toList();
    }
    
    private void validate(Pay pay, Manual manual) {
        manual.validateLimit(pay.convertToBuyCount());
    }
}
