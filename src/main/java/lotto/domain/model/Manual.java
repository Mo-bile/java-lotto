package lotto.domain.model;

import java.util.List;

public class Manual {
    
    private final int manualNumber;
    private final List<Lotto> manualLottoList;
    
    public Manual(String manulNumber, List<Lotto> manualLottoList) {
        this(Integer.parseInt(manulNumber), manualLottoList);
    }
    
    public Manual(int manulNumber, List<Lotto> manualLottoList) {
        validateDifference(manulNumber, manualLottoList);
        this.manualNumber = manulNumber;
        this.manualLottoList = manualLottoList;
    }
    
    public List<Lotto> getManualLottoList() {
        return manualLottoList;
    }
    
    private void validateDifference(int manulNumber, List<Lotto> manulLottoList) {
        if(manulNumber != manulLottoList.size()) {
            throw new IllegalArgumentException("수동 구매 갯수와 수동 입력 로또 수가 다르다.");
        }
    }
    
    public void validateLimit(int buyCount) {
        if(buyCount < this.manualNumber) {
            throw new IllegalArgumentException("수동구매 갯수가 구매가능갯수보다 많다.");
        }
    }
}
