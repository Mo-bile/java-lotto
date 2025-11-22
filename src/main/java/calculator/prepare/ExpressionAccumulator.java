package calculator.prepare;

public class ExpressionAccumulator {
    
    public static final String NUMBER_REGEX = "[0-9]+";
    public static final String OPERATOR_REGEX = "[+\\-*/]";
    public static final String ADD_SYMBOL = "+";
    public static final String SUB_SYMBOL = "-";
    public static final String MULTIPLY_SYMBOL = "*";
    public static final String DIVISION_SYMBOL = "/";
    private String operator;
    private int previousNum;
    private int currentNum;
    private boolean isFirstNum;
    
    public ExpressionAccumulator() {
        this(null, 0, 0, true);
    }
    
    public ExpressionAccumulator(String operator, int previousNum, int currentNum, boolean isFirstNum) {
        this.operator = operator;
        this.previousNum = previousNum;
        this.currentNum = currentNum;
        this.isFirstNum = isFirstNum;
    }
    
    public int accumulateNum(String current) {
        if (current.matches(NUMBER_REGEX)) {
            this.currentNum = Integer.parseInt(current);
            firstNumDecider();
            calculateResult();
        }
        return this.previousNum;
    }
    
    public void extractOperator(String current) {
        if (current.matches(OPERATOR_REGEX)) {
            this.operator = current;
        }
    }
    
    private void firstNumDecider() {
        if (this.isFirstNum) {
            this.previousNum = this.currentNum;
            this.isFirstNum = false;
        }
    }
    
    private void calculateResult() {
        if(this.operator != null) {
            switch (this.operator) {
                case ADD_SYMBOL -> this.previousNum = this.previousNum + this.currentNum;
                case SUB_SYMBOL -> this.previousNum = this.previousNum - this.currentNum;
                case MULTIPLY_SYMBOL -> this.previousNum = this.previousNum * this.currentNum;
                case DIVISION_SYMBOL -> this.previousNum = this.previousNum / this.currentNum;
            }
        }
    }
}
