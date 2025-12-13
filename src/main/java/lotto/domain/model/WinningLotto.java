package lotto.domain.model;

import lotto.domain.Rank;

public record WinningLotto(LottoNumber bonusNumber, Lotto winNumbers) {
    
    public WinningLotto(int bonusNumber, int... winNumbers) {
        this(LottoNumber.of(bonusNumber), new Lotto(winNumbers));
    }
    
    public WinningLotto(String bonusNumber, int... winNumbers) {
        this(LottoNumber.of(bonusNumber), new Lotto(winNumbers));
    }
    
    public WinningLotto(String bonusNumber, String winNumbers) {
        this(LottoNumber.of(bonusNumber), new Lotto(winNumbers));
    }
    
    public WinningLotto(int bonusNumber, String winNumbers) {
        this(LottoNumber.of(bonusNumber), new Lotto(winNumbers));
    }
    
    public WinningLotto {
        valid(winNumbers, bonusNumber);
    }
    
    private void valid(Lotto lotto, LottoNumber bonusNumber) {
        if(lotto.isContain(bonusNumber)) {
            throw new IllegalArgumentException("당첨번호 일부가 보너스 번호가 같습니다");
        }
    }
    
    public Rank rankDecide(Lotto lotto) {
        return Rank.valueOf(lotto.findMatchCount(winNumbers), lotto.isContain(bonusNumber));
    }
    
}
