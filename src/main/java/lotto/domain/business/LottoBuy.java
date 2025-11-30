package lotto.domain.business;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.model.*;

public class LottoBuy {
    private final BuyCount buyCount;
    private final Manual manual;
    private final Auto auto;
    
    public LottoBuy(String pay, List<String> manualLottoNumbers) {
        this(Integer.parseInt(pay), manualLottoNumbers);
    }
    
    public LottoBuy(int pay, List<String> manualLottoNumbers) {
        this(new BuyCount(getTotalNumber(pay), manualLottoNumbers.size(),getTotalNumber(pay) - manualLottoNumbers.size()),
            new Manual(toLottoList(manualLottoNumbers)),
            new Auto(getTotalNumber(pay) - manualLottoNumbers.size()));
    }
    
    public LottoBuy(BuyCount buyCount, Manual manual, Auto auto) {
        this.buyCount = buyCount;
        this.manual = manual;
        this.auto = auto;
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
        return new LottoTickets(Stream.concat(
            this.manual.getManualLottoList().stream(),
            this.auto.getAutoLottoList().stream())
            .toList());
    }
    
    public BuyCount combineBuyCount() {
        return this.buyCount;
    }
}
