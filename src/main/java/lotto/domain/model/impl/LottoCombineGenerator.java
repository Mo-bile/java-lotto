package lotto.domain.model.impl;

import java.util.List;
import lotto.domain.business.LottoBuy;
import lotto.domain.model.*;

public class LottoCombineGenerator implements LottoGenerator {
    
    @Override
    public LottoBuy generate(int pay, List<String> manualLottoNumbers) {
        return
            new LottoBuy(
                new BuyCount(getTotalNumber(pay), manualLottoNumbers.size(), getTotalNumber(pay) - manualLottoNumbers.size()),
                new Manual(toLottoList(manualLottoNumbers)),
                new Auto(getTotalNumber(pay) - manualLottoNumbers.size())
            );
    }
    
    @Override
    public LottoBuy generate(String pay, List<String> manualLottoNumbers) {
        return generate(Integer.parseInt(pay), manualLottoNumbers);
    }
    
    @Override
    public LottoBuy generate(int pay) {
        throw new IllegalArgumentException("수동생성에는 수동 입력이 필요합니다.");
    }
    
    @Override
    public LottoBuy generate(String pay) {
        throw new IllegalArgumentException("수동생성에는 수동 입력이 필요합니다.");
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
