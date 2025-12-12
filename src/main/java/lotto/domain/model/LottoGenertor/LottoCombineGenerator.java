package lotto.domain.model.LottoGenertor;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import lotto.domain.model.BuyCount;
import lotto.domain.model.Lotto;
import lotto.domain.model.LottoTickets;
import lotto.domain.model.Pay;

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
    public LottoTickets generateTickets() {
        return new LottoTickets(Stream.
            concat(
                manualLottoNumbers.stream(),
                generateLottos(getTotalNumber(pay)).stream()
            ).toList());
    }
    
    @Override
    public BuyCount getBuyCount() {
        return new BuyCount(getTotalNumber(pay), manualLottoNumbers.size(), getTotalNumber(pay) - manualLottoNumbers.size());
    }
    
    private List<Lotto> generateLottos(int num) {
        return IntStream
            .range(0, num)
            .mapToObj(i -> new Lotto())
            .toList();
    }
    
    private int getTotalNumber(int pay) {
        return new Pay(pay).convertToBuyCount();
    }
    
    private static List<Lotto> toLottoList(List<String> lottoNumbers) {
        return lottoNumbers.stream()
            .map(Lotto::new)
            .toList();
    }
}
