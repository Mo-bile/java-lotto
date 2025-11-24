package lotto.controller;

import lotto.domain.business.Process;
import lotto.domain.model.WinnerCount;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {
    
    public static void main(String[] args) {
        int pay = InputView.inputPurchaseAmount();
        
        Process process = new Process(pay);
        ResultView.printLottos(process.getLottos());
        
        String winningNumbers = InputView.inputWinningNumbers();
        WinnerCount winnerCount = process.showWinners(winningNumbers);
        String totalReturn = winnerCount.calculateTotalReturn(pay);
        ResultView.printResult(winnerCount, totalReturn);
    }
}
