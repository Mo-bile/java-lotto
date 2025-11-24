package lotto.domain;

import lotto.domain.model.WinnerCount;

public enum Match {
    THREE_MATCH(3, 5_000){
        @Override
        public void increase(WinnerCount winnerCount) {
            winnerCount.increaseThree();
        }
    },
    FOUR_MATCH(4, 50_000){
        @Override
        public void increase(WinnerCount winnerCount) {
            winnerCount.increaseFour();
        }
    },
    FIVE_MATCH(5, 1_500_000){
        @Override
        public void increase(WinnerCount winnerCount) {
            winnerCount.increaseFive();
        }
    },
    SIX_MATCH(6, 2_000_000_000){
        @Override
        public void increase(WinnerCount winnerCount) {
            winnerCount.increaseSix();
        }
    };
    
    private final int matchNumber;
    private final long winnerReturn;
    
    Match(int matchNumber, long winnerReturn) {
        this.matchNumber = matchNumber;
        this.winnerReturn = winnerReturn;
    }
    
    public static Match fromLottoNumber(int lottoNumber) {
        for (Match m : values()) {
            if (m.matchNumber == lottoNumber) return m;
        }
        return null;
    }
    
    public long getWinnerReturn() {
        return winnerReturn;
    }
    
    public abstract void increase(WinnerCount winnerCount);
    
}