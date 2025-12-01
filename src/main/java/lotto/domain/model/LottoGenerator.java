package lotto.domain.model;

import java.util.List;
import lotto.domain.business.LottoBuy;

public interface LottoGenerator {
    
    LottoBuy generate(int pay, List<String> manualLottoNumbers);
    
    LottoBuy generate(String pay, List<String> manualLottoNumbers);
    
    LottoBuy generate(int pay);
    
    LottoBuy generate(String pay);
}
