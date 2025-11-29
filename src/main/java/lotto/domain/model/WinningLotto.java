package lotto.domain.model;

import lotto.domain.Rank;

public record WinningLotto(Lotto winNumbers, LottoNumber bonusNumber) {
    
    public WinningLotto(int bonusNumber, int... winNumbers) {
        this(new Lotto(winNumbers), new LottoNumber(bonusNumber));
    }
    
    public WinningLotto(String bonusNumber, int... winNumbers) {
        this(new Lotto(winNumbers), new LottoNumber(bonusNumber));
    }
    
    public WinningLotto(String winNumbers, String bonusNumber) {
        this(new Lotto(winNumbers), new LottoNumber(bonusNumber));
    }
    
    public WinningLotto(String winNumbers, int bonusNumber) {
        this(new Lotto(winNumbers), new LottoNumber(bonusNumber));
    }
    
    public WinningLotto(Lotto WinNumbers) {
        this(WinNumbers, new LottoNumber(1));
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
        return calculateWinningRank(lotto.findMatchCount(winNumbers), lotto.isContain(bonusNumber));
    }
    
    public Rank calculateWinningRank(int matchCount, boolean bonusMatch) {
        if(Rank.isSecondOrThird(matchCount)) {
            if(bonusMatch) {
                return Rank.SECOND;
            }
            return Rank.THIRD;
        }
        return Rank.getRank(matchCount);
    }
}
