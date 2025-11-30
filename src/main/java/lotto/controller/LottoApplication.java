package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.business.LottoBuyResult;
import lotto.domain.business.LottoGame;
import lotto.domain.model.LottoTickets;
import lotto.domain.model.WinningResult;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {
    
    public static void main(String[] args) {
        int pay = InputView.inputPurchaseAmount();
        int manualNumber = InputView.inputManulNumber();
        
        List<String> manualLottoNumbers = new ArrayList<>();
        for(int i = 0; i < manualNumber; i++) {
            manualLottoNumbers.add(InputView.inputManulLotto());
        }
        LottoTickets lottoTickets = new LottoBuyResult(pay, manualNumber, manualLottoNumbers).combineLotto();
        
        
        LottoGame lottoGame = new LottoGame(pay, lottoTickets);
        ResultView.printLottos(lottoGame.getLottos());
        
        String winningNumbers = InputView.inputWinningNumbers();
        int bonusNumbers = InputView.inputBonusNumbers();
        WinningResult winningResult = lottoGame.calculateWinningResult(winningNumbers, bonusNumbers);
        String totalReturn = winningResult.calculateTotalReturn(pay);
        ResultView.printResult(winningResult, totalReturn);
    }
}
