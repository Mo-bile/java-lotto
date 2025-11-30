package lotto.domain.business;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.model.*;

public record LottoBuy(BuyCount buyCount, Manual manual, Auto auto) {
    
    public LottoBuy(String pay, List<String> manualLottoNumbers) {
        this(Integer.parseInt(pay), manualLottoNumbers);
    }
    
    public LottoBuy(int pay, List<String> manualLottoNumbers) {
        this(new BuyCount(getTotalNumber(pay), manualLottoNumbers.size(), getTotalNumber(pay) - manualLottoNumbers.size()),
            new Manual(toLottoList(manualLottoNumbers)),
            new Auto(getTotalNumber(pay) - manualLottoNumbers.size()));
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
                this.manual.manualLottoList().stream(),
                this.auto.autoLottoList().stream())
            .toList());
    }
    
    public BuyCount combineBuyCount() {
        return this.buyCount;
    }
}
