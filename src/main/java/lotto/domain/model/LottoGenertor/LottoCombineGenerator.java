package lotto.domain.model.LottoGenertor;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.model.BuyCount;
import lotto.domain.model.LottoTickets;
import lotto.domain.model.Pay;

public class LottoCombineGenerator implements LottoGenerator {
    
    private final List<LottoGenerator> generators;
    
    public LottoCombineGenerator(int pay, String manualLottoNumbers) {
        this(pay, List.of(manualLottoNumbers));
    }
    
    public LottoCombineGenerator(String pay, List<String> manualLottoNumbers) {
        this(Integer.parseInt(pay), manualLottoNumbers);
    }
    
    public LottoCombineGenerator(int pay, List<String> manualLottoNumbers) {
        this(toLottosGenerators(pay, manualLottoNumbers));
    }
    
    public LottoCombineGenerator(List<LottoGenerator> generators) {
        this.generators = generators;
    }
    
    @Override
    public LottoTickets generateTickets() {
        return new LottoTickets(generators.
            stream()
            .map(LottoGenerator::generateTickets)
            .flatMap(t -> t.tickets().stream())
            .toList());
    }
    
    private static List<LottoGenerator> toLottosGenerators(int pay, List<String> manualLottoNumbers) {
        int remainPay = new Pay(pay).calculateRemainingPayment(manualLottoNumbers.size());
        return Stream.of(
                new LottoManulGenerator(manualLottoNumbers),
                new LottoAutoGenerator(remainPay))
            .toList();
    }
    
    @Override
    public BuyCount getBuyCount() {
        return generators.stream()
            .map(LottoGenerator::getBuyCount)
            .reduce(BuyCount.empty(), BuyCount::add);
    }
}
