package lotto.controller;

import lotto.domain.business.Process;
import lotto.domain.model.WinnerCount;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {
    
    public static void main(String[] args) {
        int amount = InputView.inputPurchaseAmount();
        
        Process process = new Process(amount);
        ResultView.printLottos(process.getLottos());
        
        String winningNumbers = InputView.inputWinningNumbers();
        WinnerCount winnerCount = process.showWinners(winningNumbers);
        String totalReturn = winnerCount.calculateTotalReturn(amount);
        ResultView.printResult(winnerCount, totalReturn);
    }
}
