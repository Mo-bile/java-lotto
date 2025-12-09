package lotto.domain.model.impl;

import java.util.List;
import lotto.domain.model.*;

public class LottoManulGenerator implements LottoGenerator {
    
    private final List<Lotto> manualLottoNumbers;
    
    public LottoManulGenerator(String manualLottoNumbers) {
        this(List.of(manualLottoNumbers));
    }
    
    public LottoManulGenerator(List<String> manualLottoNumbers) {
        this.manualLottoNumbers = toLottoList(manualLottoNumbers);
    }
    
    @Override
    public LottoTickets generateTickets() {
        return new LottoTickets(manualLottoNumbers);
    }
    
    @Override
    public BuyCount getBuyCount() {
        return new BuyCount(manualLottoNumbers.size(), manualLottoNumbers.size(), 0);
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
