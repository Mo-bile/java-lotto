package calculator.Accumulator;

public class Accumulator {
    public static final String ADD_SYMBOL = "+";
    public static final String SUB_SYMBOL = "-";
    public static final String MULTIPLY_SYMBOL = "*";
    public static final String DIVISION_SYMBOL = "/";
    
    public static int accumulateNumber(String operator, int previousNum, int currentNum) {
        if(operator != null) {
            switch (operator) {
                case ADD_SYMBOL -> previousNum = previousNum + currentNum;
                case SUB_SYMBOL -> previousNum = previousNum - currentNum;
                case MULTIPLY_SYMBOL -> previousNum = previousNum * currentNum;
                case DIVISION_SYMBOL -> previousNum = previousNum / currentNum;
            }
        }
        return previousNum;
    }
}
