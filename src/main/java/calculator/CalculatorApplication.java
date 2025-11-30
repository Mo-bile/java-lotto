package calculator;

import java.util.Scanner;

public class CalculatorApplication {
    
    public static void main(String[] args) {
        String inputNum = inputNum();
        
        Calculator calculator = new Calculator(new StringInput(inputNum));
        int result = calculator.calculate();
        
        System.out.println("result = " + result);
    }
    
    public static String inputNum() {
        System.out.println("계산할 문자열을 입력하시오");
        return inputString();
    }
    
    private static String inputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
