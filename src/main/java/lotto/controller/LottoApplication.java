package lotto.controller;

import lotto.domain.business.Process;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {
    
    public static void main(String[] args) {
        int amount = InputView.inputPurchaseAmount();
        
        Process process = new Process(amount);
        ResultView.printLottos(process.getLottos());
        
    }
}
