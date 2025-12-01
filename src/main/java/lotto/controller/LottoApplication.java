package lotto.controller;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.business.LottoBuy;
import lotto.domain.business.LottoGame;
import lotto.domain.model.LottoGenerator;
import lotto.domain.model.WinningResult;
import lotto.domain.model.impl.LottoAutoGenerator;
import lotto.domain.model.impl.LottoCombineGenerator;
import lotto.domain.model.impl.LottoManulGenerator;
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
        
        LottoGenerator lottoGenerator = new LottoCombineGenerator();
        if(isAllAutoGenerate(manualCount)) {
            lottoGenerator = new LottoAutoGenerator();
        }
        if(isAllManualGenerate(manualCount, pay)) {
            lottoGenerator = new LottoManulGenerator();
        }
        List<String> manualLottoNumbers = readManualLottos(manualCount);
        LottoBuy lottoBuy = lottoGenerator.generate(pay, manualLottoNumbers);
        
        ResultView.printAutoManualCount(lottoBuy.combineBuyCount());
        LottoGame lottoGame = new LottoGame(pay, lottoBuy.combineLotto());
        ResultView.printLottos(lottoGame.getLottos());
        
        WinningResult winningResult = lottoGame.calculateWinningResult(InputView.inputWinningNumbers(), InputView.inputBonusNumbers());
        String totalReturn = winningResult.calculateTotalReturn(pay);
        ResultView.printResult(winningResult, totalReturn);
    }
    
    private static boolean isAllAutoGenerate(String manualCount) {
        return manualCount.equals("0");
    }
    
    private static boolean isAllManualGenerate(String manualCount, String pay) {
        return Integer.parseInt(manualCount) == Integer.parseInt(pay) / 1000;
    }
    
    private List<String> readManualLottos(String count) {
        if(count.isEmpty()) {
            throw new IllegalArgumentException("수동 구매 수는 0 이상의 숫자로 입력해 주세요.");
        }
        int manualCount = Integer.parseInt(count);
        if(manualCount > 0) {
            InputView.inputManulMessage();
        }
        return IntStream.range(0, manualCount)
            .mapToObj(i -> InputView.inputManulLotto())
            .toList();
    }
}
