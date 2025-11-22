package calculator;

import java.util.List;

public class Calculator {
    
    List<String> ArithmeticQueue;
    
    public Calculator(List<String> arithmeticQueue) {
        ArithmeticQueue = arithmeticQueue;
    }
    
    public int calculate() {
        int result = 0;
        String operator = null;
        boolean firstNumber = true;
        
        for(String current : ArithmeticQueue) {
            if (current.matches("[0-9]+")) {
                int num = Integer.parseInt(current);
                
                if (firstNumber) {
                    result = num;
                    firstNumber = false;
                } else {
                    switch (operator) {
                        case "+" -> result = result + num;
                        case "-" -> result = result - num;
                        case "*" -> result = result * num;
                        case "/" -> result = result / num;
                    }
                }
            }
            else if (current.matches("[+\\-*/]")) {
                operator = current;
            }
        }
        return result;
    }
    
}
