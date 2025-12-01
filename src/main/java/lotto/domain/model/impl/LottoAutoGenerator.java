package lotto.domain.model.impl;

import java.util.List;
import lotto.domain.business.LottoBuy;
import lotto.domain.model.*;

public class LottoAutoGenerator implements LottoGenerator {
    
    @Override
    public LottoBuy generate(int pay, List<String> manualLottoNumbers) {
        return new LottoBuy(
            new BuyCount(getTotalNumber(pay), 0, getTotalNumber(pay)),
            new Manual(List.of()),
            new Auto(getTotalNumber(pay))
        );
    }
    
    @Override
    public LottoBuy generate(String pay, List<String> manualLottoNumbers) {
        return generate(Integer.parseInt(pay), manualLottoNumbers);
    }
    
    @Override
    public LottoBuy generate(int pay) {
        return new LottoBuy(
            new BuyCount(getTotalNumber(pay), 0, getTotalNumber(pay)),
            new Manual(List.of()),
            new Auto(getTotalNumber(pay))
        );
    }
    
    @Override
    public LottoBuy generate(String pay) {
        return generate(Integer.parseInt(pay));
    }
    
    private int getTotalNumber(int pay) {
        return new Pay(pay).convertToBuyCount();
    }
}
