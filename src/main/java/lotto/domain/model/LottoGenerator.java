package lotto.domain.model;

public interface LottoGenerator {
    
    LottoTickets generateTickets();
    
    BuyCount getBuyCount();
}
