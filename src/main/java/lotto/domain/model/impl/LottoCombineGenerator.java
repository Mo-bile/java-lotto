package lotto.domain.model.impl;

import java.util.List;
import lotto.domain.business.LottoBuy;
import lotto.domain.model.*;

public class LottoCombineGenerator implements LottoGenerator {
    
    private final int pay;
    private final List<Lotto> manualLottoNumbers;
    
    public LottoCombineGenerator(int pay, String manualLottoNumbers) {
        this(pay, List.of(manualLottoNumbers));
    }
    
    public LottoCombineGenerator(String pay, List<String> manualLottoNumbers) {
        this(Integer.parseInt(pay), manualLottoNumbers);
    }
    
    public LottoCombineGenerator(int pay, List<String> manualLottoNumbers) {
        this.pay = pay;
        this.manualLottoNumbers = toLottoList(manualLottoNumbers);
    }
    
    @Override
    public LottoBuy generate() {
        return
            new LottoBuy(
                new BuyCount(getTotalNumber(pay), manualLottoNumbers.size(), getTotalNumber(pay) - manualLottoNumbers.size()),
                new Manual(manualLottoNumbers),
                new Auto(getTotalNumber(pay) - manualLottoNumbers.size())
            );
    }
    
    private static int getTotalNumber(int pay) {
        return new Pay(pay).convertToBuyCount();
    }
    
    private static List<Lotto> toLottoList(List<String> lottoNumbers) {
        return lottoNumbers.stream()
            .map(Lotto::new)
            .toList();
    }
}
