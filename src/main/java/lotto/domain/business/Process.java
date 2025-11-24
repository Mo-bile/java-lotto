package lotto.domain.business;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.model.Lotto;
import lotto.domain.model.Lottos;
import lotto.domain.model.WinnerCount;

public class Process {
    
    private final int pay;
    private final Lottos lottos;
    
    public Process(int pay) {
        this(pay, generateLottos(pay));
    }
    
    public Process(int pay, Lottos lottos) {
        validate(pay);
        this.pay = pay;
        this.lottos = lottos;
    }
    
    private static Lottos generateLottos(int pay) {
        return new Lottos(pay / 1000);
    }
    
    public List<Lotto> getLottos() {
        return this.lottos.getLottoList();
    }
    
    public WinnerCount showWinners(String winnerLottoNumber) {
        List<Integer> numbers = new ArrayList<>();
        for(String number: extractWinnerLottoNumber(winnerLottoNumber)) {
            numbers.add(Integer.parseInt(number));
        }
        return this.lottos.findWinners(new Lotto(numbers));
    }
    
    private String[] extractWinnerLottoNumber(String winnerLottoNumber) {
        return winnerLottoNumber.replace(" ", "").split(",");
    }
    
    private void validate(int pay) {
        if(pay % 1000 != 0) {
            throw new IllegalArgumentException("입력은 천원단위로 하시오");
        }
    }
}
