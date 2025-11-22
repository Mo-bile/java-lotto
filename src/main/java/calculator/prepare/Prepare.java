package calculator.prepare;

public class Prepare {
    private String operator;
    private int result;
    private int currentNum;
    private boolean firstNumber;
    
    public Prepare() {
        this(null, 0, 0, true);
    }
    
    public Prepare(String operator, int result, int currentNum, boolean firstNumber) {
        this.operator = operator;
        this.result = result;
        this.currentNum = currentNum;
        this.firstNumber = firstNumber;
    }
    
    public int getResult() {
        return result;
    }
    
    public void isNumber(String current) {
        if (current.matches("[0-9]+")) {
            this.currentNum = Integer.parseInt(current);
            firstNumDecider();
            calculateResult();
        }
    }
    
    private void firstNumDecider() {
        if (this.firstNumber) {
            this.result = this.currentNum;
            this.firstNumber = false;
        }
    }
    
    private void calculateResult() {
        if(this.operator != null) {
            switch (this.operator) {
                case "+" -> this.result = this.result + this.currentNum;
                case "-" -> this.result = this.result - this.currentNum;
                case "*" -> this.result = this.result * this.currentNum;
                case "/" -> this.result = this.result / this.currentNum;
            }
        }
    }
    
    public void getOperator(String current) {
        if (current.matches("[+\\-*/]")) {
            this.operator = current;
        }
    }
    
}
