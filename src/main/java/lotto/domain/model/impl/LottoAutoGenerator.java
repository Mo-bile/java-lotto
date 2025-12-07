package lotto.domain.model.impl;

import java.util.List;
import lotto.domain.business.LottoBuy;
import lotto.domain.model.*;

public class LottoAutoGenerator implements LottoGenerator {
    
    int pay;
    
    public LottoAutoGenerator(String pay) {
        this(Integer.parseInt(pay));
    }
    
    public LottoAutoGenerator(int pay) {
        this.pay = pay;
    }
    
    @Override
    public LottoBuy generate() {
        return new LottoBuy(
            new BuyCount(getTotalNumber(pay), 0, getTotalNumber(pay)),
            new Manual(List.of()),
            new Auto(getTotalNumber(pay))
        );
    }
    
    private int getTotalNumber(int pay) {
        return new Pay(pay).convertToBuyCount();
    }
}
