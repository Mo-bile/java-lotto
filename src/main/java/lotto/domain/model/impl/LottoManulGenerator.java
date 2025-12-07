package lotto.domain.model.impl;

import java.util.List;
import lotto.domain.business.LottoBuy;
import lotto.domain.model.*;

public class LottoManulGenerator implements LottoGenerator {
    
    private final int pay;
    private final List<Lotto> manualLottoNumbers;
    
    public LottoManulGenerator(int pay, String manualLottoNumbers) {
        this(pay, List.of(manualLottoNumbers));
    }
    
    public LottoManulGenerator(String pay, List<String> manualLottoNumbers) {
        this(Integer.parseInt(pay), manualLottoNumbers);
    }
    
    public LottoManulGenerator(int pay, List<String> manualLottoNumbers) {
        this.pay = pay;
        this.manualLottoNumbers = toLottoList(manualLottoNumbers);
    }
    
    @Override
    public LottoBuy generate() {
        return new LottoBuy(
            new BuyCount(getTotalNumber(pay), manualLottoNumbers.size(), 0),
            new Manual(manualLottoNumbers),
            new Auto(0)
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
