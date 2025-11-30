package calculator;

import calculator.Accumulator.AccumulatorController;

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
        AccumulatorController controller = new AccumulatorController();
        for(String currentSymbol: stringInput.extractArithmeticQueue()) {
            controller.extractOperator(currentSymbol);
            this.result = controller.accumulateNum(currentSymbol);
        }
        return this.result;
    }
    
}
