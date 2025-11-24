package lotto.domain;

public enum Match {
    THREE_MATCH(3),
    FOUR_MATCH(4),
    FIVE_MATCH(5),
    SIX_MATCH(6);
    
    private final int count;
    
    Match(int count) {
        this.count = count;
    }
    
    public int getCount() {
        return count;
    }
    
    public static Match fromCount(int count) {
        for (Match m : values()) {
            if (m.count == count) return m;
        }
        return null;
    }
}