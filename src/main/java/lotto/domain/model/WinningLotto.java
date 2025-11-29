package lotto.domain.model;

public record WinningLotto(Lotto winNumbers, LottoNumber bonusNumber) {
    
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
}
