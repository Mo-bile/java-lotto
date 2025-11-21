package calculator;

public class StringInput {
 
    String input;
    
    public StringInput(String input) {
        validate(input);
        numValidate(input);
        symbolValidate(input);
        this.input = input;
    }
    
    private void validate(String input) {
        if(input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력 값이 null이거나 빈 공백 문자");
        }
    }
    
    private void numValidate(String input) {
        if(input.matches(".*\\d.*")) {
            return;
        }
        throw new IllegalArgumentException("숫자가 없습니다");
    }
    
    private void symbolValidate(String input) {
        if(input.matches(".*[+\\-*/].*")) {
            return;
        }
        throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
    }
    
}
