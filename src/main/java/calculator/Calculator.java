package calculator;

import calculator.prepare.Prepare;

public class Calculator {
    
    private final StringInput stringInput;
    
    public Calculator(StringInput stringInput) {
        this.stringInput = stringInput;
    }
    
    public int calculate() {
        Prepare prepare = new Prepare();
        for(String current : stringInput.extractArithmeticQueue()) {
            prepare.isNumber(current);
            prepare.getOperator(current);
        }
        return prepare.getResult();
    }
    
}
