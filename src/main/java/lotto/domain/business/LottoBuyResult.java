package lotto.domain.business;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.model.*;

public class LottoBuyResult {
    
    private final Pay pay;
    private final Manual manual;
    private final Auto auto;
    
    public LottoBuyResult(int pay, int manualNumber, List<String> lottoNumbers) {
        this(new Pay(pay),
            new Manual(manualNumber, toLottoList(lottoNumbers)),
            new Auto(getAutoNumber(pay, manualNumber)));
    }
    
    private static int getAutoNumber(int pay, int manualNumber) {
        return new Pay(pay).convertToBuyCount() - manualNumber;
    }
    
    public LottoBuyResult(Pay pay, Manual manual, Auto auto) {
        validate(pay, manual);
        this.pay = pay;
        this.manual = manual;
        this.auto = auto;
    }
    
    private static List<Lotto> toLottoList(List<String> lottoNumbers) {
        return lottoNumbers.stream()
            .map(Lotto::new)
            .toList();
    }
    
    public Pay getPay() {
        return pay;
    }
    
    public LottoTickets combineLotto() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.addAll(this.manual.getManualLottoList());
        lottoList.addAll(this.auto.getAutoLottoList());
        return new LottoTickets(lottoList);
    }
    
    private void validate(Pay pay, Manual manual) {
        manual.validateLimit(pay.convertToBuyCount());
    }
}
