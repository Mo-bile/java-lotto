package lotto.domain.business;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.model.*;

public class LottoBuyResult {
    private final BuyCount buyCount;
    private final Manual manual;
    private final Auto auto;
    
    public LottoBuyResult(int pay, List<String> manualLottoNumbers) {
        this(new Manual(toLottoList(manualLottoNumbers)),
            new Auto(getTotalNumber(pay) - manualLottoNumbers.size()),
            new BuyCount(getTotalNumber(pay), manualLottoNumbers.size(), getTotalNumber(pay) - manualLottoNumbers.size())
        );
    }
    
    public LottoBuyResult(Manual manual, Auto auto, BuyCount buyCount) {
        this.manual = manual;
        this.auto = auto;
        this.buyCount = buyCount;
    }
    
    private static int getTotalNumber(int pay) {
        return new Pay(pay).convertToBuyCount();
    }
    
    private static List<Lotto> toLottoList(List<String> lottoNumbers) {
        return lottoNumbers.stream()
            .map(Lotto::new)
            .toList();
    }
    
    public LottoTickets combineLotto() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.addAll(this.manual.getManualLottoList());
        lottoList.addAll(this.auto.getAutoLottoList());
        return new LottoTickets(lottoList);
    }
    
    public BuyCount combineBuyCount() {
        return this.buyCount;
    }
}
