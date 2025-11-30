package lotto.domain.model;

import java.util.List;

public class Manual {
    
    private final List<Lotto> manualLottoList;
    
    public Manual(List<Lotto> manualLottoList) {
        this.manualLottoList = manualLottoList;
    }
    
    public List<Lotto> getManualLottoList() {
        return manualLottoList;
    }
}
