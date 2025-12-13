package lotto.domain.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public record LottoTickets(List<Lotto> tickets) {
    
    public LottoTickets(Lotto... lottos) {
        this(generateLottos(lottos));
    }
    
    public LottoTickets(int num) {
        this(generateLottos(num));
    }
    
    public int getLottoTicketCount() {
        return tickets.size();
    }
    
    private static List<Lotto> generateLottos(int num) {
        return IntStream
            .range(0, num)
            .mapToObj(i -> new Lotto())
            .toList();
    }
    
    private static List<Lotto> generateLottos(Lotto... lottos) {
        return Arrays.asList(lottos);
    }
    
    public WinningResult identifyWinners(WinningLotto winningLotto) {
        WinningResult winningResult = new WinningResult();
        this.tickets.stream()
            .map(winningLotto::rankDecide)
            .forEach(winningResult::recordRank);
        return winningResult;
    }
    
}
