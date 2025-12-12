package lotto.controller;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.business.LottoGame;
import lotto.domain.model.LottoGenertor.LottoCombineGenerator;
import lotto.domain.model.LottoGenertor.LottoGenerator;
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
        LottoGenerator lottoGenerator = new LottoCombineGenerator(pay, manualLottoNumbers);
        
        ResultView.printAutoManualCount(lottoGenerator.getBuyCount());
        LottoGame lottoGame = new LottoGame(pay, lottoGenerator.generateTickets());
        ResultView.printLottos(lottoGame.getLottos());
        
        WinningResult winningResult = lottoGame.calculateWinningResult(InputView.inputWinningNumbers(), InputView.inputBonusNumbers());
        String totalReturn = winningResult.calculateTotalReturn(pay);
        ResultView.printResult(winningResult, totalReturn);
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
