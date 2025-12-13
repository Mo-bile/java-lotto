package lotto.domain.model.LottoGenertor;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.model.BuyCount;
import lotto.domain.model.Lotto;
import lotto.domain.model.LottoTickets;
import lotto.domain.model.Pay;

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
        return new LottoTickets(generateLottos(getTotalNumber(pay)).stream().toList());
    }
    
    private List<Lotto> generateLottos(int num) {
        return IntStream
            .range(0, num)
            .mapToObj(i -> new Lotto())
            .toList();
    }
    
    @Override
    public BuyCount getBuyCount() {
        return new BuyCount(getTotalNumber(pay), 0, getTotalNumber(pay));
    }
    
    private int getTotalNumber(int pay) {
        return new Pay(pay).convertToBuyCount();
    }
}
