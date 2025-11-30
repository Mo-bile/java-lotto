package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import lotto.domain.business.LottoBuy;
import lotto.domain.business.LottoGame;
import lotto.domain.model.WinningResult;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        new LottoApplication().run();
    }

    private void run() {
        while(true) {
            try {
                play();
                return;
            } catch(IllegalArgumentException e) {
                ResultView.printError(e.getMessage());
            }
        }
    }

    private void play() {
        String pay = InputView.inputPurchaseAmount();
        String manualCount = InputView.inputManulNumber();

        List<String> manualLottoNumbers = readManualLottos(manualCount);
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

    private List<String> readManualLottos(String count) {
        if(count.isEmpty()) {
            throw new IllegalArgumentException("수동 구매 수는 0 이상의 숫자로 입력해 주세요.");
        }
        int manualCount = Integer.parseInt(count);
        if(manualCount > 0) InputView.inputManulMessage();
        
        return IntStream.range(0, manualCount)
            .mapToObj(i -> InputView.inputManulLotto())
            .toList();
    }
}
