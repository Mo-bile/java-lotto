package lotto.domain.model.impl;

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
    public LottoTickets generateTickets() {
        return new LottoTickets(
            new Auto(getTotalNumber(pay)).autoLottoList().stream().toList()
        );
    }
    
    @Override
    public BuyCount getBuyCount() {
        return new BuyCount(getTotalNumber(pay), 0, getTotalNumber(pay));
    }
    
    private int getTotalNumber(int pay) {
        return new Pay(pay).convertToBuyCount();
    }
}
