package calculator.Accumulator;

import static calculator.Accumulator.Accumulator.accumulateNumber;

public class AccumulatorController {
    
    public static final String NUMBER_REGEX = "[0-9]+";
    public static final String OPERATOR_REGEX = "[+\\-*/]";
    
    private String operator;
    private int previousNum;
    private int currentNum;
    private boolean isFirstNum;
    
    public AccumulatorController() {
        this(null, 0, 0, true);
    }
    
    public AccumulatorController(String operator, int previousNum, int currentNum, boolean isFirstNum) {
        this.operator = operator;
        this.previousNum = previousNum;
        this.currentNum = currentNum;
        this.isFirstNum = isFirstNum;
    }
    
    public int accumulateNum(String current) {
        if (current.matches(NUMBER_REGEX)) {
            this.currentNum = Integer.parseInt(current);
            isFirstNumDecider();
            this.previousNum = accumulateNumber(this.operator, this.previousNum, this.currentNum);
        }
        return this.previousNum;
    }
    
    public void extractOperator(String current) {
        if (current.matches(OPERATOR_REGEX)) {
            this.operator = current;
        }
    }
    
    private void isFirstNumDecider() {
        if (this.isFirstNum) {
            this.previousNum = this.currentNum;
            this.isFirstNum = false;
        }
    }
}
