package lotto.controller;

import lotto.domain.business.LottoGame;
import lotto.domain.model.WinningResult;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {
    
    public static void main(String[] args) {
        int pay = InputView.inputPurchaseAmount();
        
        LottoGame lottoGame = new LottoGame(pay);
        ResultView.printLottos(lottoGame.getLottos());
        
        String winningNumbers = InputView.inputWinningNumbers();
        WinningResult winningResult = lottoGame.showWinners(winningNumbers);
        String totalReturn = winningResult.calculateTotalReturn(pay);
        ResultView.printResult(winningResult, totalReturn);
    }
}
