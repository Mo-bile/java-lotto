package calculator;

import calculator.prepare.ExpressionAccumulator;

public class Calculator {
    
    private final StringInput stringInput;
    private int result;
    
    public Calculator(StringInput stringInput) {
        this(stringInput, 0);
    }
    
    public Calculator(StringInput stringInput, int result) {
        this.stringInput = stringInput;
        this.result = result;
    }
    
    public int calculate() {
        ExpressionAccumulator accumulator = new ExpressionAccumulator();
        for(String current : stringInput.extractArithmeticQueue()) {
            accumulator.extractOperator(current);
            this.result = accumulator.accumulateNum(current);
        }
        return this.result;
    }
    
}
