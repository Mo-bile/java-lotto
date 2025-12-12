package lotto.domain.model.LottoGenertor;

import java.util.List;
import lotto.domain.model.BuyCount;
import lotto.domain.model.Lotto;
import lotto.domain.model.LottoTickets;

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
    
    private static List<Lotto> toLottoList(List<String> lottoNumbers) {
        return lottoNumbers.stream()
            .map(Lotto::new)
            .toList();
    }
}
