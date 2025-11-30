package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.business.LottoBuy;
import lotto.domain.business.LottoGame;
import lotto.domain.model.WinningResult;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {
    
    public static void main(String[] args) {
        String pay = InputView.inputPurchaseAmount();
        String manualNumber = InputView.inputManulNumber();
        
        List<String> manualLottoNumbers = new ArrayList<>();
        if(manualNumber.isEmpty()) {
            InputView.inputManulMessage();
        }
        for(int i = 0; i < Integer.parseInt(manualNumber); i++) {
            manualLottoNumbers.add(InputView.inputManulLotto());
        }
        LottoBuy lottoBuy = new LottoBuy(pay, manualLottoNumbers);
        ResultView.printAutoManualCount(lottoBuy.combineBuyCount());
        
        LottoGame lottoGame = new LottoGame(pay, lottoBuy.combineLotto());
        ResultView.printLottos(lottoGame.getLottos());
        
        String winningNumbers = InputView.inputWinningNumbers();
        String bonusNumbers = InputView.inputBonusNumbers();
        WinningResult winningResult = lottoGame.calculateWinningResult(winningNumbers, bonusNumbers);
        String totalReturn = winningResult.calculateTotalReturn(pay);
        ResultView.printResult(winningResult, totalReturn);
    }
}
