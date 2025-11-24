package lotto.domain;

public enum Match {
    THREE_MATCH(3),
    FOUR_MATCH(4),
    FIVE_MATCH(5),
    SIX_MATCH(6);
    
    private final int matchNumber;
    
    Match(int matchNumber) {
        this.matchNumber = matchNumber;
    }
    
    public int getMatchNumber() {
        return matchNumber;
    }
    
    public static Match fromCount(int count) {
        for (Match m : values()) {
            if (m.matchNumber == count) return m;
        }
        return null;
    }
}